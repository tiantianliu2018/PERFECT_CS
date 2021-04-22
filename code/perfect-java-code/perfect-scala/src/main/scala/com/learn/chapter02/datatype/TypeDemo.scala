package com.learn.chapter02.datatype

/**
 * @author Kelly
 * @create 2021-04-20 10:09
 */
object TypeDemo {
  def main(args: Array[String]): Unit = {
    var num1:Int = 10
    // num 是一个类
    println(num1.toDouble)
    println(num1.toString)
    println(num1.toDouble + num1.toString)

    sayHi()
    sayHi   // 方法没有参数，可以省略括号

    var isPass = true
    println(isPass.toString)

    println(sayHello())

    // 隐式转换  低精度的值 向 高精度的值 自动转换
    var num = 1.2   // 默认 double 类型
    var num2 = 1.7F
//    num2 = num  无法转换
    num = num2
  }
  def sayHi():Unit = {
    println("Hello~")
  }

  def sayHello(): Nothing = {
    throw new Exception("抛出异常")
  }
}


