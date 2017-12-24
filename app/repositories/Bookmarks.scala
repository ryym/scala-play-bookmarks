package repositories

import javax.inject._
import scalikejdbc._
import models.Bookmark
import common.Repository

@Singleton
class Bookmarks extends Repository[Bookmark] {
  protected val alias = syntax("u")
  override val tableName = "bookmarks"
  override val columns = Seq("id", "user_id", "entry_id", "comment", "created_at", "updated_at")

  override def apply(b: ResultName[Bookmark])(rs: WrappedResultSet): Bookmark =
    autoConstruct(rs, b)

  def to(e: Entries) = join(e)(_.id === _.entryId)
}
