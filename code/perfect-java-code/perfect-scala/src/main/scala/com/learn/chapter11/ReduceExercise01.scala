package com.learn.chapter11

/**
 * @author Kelly
 * @create 2021-05-08 11:37
 */
object ReduceExercise01 {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 5)

    println(list.reduceLeft(minus))  // -13  (((1-2)-3)-4)-5
    println(list.reduceRight(minus)) // 3  (1-(2-(3-(4-5))))
    println(list.reduce(minus))

    println("minval = " + list.reduceLeft(min))

    def minus(n1: Int, n2: Int): Int ={
      n1 - n2
    }

    def min(n1: Int, n2: Int): Int = {
      if (n1 > n2) n2 else n1
    }
  }

}
