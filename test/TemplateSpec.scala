import models.User
import org.scalatestplus.play._
import play.api.mvc.{RequestHeader, Flash}
import play.api.test._
import play.api.test.Helpers._
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._

import scala.collection.mutable.ListBuffer


class TemplateSpec extends PlaySpec with MockitoSugar with OneAppPerTest{

    "Templates" should {

      "render Welcome Page" in{
        val html = views.html.index()
        contentAsString(html) must include("Welcome to My Page")
      }

//      "render profile Page" in{
//        val header= mock[RequestHeader]
//        val userNew = User("Anmol", "", "Sarna", "anmol1", "anmol", "anmol" ,true , true,"9971783971", "male", 24, "Cricket")
//        val html = views.html.profile(userNew)(header)
//        contentAsString(html) must include("USER DETAILS")
//      }
////
////
//        "render Login Page" in {
//          val flash=mock[Flash]
//
//          val html = views.html.login()(flash)
//      contentAsString(html) must include("LOGIN PAGE")
//    }
////
////      "render signUp Page" in {
////        val flash=mock[Flash]
////
//        val html = views.html.signUp()(flash)
//        contentAsString(html) must contain("Please Sign Up To Continue")
//      }

      "render management Page" in {
//        val flash=mock[Flash]
        val list=ListBuffer[User]()
        val header= mock[RequestHeader]
        val html = views.html.management(list)(header)
        contentAsString(html) must include("MANAGING USERS!!!!!")
      }

    }

}