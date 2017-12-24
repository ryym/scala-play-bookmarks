package lib

object Strings {

  // For now we ignore some edge cases like
  // words starting with upper character or acronyms.
  def camelToSnake(s: String): String = {
    s.foldLeft(new StringBuilder)((sb, c) => {
      sb.append(if (c.isUpper) s"_${c.toLower}" else c)
    }).toString
  }
}
