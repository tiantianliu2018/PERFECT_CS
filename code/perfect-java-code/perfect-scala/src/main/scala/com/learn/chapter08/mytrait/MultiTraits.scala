package com.learn.chapter08.mytrait

/**
 * @author Kelly
 * @create 2021-05-04 12:16
 *
 * 叠加特质
 */
object MultiTraits {
  def main(args: Array[String]): Unit = {
    // 创建一个动态混入对象的特质时： Scala 在叠加特质的时候，会首先从后面的特质开始执行
    // trait operate1...
    // trait Data ~
    // trait DB ~
    // trait File ~
    val sql = new MySQL2 with DB with File
    println(sql)

    // 执行一个动态混入对象的方法，从右向左执行
    sql.insert(100)
  }

}
trait Operate1 {
  println("trait operate1...")

  // 抽象方法
  def insert(id: Int)
}

// 特质，继承了 Operate1
trait Data extends Operate1 {
  println("trait Data ~")

  override def insert(id: Int): Unit = println("插入数据 = " + id)
}

// 特质 DB 继承 Data
trait DB extends Data {
  println("trait DB ~")

  override def insert(id: Int): Unit = {
    println("向数据库")
    super.insert(id)
  }
}

trait File extends Data {
  println("trait File ~")

  override def insert(id: Int): Unit = {
    println("向文件")
    super.insert(id)
  }
}

// 普通类
class MySQL2 {}