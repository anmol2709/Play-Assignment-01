package services

import models.User
import sun.security.util.Password

import scala.collection.mutable.ListBuffer


object UserList {
  val user1=User("Anmol","","Sarna","anmol","anmol","anmol",true,true,"9971783971","male",24,"Cricket")
  val userList=ListBuffer[User](user1)
  def addUser(user:User):ListBuffer[User]={
    userList+=user
  }

  def getUser(name:String,password: String):User={
    userList.filter(x=>(x.userName==name && x.password==password))(0)
  }

  def checkUser(name:String,password: String):Boolean={
    userList.filter(x=>(x.userName==name && x.password==password)).length>=1
  }

}

