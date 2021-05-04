package com.learn.chapter08.mixin

/**
 * @author Kelly
 * @create 2021-05-04 12:09
 */
object MixInDemo {
  def main(args: Array[String]): Unit = {
    // 在不修改类定义的基础上 添加特质
    val oracleDB = new OracleDB with Operate
    oracleDB.insert(100)

    val mySql = new MySQL with Operate
    mySql.insert(200)

    // 该抽象类中有一个抽象方法，如何实现动态混入特质
    val mySQL = new MySQL_ with Operate {
      override def say(): Unit = println("say")
    }

    mySQL.insert(300)
    mySQL.say()
  }

}
trait Operate {
  def insert(id: Int): Unit = {
    println("插入数据 " + id)
  }
}

class OracleDB {}
abstract class MySQL {}
abstract class MySQL_ {
  def say()
}