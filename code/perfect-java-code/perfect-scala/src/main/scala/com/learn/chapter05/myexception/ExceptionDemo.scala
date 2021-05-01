package com.learn.chapter05.myexception

/**
 * @author Kelly
 * @create 2021-04-27 16:02
 */
object ExceptionDemo {
  def main(args: Array[String]): Unit = {
    try {
      var r = 0 / 0
    } catch {
      // 在 scala 中只有一个 catch
      // catch 中有多个 case，每个 case 捕获一种异常
      // => 关键符号，表示后面是对该异常进行处理的代码
      case ex: ArithmeticException => {
        println("捕获除零的算术异常")
      }
      case ex: Exception => println("捕获了其他异常")
    } finally {
      // 最终执行的代码
      println("scala finally~")
    }
    println("ok, 继续执行！")
  }

}
