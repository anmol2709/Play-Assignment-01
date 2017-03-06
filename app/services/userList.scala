package services

import sun.security.util.Password

import scala.collection.mutable.ListBuffer


object UserList {
  val user1=controllers.User("Anmol","","Sarna","anmol","anmol","anmol","9971783971","male",24,"Cricket")
  val userList=ListBuffer[controllers.User](user1)
  def addUser(user:controllers.User):ListBuffer[controllers.User]={
    userList+=user
  }

  def getUser(name:String,password: String):controllers.User={
    userList.filter(x=>(x.userName==name && x.password==password))(0)
  }

  def checkUser(name:String,password: String):Boolean={
    userList.filter(x=>(x.userName==name && x.password==password)).length>=1
  }

}

