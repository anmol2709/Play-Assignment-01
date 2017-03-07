import org.scalatestplus.play._
import play.api.test._
import play.api.test.Helpers._


class ControllerSpec extends PlaySpec with OneAppPerTest {

  "HomeController" should {

    "render the Index page" in {
      val home = route(app, FakeRequest(GET, "/")).get

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include("WELCOME TO THE PLAY ASSIGNMENT PAGE!!!")
    }

    "render the Loginpage" in {
      val home = route(app, FakeRequest(GET, "/login")).get

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include("LOGIN PAGE")
    }

    "render the signUp page" in {
      val home = route(app, FakeRequest(GET, "/signUp")).get

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include("Please Sign Up To Continue")
    }
    "render the Management page" in {
      val home = route(app, FakeRequest(GET, "/management")).get

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include("MANAGING USERS!!!!!")
    }
  }



  "CountController" should {

    "return an increasing count" in {
      contentAsString(route(app, FakeRequest(GET, "/count")).get) mustBe "0"
      contentAsString(route(app, FakeRequest(GET, "/count")).get) mustBe "1"
      contentAsString(route(app, FakeRequest(GET, "/count")).get) mustBe "2"
    }


  }

}