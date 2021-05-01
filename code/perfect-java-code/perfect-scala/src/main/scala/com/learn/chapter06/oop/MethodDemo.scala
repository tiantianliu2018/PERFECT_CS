package com.learn.chapter06.oop

/**
 * @author Kelly
 * @create 2021-04-30 10:20
 */
object MethodDemo {
  def main(args: Array[String]): Unit = {
    val dog = new Dog
    println(dog.cal(10,20))

  }
}
class Dog {
  private var sal: Double = _
  var food: String = _

  def cal(n1:Int, n2:Int): Int = {
    n1 + n2
  }
}
