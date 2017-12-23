package repositories.common

import scalikejdbc._

trait Repository[T] extends SQLSyntaxSupport[T] {
  protected val alias: SyntaxProvider[T]
  private lazy val t = alias

  def apply(sp: SyntaxProvider[T])(rs: WrappedResultSet): T = apply(sp.resultName)(rs)
  def apply(rn: ResultName[T])(rs: WrappedResultSet): T

  def find(id: Long)(implicit session: DBSession = autoSession): Option[T] = {
    withSQL {
      select.from(this as t).where.eq(this.id(t), id)
    }.map(this(t)).single.apply()
  }

  def findAll()(implicit session: DBSession = autoSession): List[T] = {
    withSQL(select.from(this as t)).map(this(t)).list.apply()
  }

  // XXX: ResultName や SyntaxProvider は Dynamic というクラスを継承していて、
  // `t`からはどんな名前のメソッドを呼んでもコンパイルが通る。
  // SyntaxProvider[Users] だとちゃんとちゃんとクラスにある
  // フィールドのみコンパイルが通るようになるけど、ジェネリクスを使うと
  // そういうチェックはできなくなる。upper bound 使ってもダメだった。
  // ひとまずここのタイプセーフティは諦める。
  protected def id(t: SyntaxProvider[T]): SQLSyntax = t.id
}
