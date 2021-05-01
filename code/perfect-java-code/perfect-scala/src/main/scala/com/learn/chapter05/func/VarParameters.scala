package com.learn.chapter05.func

/**
 * @author Kelly
 * @create 2021-04-27 14:56
 */
object VarParameters {
  def main(args: Array[String]): Unit = {
    println(sum(10, 30, 10, 3, 45, 7))
  }

  def sum(n1:Int, args:Int*): Int = {
    println("args.length = " + args.length)

    // 遍历
    var sum = n1
    for (elem <- args) {
      sum += elem
    }
    sum
  }

}
