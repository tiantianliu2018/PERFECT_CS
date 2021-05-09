package com.learn.chapter11

/**
 * @author Kelly
 * @create 2021-05-08 12:05
 */
object ScanDemo01 {
  def main(args: Array[String]): Unit = {
    // 普通函数
    def minus(n1: Int, n2: Int): Int = {
      n1 - n2
    }

//    (1,2,3,4,5) => (5, 4, 2, -1, -5, -10)
    val res = (1 to 5).scanLeft(5)(minus)
    println("res = " + res)

    //普通函数
    def add( num1: Int, num2: Int ): Int = num1 + num2

    // (1,2,3,4,5) => (20, 19, 17, 14, 10, 5)
    val res2 = (1 to 5).scanRight(5)(add)
    println("res2 = " + res2)

  }


}
