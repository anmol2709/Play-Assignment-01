package ControllerSpec

import org.scalatestplus.play._
import play.api.test.Helpers._
import play.api.test._


class CountControllerSpec extends PlaySpec with OneAppPerTest {

  "CountController" should {

    "return an increasing count" in {
      contentAsString(route(app, FakeRequest(GET, "/count")).get) mustBe "0"
      contentAsString(route(app, FakeRequest(GET, "/count")).get) mustBe "1"
      contentAsString(route(app, FakeRequest(GET, "/count")).get) mustBe "2"
    }
  }

}