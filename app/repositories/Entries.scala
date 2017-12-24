package repositories

import javax.inject._
import scalikejdbc._
import models.Entry
import common.Repository

@Singleton
class Entries extends Repository[Entry] {
  protected val alias = syntax("e")
  override val tableName = "entries"
  override val columns = listColumnNames(classOf[Entry])

  override def apply(e: ResultName[Entry])(rs: WrappedResultSet): Entry =
    autoConstruct(rs, e)

  def to(b: Bookmarks) = join(b)(_.entryId === _.id)
}
