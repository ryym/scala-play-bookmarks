package models

import java.time._

case class Entry(
  id: Long,
  url: String,
  title: String,
  createdAt: ZonedDateTime = ZonedDateTime.now,
  updatedAt: ZonedDateTime = ZonedDateTime.now,
)

