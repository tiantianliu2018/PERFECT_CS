package com.learn.chapter06.oop

/**
 * @author Kelly
 * @create 2021-04-30 10:15
 */
object MemoryState {
  def main(args: Array[String]): Unit = {
    val p1 = new Person
    p1.name = "Jack"
    p1.age = 10

    val p2 = p1
    println(p1 == p2)

    p1.name = "Tom"
    println("p2 name = " + p2.name)
    println(p1 == p2)

  }

}
class Person {
  var name: String = _  // 用 _ 的方式给默认值，属性一定要指定类型
  var age: Int = _

}
