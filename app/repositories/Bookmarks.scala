package repositories

import javax.inject._
import scalikejdbc._
import models.Bookmark
import common.Repository

@Singleton
class Bookmarks extends Repository[Bookmark] {
  protected val alias = syntax("b")
  override val tableName = "bookmarks"
  override val columns = listColumnNames(classOf[Bookmark])

  override def apply(b: ResultName[Bookmark])(rs: WrappedResultSet): Bookmark =
    autoConstruct(rs, b)

  def to(e: Entries) = join(e)(_.id === _.entryId)
  def to(u: Users) = join(u)(_.id === _.userId)
}
