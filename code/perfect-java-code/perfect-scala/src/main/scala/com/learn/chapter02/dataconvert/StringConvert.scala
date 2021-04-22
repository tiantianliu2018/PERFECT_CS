package com.learn.chapter02.dataconvert

/**
 * @author Kelly
 * @create 2021-04-20 11:29
 */
object StringConvert {
  def main(args: Array[String]): Unit = {
    val d1 = 1.2
    val s1 = d1 + ""
    println(s1.isInstanceOf[String])

    val s2 = "12"
    val num1 = s2.toInt
    val num2 = s2.toFloat
    val num3 = s2.toDouble
    val num4 = s2.toLong
    println(s"num1 = ${num1}, num2 = ${num2}, num3 = ${num3}, num4 = ${num4}")

  }

}
