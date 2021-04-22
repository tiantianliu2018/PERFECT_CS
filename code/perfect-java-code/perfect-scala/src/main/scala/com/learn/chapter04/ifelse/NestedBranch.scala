package com.learn.chapter04.ifelse

import scala.io.StdIn

/**
 * @author Kelly
 * @create 2021-04-22 10:05
 */
object NestedBranch {
  def main(args: Array[String]): Unit = {
    println("请输入旅游月份:")
    val month = StdIn.readInt()

    println("请输入年龄：")
    val age = StdIn.readInt()

    var ticket = 0

    if (month >= 4 && month <= 10) {
      if (age > 60) {
        ticket = 20
      } else if (age >= 18) {
        ticket = 60
      } else {
        ticket = 30
      }
    } else {
      if (age >= 18 && age <= 60) {
        ticket = 40
      } else {
        ticket = 20
      }
    }

    println("你的票价为：" + ticket)
  }

}
