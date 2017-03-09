
import models.User
import org.scalatest.mock.MockitoSugar
import org.scalatestplus.play._
import play.api.cache.CacheApi
import play.api.test._
import play.api.test.Helpers._
import services.UserService
import services.AbstractUserService

import org.mockito.Mockito._

import scala.collection.mutable
import scala.collection.mutable.ListBuffer


class ServiceSpec extends PlaySpec with MockitoSugar {

//  "UserService#getList" should {
//    "get list" in {
//      val cache = mock[CacheApi]
//      val userNew = User("Anmol", "", "Sarna", "anmol", "anmol", "anmol" ,true , true,"9971783971", "male", 24, "Cricket")
//cache.set("list",ListBuffer[User](userNew))
//      val userService = new UserService(cache)
//      when(cache.get[ListBuffer[User]]("list").getOrElse(ListBuffer[User]())) thenReturn(ListBuffer[User](userNew))
//      userService.getList() equals  ListBuffer[User](userNew)
//    }
//  }
////
//  "UserService#getUser" should {
//    "get user" in {
//      val userNew = User("Anmol", "", "Sarna", "anmol", "anmol", "anmol" ,true , true,"9971783971", "male", 24, "Cricket")
//      val userService = mock[UserService]
//      when(userService.getUser("anmol")) thenReturn userNew
//    }
//  }
//
//  "UserService#getUser" should {
//    "get user" in {
//      val userNew = User("Anmol", "", "Sarna", "anmol", "anmol", "anmol" ,true , true,"9971783971", "male", 24, "Cricket")
//      val userService = mock[UserService]
//      when(userService.getUser("anmol")) thenReturn userNew
//    }
//  }

}
