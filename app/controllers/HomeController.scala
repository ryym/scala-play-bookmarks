package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import scalikejdbc._
import services._

@Singleton
class HomeController @Inject()(
  cc: ControllerComponents,
  userS: UserService,
  bookmarkS: BookmarkService,
) extends AbstractController(cc) {

  def index() = Action { implicit request: Request[AnyContent] =>
    val user = userS.currentUser
    val bookmarks = bookmarkS.listBookmarks(user.id)

    Ok(views.html.index(user.name, bookmarks))
  }
}
