package lib

import scalikejdbc._
import scala.language.implicitConversions

case class JoinDef[T](
  target: SQLSyntaxSupport[T],
  targetAlias: TableAsAliasSQLSyntax,
  ownCol: SQLSyntax,
  targetCol: SQLSyntax
)

case class JoinOn(a: SQLSyntax) {
  def ===(b: SQLSyntax): (SQLSyntax, SQLSyntax) = (a, b)
}

case class Joiner[A, B](
  target: SQLSyntaxSupport[B],
  getCols: (SyntaxProvider[B], SyntaxProvider[A]) => (SQLSyntax, SQLSyntax)
) {
  def leftJoin[F](
    a: SyntaxProvider[A], b: SyntaxProvider[B]
  ): SelectSQLBuilder[F] => SelectSQLBuilder[F] = {
    val (bCol, aCol) = getCols(b, a)
    sql => sql.leftJoin(target as b).on(bCol, aCol)
  }

  def innerJoin[F](
    a: SyntaxProvider[A], b: SyntaxProvider[B]
  ): SelectSQLBuilder[F] => SelectSQLBuilder[F] = {
    val (bCol, aCol) = getCols(b, a)
    sql => sql.innerJoin(target as b).on(bCol, aCol)
  }
}

trait JoinDefiner[A] {

  protected def join[B](table: SQLSyntaxSupport[B])(
    f: (SyntaxProvider[B], SyntaxProvider[A]) => (SQLSyntax, SQLSyntax)
  ): Joiner[A, B] = Joiner(table, f)

  protected implicit def syntaxToJoinOn(s: SQLSyntax): JoinOn = JoinOn(s)
}
