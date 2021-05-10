package com.learn.chapter13

/**
 * @author Kelly
 * @create 2021-05-10 11:08
 */
object ParameterInfer {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4)
    println(list.map((x: Int) => x + 1))
    println(list.map((x) => x + 1))
    println(list.map(x => x + 1))

    println(list.map(_ + 1))

    println(list.reduce(f1))
    println(list.reduce((n1: Int, n2: Int) => n1 + n2))
    println(list.reduce((n1, n2) => n1 + n2))
    println(list.reduce(_ + _))

  }

  def f1(n1: Int, n2: Int): Int = {
    n1 + n2
  }
}
