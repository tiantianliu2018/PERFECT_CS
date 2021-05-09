package com.learn.chapter11

/**
 * @author Kelly
 * @create 2021-05-08 12:00
 */
object FlodDemo02 {
  def minus(n1:Int, n2:Int):Int = {
    n1- n2
  }

  def main(args: Array[String]): Unit = {

    val list = List(1, 9)

    // 等价于 list.foldLeft(1)(minus)
    var res1 = (1 /: list) (minus)
    println("res1 = " + res1)

//    等价于 list.foldLeft(100)(minus)
    var res2 = (100 /: list) (minus)
    println("res2 = " + res2)

    // 等价于 list.foldRight(10)(minus)
    val res3 = (list :\ 10) (minus)
    println("res3 = " + res3)


  }

}
