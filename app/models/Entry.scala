package models

import java.time._

case class Entry(
  id: Long,
  url: String,
  title: String,
  createdAt: ZonedDateTime,
  updatedAt: ZonedDateTime,
)

