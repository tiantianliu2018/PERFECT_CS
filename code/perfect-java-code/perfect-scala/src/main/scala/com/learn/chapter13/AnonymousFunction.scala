package com.learn.chapter13

/**
 * @author Kelly
 * @create 2021-05-10 10:37
 */
object AnonymousFunction {
  def main(args: Array[String]): Unit = {
    val triple = (x: Double) => {
      println("x = " + x)
      3 * x
    }

    println("triple = " + triple(3))
  }


}
