import org.scalatestplus.play._
import play.api.mvc.Flash
import play.api.test._
import play.api.test.Helpers._



class TemplateSpec extends PlaySpec  {

    "Index Page" should {

      "render Welcome Page" in new App{
        val html = views.html.index()
        contentAsString(html) mustBe contain("Welcome to My Page")
      }

    }
//
//  "Login Page" should {
//
//    "render Login Page" in new App{
//      val html = views.html.login()
//      contentAsString(html) mustBe contain("LOGIN PAGE")
//    }
//
//  }

}