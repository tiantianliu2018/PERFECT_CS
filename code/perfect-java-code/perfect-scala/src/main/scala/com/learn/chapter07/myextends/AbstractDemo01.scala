package com.learn.chapter07.myextends

/**
 * @author Kelly
 * @create 2021-05-03 11:43
 */
object AbstractDemo01 {
  def main(args: Array[String]): Unit = {
    println("Hello~")
    val animal = new Animal {
      override var name: String = "Tom"
      override var age: Int = 3

      override def cry(): Unit = {
        println("喵喵喵 Hello~")
      }
    }

    animal.cry()
    animal.sayHi()
  }

}

abstract class Animal {
  var name: String
  var age: Int
  var color: String = "white"
  def cry()  // 抽象方法

  // 非抽象的普通方法
  def sayHi(): Unit = {
    println("普通方法 Hello~")
  }
}
