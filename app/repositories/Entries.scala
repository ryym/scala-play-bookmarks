package repositories

import javax.inject._
import scalikejdbc._
import models.Entry
import common.Repository

@Singleton
class Entries extends Repository[Entry] {
  protected val alias = syntax("u")
  override val tableName = "entries"
  override val columns = Seq("id", "url", "title", "created_at", "updated_at")

  override def apply(e: ResultName[Entry])(rs: WrappedResultSet): Entry =
    autoConstruct(rs, e)

  def to(b: Bookmarks) = join(b)(_.entryId === _.id)
}
