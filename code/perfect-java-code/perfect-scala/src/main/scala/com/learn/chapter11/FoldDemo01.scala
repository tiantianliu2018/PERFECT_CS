package com.learn.chapter11

/**
 * @author Kelly
 * @create 2021-05-08 11:56
 */
object FoldDemo01 {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4)
    // // list(5, 1, 2, 3, 4) list.reduceLeft(minus)
    println(list.foldLeft(5)(minus))

    // list(1, 2, 3, 4, 5) list.reduceRight(minus)
    println(list.foldRight(5)(minus))

    def minus(n1: Int, n2: Int): Int = {
      n1 - n2
    }
  }

}
