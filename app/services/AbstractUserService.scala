package services

import models.User
import play.api.cache.CacheApi
import sun.security.util.Password

import scala.collection.mutable.ListBuffer


abstract class AbstractUserService(){
  def addUser(user:User):Boolean


  def getUser(name:String):User


  def checkUser(name:String,password: String):Boolean

  def userExist(name:String):Boolean

  def enable(userName:String):Boolean



  def disable(userName:String):Boolean


  def getList():ListBuffer[User]
}
