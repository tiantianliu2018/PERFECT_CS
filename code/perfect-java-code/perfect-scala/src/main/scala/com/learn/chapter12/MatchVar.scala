package com.learn.chapter12

/**
 * @author Kelly
 * @create 2021-05-09 16:15
 */
object MatchVar {
  def main(args: Array[String]): Unit = {
    val ch = 'U'
    ch match {
      case '+' => println("ok~")
      case mychar => println("ok~" + mychar)
      case _ => println("ok~~~")
    }

    var ch1 = '+'
    val res = ch1 match {
      case '+' => ch1 + "hello"
      case _ => println("ok~~")
    }

    println("res = " + res)
  }

}
