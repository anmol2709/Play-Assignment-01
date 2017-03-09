
import org.scalatestplus.play._
import play.api.test._
import play.api.test.Helpers._

class RouteSpec extends PlaySpec with OneAppPerTest {
  "Routes" should {

    "send 404 on a bad request" in {
      route(app, FakeRequest(GET, "/boum")).map(status(_)) mustBe Some(NOT_FOUND)

    }


      "respond to the index Action" in new App() {
        val Some(result) = route(app, FakeRequest(GET, "/"))
        status(result) mustBe OK
        contentType(result) mustBe ("text/html")
        charset(result) mustBe ("utf-8")
        contentAsString(result) must contain("Welcome")
      }


    "respond to the signUp Action" in new App() {
      val Some(result) = route(app, FakeRequest(GET, "/signup"))
      status(result) mustBe OK
      contentType(result) mustBe ("text/html")
      charset(result) mustBe ("utf-8")
      contentAsString(result) must contain("Please Sign Up To Continue")
    }

    "respond to the signIn Action" in new App() {
      val Some(result) = route(app, FakeRequest(GET, "/login"))
      status(result) mustBe OK
      contentType(result) mustBe ("text/html")
      charset(result) mustBe ("utf-8")
      contentAsString(result) must contain("LOGIN PAGE")
    }

    "respond to the Signup" in new App() {
      val Some(result) = route(app, FakeRequest(POST, "/registeredProfile"))
      status(result) mustBe OK
      contentType(result) mustBe ("text/html")
      charset(result) mustBe ("utf-8")
      contentAsString(result) must contain("USER DETAILS!")
    }

  }
}