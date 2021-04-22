package com.learn.chapter04.mywhile

import scala.util.control.Breaks.{break, breakable}

/**
 * @author Kelly
 * @create 2021-04-22 11:06
 */
object WhileBreak {
  def main(args: Array[String]): Unit = {
    var n = 1
    // breakable  高阶函数，可以接收函数的函数
    breakable {
      while (n <= 20) {
        println("n = " + n)

        n += 1

        if (n == 18) {
          // 中断 while
          // 使用函数式的 break 来中断循环
          break()
        }
      }
    }
    println("OK")


  }

}
