package com.learn.chapter04.ifelse

import scala.io.StdIn

/**
 * @author Kelly
 * @create 2021-04-22 09:57
 */
object MultiBranch {
  def main(args: Array[String]): Unit = {
    println("请输入你的成绩：")
    val score = StdIn.readDouble()
    if (score == 100) {
      println("奖励你 BMW")
    } else if (score > 80 && score <= 99) {
      println("奖励你 Iphone")
    } else if (score >= 60 && score <= 80){
      println("奖励你 Ipad")
    } else {
      println("揍你")
    }
  }

}
