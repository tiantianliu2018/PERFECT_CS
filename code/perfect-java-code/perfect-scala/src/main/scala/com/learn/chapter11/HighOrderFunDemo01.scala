package com.learn.chapter11

/**
 * @author Kelly
 * @create 2021-05-08 11:03
 */
object HighOrderFunDemo01 {

  // f: Double => Double 表示一个函数, 该函数可以接受一个 Double,返回 Double
  // n1: Double 普通参数

  def test(f: Double => Double, n1: Double) = f(n1)

  def sum2(d: Double): Double = {
    println("sum2 被调用")
    d + d
  }

  def myPrint(): Unit = {
    println("hello,world!")
  }


  def main(args: Array[String]): Unit = {
    val res = test(sum2 _, 3.5)
    println("res = " + res)

    val f1 = myPrint _  // 可以把一个函数直接赋给一个变量,但是不执行函数
    f1()
  }

}
