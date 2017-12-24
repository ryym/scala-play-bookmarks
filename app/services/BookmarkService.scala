package services

import javax.inject._
import scalikejdbc._
import models._
import repositories._

@Singleton
class BookmarkService @Inject()(
  Bookmarks: Bookmarks,
  Entries: Entries,
) {

  def listBookmarks(userId: Long): List[(Bookmark, Entry)] = DB.readOnly { implicit ses =>
      val b = Bookmarks.syntax("b")
      val e = Entries.syntax("e")
      withSQL {
        select
          .from(Bookmarks as b)
          .map(Bookmarks.to(Entries).innerJoin(b, e))
          .where.eq(b.userId, userId)
      }.map(r => (Bookmarks(b)(r), Entries(e)(r))).list.apply()
  }
}
