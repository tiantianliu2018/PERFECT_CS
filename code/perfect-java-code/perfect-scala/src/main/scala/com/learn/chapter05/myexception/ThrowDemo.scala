package com.learn.chapter05.myexception

/**
 * @author Kelly
 * @create 2021-04-27 16:12
 */
object ThrowDemo {
  def main(args: Array[String]): Unit = {
//    val res = test()
//    println(res.toString)
    try {
      test()
    } catch {
      case ex: Exception => {
        println("捕获到一个异常 ：" + ex.getMessage)
        println("XXXX")
      }

    } finally {
      println("finally")
    }

    println("")
  }

  def test(): Nothing = {
    throw new Exception("异常出现~")
  }
}
