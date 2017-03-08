package services

import javax.inject.Inject

import models.User
import play.api.cache.CacheApi

import scala.collection.mutable.ListBuffer


class UserService@Inject() (cache: CacheApi) extends AbstractUserService {
  cache.set("list",ListBuffer[User]())
  val userNew = User("Anmol", "", "Sarna", "anmol", "anmol", "anmol" ,true , true,"9971783971", "male", 24, "Cricket")
  val userNew2 = User("Anmol", "", "Sarna", "anmolSarna", "anmol", "anmol" ,true , true,"9971783971", "male", 24, "Cricket")
  addUser(userNew)
  addUser(userNew2)


  def addUser(user: User): Boolean = {
    val userList:ListBuffer[User] = cache.get[ListBuffer[User]]("list").getOrElse(ListBuffer[User]())
    println("value: "+user.userRole)
    try{val encryptedUser=user.copy(password = MD5.hash(user.password))
    userList.append(encryptedUser)
    cache.set("list",userList)
    true}
    catch{
      case e:Exception => false
    }
  }


  def getUser(name: String): User = {
    val userList:ListBuffer[User] = cache.get[ListBuffer[User]]("list").getOrElse(ListBuffer[User]())
    if(userList.filter(x=>(x.userName==name)).length==1) {

      userList.filter(x=>(x.userName==name))(0)
    } else
      userNew

  }

  def userExist(name:String):Boolean={
    val userList:ListBuffer[User] = cache.get[ListBuffer[User]]("list").getOrElse(ListBuffer[User]())

    if(userList.filter(x=>(x.userName==name)).length==1)
      false
    else true
  }

  def checkUser(name: String,password:String): Boolean = {
    val userList:ListBuffer[User] = cache.get[ListBuffer[User]]("list").getOrElse(ListBuffer[User]())
    userList.filter(x=>(x.userName==name&&x.password==MD5.hash(password))).length==1

  }

   def getList():ListBuffer[User]={
     cache.get[ListBuffer[User]]("list").getOrElse(ListBuffer[User]())
   }

  def enable(userName:String)={
    val userList:ListBuffer[User] = cache.get[ListBuffer[User]]("list").getOrElse(ListBuffer[User]())

    val oldUser:User=userList.filter(_.userName==userName)(0)
    val newUser=oldUser.copy(isEnabled=true)
    userList-=oldUser
    userList+=newUser

true
  }

  def disable(userName:String)={


    val userList:ListBuffer[User] = cache.get[ListBuffer[User]]("list").getOrElse(ListBuffer[User]())

    val oldUser:User=userList.filter(_.userName==userName)(0)
    val newUser=oldUser.copy(isEnabled=false)
    userList-=oldUser
    userList+=newUser
true
  }

}

