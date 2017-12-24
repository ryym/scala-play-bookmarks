package models

import java.time._

case class User(
  id: Long,
  name: String,
  createdAt: ZonedDateTime,
  updatedAt: ZonedDateTime,
)
