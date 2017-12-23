package repositories

import javax.inject._
import scalikejdbc._
import models.User
import common.Repository

@Singleton
class Users extends Repository[User] {
  protected val alias = syntax("u")
  override val tableName = "users"
  override val columns = Seq("id", "name", "created_at", "updated_at")

  override def apply(u: ResultName[User])(rs: WrappedResultSet): User =
    autoConstruct(rs, u)
}
