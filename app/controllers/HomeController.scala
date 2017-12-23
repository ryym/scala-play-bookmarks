package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import scalikejdbc._
import services.UserService

@Singleton
class HomeController @Inject()(
  cc: ControllerComponents,
  userS: UserService,
) extends AbstractController(cc) {

  def index() = Action { implicit request: Request[AnyContent] =>
    val user = userS.currentUser
    Ok(views.html.index(user.name))
  }
}
