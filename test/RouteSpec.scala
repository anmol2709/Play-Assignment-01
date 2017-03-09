
import org.scalatestplus.play._
import play.api.mvc.Session
import play.api.test._
import play.api.test.Helpers._

class RouteSpec extends PlaySpec with OneAppPerTest {
  "Routes" should {

    "send 404 on a bad request" in {
      route(app, FakeRequest(GET, "/boum")).map(status(_)) mustBe Some(NOT_FOUND)

    }


    "respond to the index Action" in {
      val Some(result) = route(app, FakeRequest(GET, "/"))
      status(result) mustBe OK
      contentType(result) mustBe Some("text/html")
      charset(result) mustBe Some("utf-8")
      contentAsString(result) must include("Welcome")

    }


    "respond to the signUp Action" in {
      val Some(result) = route(app, FakeRequest(GET, "/signUp"))
      status(result) mustBe OK
      contentType(result) mustBe Some("text/html")
      charset(result) mustBe Some("utf-8")
      contentAsString(result) must include("Please Sign Up To Continue")
    }

    "respond to the signIn Action" in {
      val Some(result) = route(app, FakeRequest(GET, "/login"))
      status(result) mustBe OK
      contentType(result) mustBe Some("text/html")
      charset(result) mustBe Some("utf-8")
      contentAsString(result) must include("LOGIN PAGE")

    }
    "respond to the Signup" in new App{

      val Some(result) = route(app, FakeRequest(POST, "/registeredProfile").withSession(""->""))
      status(result) mustBe OK
      contentType(result) mustBe Some("text/html")
      charset(result) mustBe Some("utf-8")
      contentAsString(result) must include("USER DETAILS!")
    }


    "respond to the Proile visit" in  new App{
      val Some(result) = route(app, FakeRequest(POST, "/profile"))
      status(result) mustBe OK
      contentType(result) mustBe Some("text/html")

      contentAsString(result) must include("USER DETAILS!")
    }

    "respond to the enable user route" in new App{
      val Some(result) = route(app, FakeRequest(POST, "/enable"))
      status(result) mustBe OK
      contentType(result) mustBe Some("text/html")
      charset(result) mustBe Some("utf-8")
      contentAsString(result) must include("USER DETAILS!")
    }

    "respond to the disable user route" in new App{
      val Some(result) = route(app, FakeRequest(POST, "/disable"))
      status(result) mustBe OK
      contentType(result) mustBe Some("text/html")
      charset(result) mustBe Some("utf-8")
      contentAsString(result) must include("USER DETAILS!")
    }
  }
}