
import models.User
import org.scalatest.mock.MockitoSugar
import org.scalatestplus.play._
import play.api.cache.CacheApi
import play.api.test._
import play.api.test.Helpers._
import services.{MD5, UserService, AbstractUserService}

import org.mockito.Mockito._

import scala.collection.mutable
import scala.collection.mutable.ListBuffer


class ServiceSpec extends PlaySpec with MockitoSugar {

  "UserService" should {
    "get list" in {
      val cache = mock[CacheApi]
      val md5 = mock[MD5]
      val userService = new UserService(cache, md5)
      // when(cache.set("list",ListBuffer[User]()))// thenReturn()
      when(cache.get[ListBuffer[User]]("list")) thenReturn (Option(ListBuffer[User]()))
      userService.getList() mustBe ListBuffer[User]()
    }



        "get user" in {
          val cache = mock[CacheApi]
          val md5 = mock[MD5]
          val userNew = User("Anmol", "", "Sarna", "anmol1", "anmol", "anmol" ,true , true,"9971783971", "male", 24, "Cricket")
          val userService = new UserService(cache, md5)
          //      cache.set("list",ListBuffer[User](userNew))
          when(cache.get[ListBuffer[User]]("list")) thenReturn(Option(ListBuffer[User](userNew)))
          userService.getUser("anmol1") mustBe(userNew)
        }


    "add user" in {
      val cache = mock[CacheApi]
      val md5 = mock[MD5]
      val userNew = User("Anmol", "", "Sarna", "anmol", "anmol", "anmol", true, true, "9971783971", "male", 24, "Cricket")
      val userService = new UserService(cache, md5)
      //      cache.set("list",ListBuffer[User](userNew))
      when(md5.hash("")) thenReturn ("")

      when(cache.get[ListBuffer[User]]("list")) thenReturn (Option(ListBuffer[User](userNew)))

      userService.addUser(userNew) mustBe (true)
    }


    "check user" in {
      val cache = mock[CacheApi]
      val md5 = mock[MD5]
      val userNew = User("", "", "", "", "", "", true, true, "9971783971", "male", 24, "Cricket")
      val userService = new UserService(cache, md5)
      //      cache.set("list",ListBuffer[User](userNew))
      when(md5.hash("")) thenReturn ("")

      when(cache.get[ListBuffer[User]]("list")) thenReturn (Option(ListBuffer[User](userNew)))

      userService.checkUser("", "") mustBe (true)
    }

/*
*  def enable(userName:String)={
    val userList:ListBuffer[User] = cache.get[ListBuffer[User]]("list").getOrElse(ListBuffer[User]())

    val oldUser:User=userList.filter(_.userName==userName)(0)
    val newUser=oldUser.copy(isEnabled=true)
    userList-=oldUser
    userList+=newUser

true
  }*/

    "enabling of user" in {
      val cache = mock[CacheApi]
      val md5 = mock[MD5]
      val userNew = User("", "", "", "a1", "", "", true, true, "9971783971", "male", 24, "Cricket")
      val userService = new UserService(cache, md5)
      //      cache.set("list",ListBuffer[User](userNew))
      when(md5.hash("")) thenReturn ("")

      when(cache.get[ListBuffer[User]]("list")) thenReturn (Option(ListBuffer[User](userNew)))

      userService.enable("a1") mustBe (true)
    }

    "disabling of user" in {
      val cache = mock[CacheApi]
      val md5 = mock[MD5]
      val userNew = User("", "", "", "a1", "", "", true, true, "9971783971", "male", 24, "Cricket")
      val userService = new UserService(cache, md5)
      //      cache.set("list",ListBuffer[User](userNew))
      when(md5.hash("")) thenReturn ("")

      when(cache.get[ListBuffer[User]]("list")) thenReturn (Option(ListBuffer[User](userNew)))

      userService.disable("a1") mustBe (true)
    }


    "existance of user" in {
      val cache = mock[CacheApi]
      val md5 = mock[MD5]
      val userNew = User("", "", "", "a1", "", "", true, true, "9971783971", "male", 24, "Cricket")
      val userService = new UserService(cache, md5)
      //      cache.set("list",ListBuffer[User](userNew))
      when(md5.hash("")) thenReturn ("")

      when(cache.get[ListBuffer[User]]("list")) thenReturn (Option(ListBuffer[User](userNew)))

      userService.userExist("a1") mustBe (false)
    }


    }

}
