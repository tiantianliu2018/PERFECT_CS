package com.learn.chapter12

/**
 * @author Kelly
 * @create 2021-05-09 15:49
 */
object MatchDemo01 {
  def main(args: Array[String]): Unit = {
    val oper = '-'
    val n1 = 20
    val n2 = 10
    var res = 0

    oper match {
      case '+' => {
        res = n1 + n2
        println("ok~")
      }
      case '-' => res = n1 - n2
      case '*' => res = n1 * n2
      case '/' => res = n1 / n2
      case 1 => println("匹配到 1")
      case 1.1 => println("匹配到 1.1")
      case _ => println("operate error")
    }

    println("res = " + res)

  }

}
