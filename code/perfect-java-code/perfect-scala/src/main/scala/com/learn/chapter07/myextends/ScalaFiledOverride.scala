package com.learn.chapter07.myextends

/**
 * @author Kelly
 * @create 2021-05-03 11:03
 */
object ScalaFiledOverride {
  def main(args: Array[String]): Unit = {
    val obj1: AAA = new BBB
    val obj2: BBB = new BBB

    println("obj1.age = " + obj1.age + "\tobj2.age = " + obj2.age)

    println("Hello~")

  }

}
class AAA {
  val age: Int = 10
}

class BBB extends AAA {
  override val age: Int = 20
}

abstract class A {
  var name: String // 抽象属性，没有初始化。底层是两个抽象方法
  var age: Int = 10
}

class B extends A {
  // override 可写可不写
  override var name: String = ""  // 重写父类的抽象属性，实际上是实现父类的抽象方法
}

