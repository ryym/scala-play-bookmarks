package services

import javax.inject._
import scalikejdbc._
import models.User
import repositories.Users

@Singleton
class UserService @Inject()(Users: Users) {

  def currentUser(): User = DB.readOnly { implicit ses =>
    Users.find(1).get // XXX: TEMP
  }
}
