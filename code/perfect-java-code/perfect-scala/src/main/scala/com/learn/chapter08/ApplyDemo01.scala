package com.learn.chapter08

/**
 * @author Kelly
 * @create 2021-05-04 11:13
 */
object ApplyDemo01 {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 5)
    println(list)

    val pig = new Pig("小花")

    // 使用 apply 方法来创建对象
    val pig1 = Pig("小黑")  // 自动 apply(pName: String)
    val pig2 = Pig()

    println("pig1.name = " + pig1.name)
    println("pig2.name = " + pig2.name)
  }

}

class Pig(pName: String) {
  var name: String = pName
}

object Pig {
  // apply 方法
  def apply(pName: String): Pig = new Pig(pName)

  def apply(): Pig = new Pig("匿名猪猪")

}
