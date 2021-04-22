package com.learn.chapter04.ifelse

import scala.io.StdIn

/**
 * @author Kelly
 * @create 2021-04-22 09:53
 */
object Demo {
  def main(args: Array[String]): Unit = {
//    println("请输入年龄：")
//    val age = StdIn.readInt()
//    if (age > 18) {
//      println("成年人")
//    } else {
//      println("未成年人")
//    }
    var sumVal = 29
    val result = if (sumVal > 20) {
      "结果大于 20"
    }

    println("result: " + result)

  }

}
