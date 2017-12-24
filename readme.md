- Rails 以外の Web フレームワークを知りたい
- [Play 2.6][play-2.6] + [ScalikeJDBC][scalikejdbc]

Rails 以外のフレームワークを使おうとして悩むのは大抵 DB アクセスの抽象化方法。
Scala だと [Slick][slick] というライブラリが主流っぽいけど、
独自 DSL が少なく JDBC のラッパーである ScalikeJDBC の方がとっつきやすそうだったのでこちらを使った。
型のある言語における OR マッピングはコードの自動生成がつきものだけど、
自動生成されたコードはカスタマイズしづらいのが難点。 
ScalikeJDBC なら自動生成なしでも trait による共通化とマクロでいけそう。

- scalikejdbc-cookbook: <https://github.com/scalikejdbc/scalikejdbc-cookbook>

[play-2.6]: https://www.playframework.com/documentation/2.6.x/ScalaHome
[scalikejdbc]: http://scalikejdbc.org/
[slick]: http://slick.lightbend.com/
