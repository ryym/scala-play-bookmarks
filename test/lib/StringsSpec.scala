package lib

import org.scalatest._
import prop._

class StringsSpec extends FlatSpec with TableDrivenPropertyChecks with Matchers {
  "#camelToSnake" should "convert camelCase to snake_case" in {
    val cases = Table(
      ("id", "id"),
      ("userId", "user_id"),
      ("thisIsAPen", "this_is_a_pen"),
    )

    forAll(cases) { (in, want) =>
      Strings.camelToSnake(in) shouldBe want
    }
  }
}
