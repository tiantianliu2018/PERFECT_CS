package com.learn.chapter02.dataconvert

/**
 * @author Kelly
 * @create 2021-04-20 11:25
 */
object DataConvert2 {
  def main(args: Array[String]): Unit = {
    val num1:Int = 10 * 3.5.toInt + 6 * 1.5.toInt
    val num2:Int = (10 * 3.5 + 6 * 1.5).toInt
    println(num1 + " " + num2)
  }

}
