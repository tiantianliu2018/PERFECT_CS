package com.learn.chapter03.input

import scala.io.StdIn

/**
 * @author Kelly
 * @create 2021-04-21 10:39
 */
object Demo {
  def main(args: Array[String]): Unit = {
    println("请输入姓名：")
    var name = StdIn.readLine()

    println("请输入年龄：")
    var age: Int = StdIn.readInt()

    println("请输入薪水：")
    var salary: Double = StdIn.readDouble()

    printf(s"姓名：${name}, 年龄 = ${age}, salary = ${salary} \n")

    Cat.sayHi()
    Cat.sayHello()

  }
  object Cat extends AAA {
    def sayHi(): Unit = {
      println("小狗汪汪叫。。。")
    }

  }

  trait AAA {
    def sayHello(): Unit = {
      println("AAA sayHello")
    }
  }
}
