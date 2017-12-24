package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._
import org.mockito.Mockito._
import models._
import services._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 *
 * For more information, see https://www.playframework.com/documentation/latest/ScalaTestingWithScalaTest
 */
class HomeControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "HomeController GET" should {

    "render the index page from a new instance of controller" in {
      val userS = mock(classOf[UserService])
      when(userS.currentUser).thenReturn(User(1, "test"))

      val bookmarkS = mock(classOf[BookmarkService])
      when(bookmarkS.listBookmarks(1)).thenReturn(Nil)

      val controller = new HomeController(
        stubControllerComponents(),
        userS,
        bookmarkS
      )
      val home = controller.index().apply(FakeRequest(GET, "/"))

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include ("Hello, test")
    }
  }
}
