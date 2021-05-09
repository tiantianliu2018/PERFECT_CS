package com.learn.chapter12

/**
 * @author Kelly
 * @create 2021-05-09 17:41
 */
object MatchForDemo {
  def main(args: Array[String]): Unit = {
    val map = Map("A" -> 1, "B" -> 0, "C" -> 3)
    for ((k,v) <- map) {
      println(k + " -> " + v)
    }

    println("-------------- (k, 0) <- map -------------------")
    for ((k, 0) <- map) {
      println(k + " --> " + 0)
    }

    println("-------------- (k, v) <- map if v >= 1 -------------------")
    for ((k,v) <- map if v >= 1) {
      println(k + " ---> " + v)
    }
  }

}
