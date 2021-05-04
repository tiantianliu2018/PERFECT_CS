package com.learn.chapter08.mytrait

/**
 * @author Kelly
 * @create 2021-05-04 11:53
 */
object TraitDemo {
  def main(args: Array[String]): Unit = {
    val c = new C
    val f = new F

    c.getConnection()
    f.getConnection()
  }
}

// 定义特质
trait Trait {
  // 定义一个规范
  def getConnection()
}
class A {}
class B extends A {}
class C extends A with Trait {
  // 相当于实现特质中的抽象方法
  override def getConnection(): Unit = println("连接 mysql 数据库")
}

class D {}
class E extends D {}
class F extends D with Trait {
  override def getConnection(): Unit = println("连接 Redis 数据库")
}


