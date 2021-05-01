package com.learn.chapter05.func

/**
 * @author Kelly
 * @create 2021-04-27 10:36
 */
object FuncDemo {
  def main(args: Array[String]): Unit = {
    println("res = " + getRes(6, 5, '+'))
    println("res = " + getRes(6, 5, '-'))
  }

  // 定义方法
  def getRes(n1:Int, n2:Int, oper:Char) = {
    if (oper == '+') {
      n1 + n2
    } else if (oper == '-') {
      n1 - n2
    } else {
      null
    }
  }

}
