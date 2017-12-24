package models

import java.time._

case class Bookmark(
  id: Long,
  userId: Long,
  entryId: Long,
  comment: String,
  createdAt: ZonedDateTime,
  updatedAt: ZonedDateTime,
)

