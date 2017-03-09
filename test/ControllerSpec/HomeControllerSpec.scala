package ControllerSpec

import controllers.HomeController
import models.User
import org.mockito.Mockito._
import org.scalatest.mock.MockitoSugar
import org.scalatestplus.play._
import play.api.test.Helpers._
import play.api.test._
import services.UserService

import scala.collection.mutable.ListBuffer


class HomeControllerSpec extends PlaySpec with OneAppPerTest with MockitoSugar {

  "HomeController" should {

    "render the Index Action" in {

      val userService = mock[UserService]
      val controller = new HomeController(userService)
      val home = controller.index().apply(FakeRequest(GET, "/"))
      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include("WELCOME TO THE PLAY ASSIGNMENT PAGE!!!")
    }

    "render the Login Action" in {


      val userService = mock[UserService]
      val controller = new HomeController(userService)
      val home = controller.login().apply(FakeRequest(GET, "/login"))
      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include("LOGIN PAGE")
    }

    "render the sign Up Action " in {

      val userService = mock[UserService]
      val controller = new HomeController(userService)
      val home = controller.signUp().apply(FakeRequest(GET, "/signUp"))
      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include("Please Sign Up To Continue")
    }

    "render the Management Action" in {
      val userService = mock[UserService]
      val controller = new HomeController(userService)
      when(userService.getList()) thenReturn (ListBuffer[User]())
      val home = controller.management.apply(FakeRequest(GET, "/management"))
      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include("MANAGING USERS!!!!!")
    }

//    "render the LoginSubmit Action" in {
//      val userService = mock[UserService]
//      val controller = new HomeController(userService)
//      when(userService.checkUser("","")) thenReturn (false)
//
//      val home = controller.loginSubmit.apply(FakeRequest(POST, "/profile"))
//      status(home) mustBe OK
//      contentType(home) mustBe Some("text/html")
//      contentAsString(home) must include("USER")
//    }

  }


}