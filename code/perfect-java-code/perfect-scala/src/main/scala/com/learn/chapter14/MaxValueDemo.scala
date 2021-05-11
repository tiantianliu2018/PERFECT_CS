package com.learn.chapter14

/**
 * @author Kelly
 * @create 2021-05-11 10:10
 */
object MaxValueDemo {
  def main(args: Array[String]): Unit = {
    def max(xs: List[Int]): Int = {
      if (xs.isEmpty) {
        throw new NoSuchElementException
      }
      if (xs.size == 1) {
        xs.head
      } else if (xs.head > max(xs.tail)) xs.head else max(xs.tail)
    }

    val list = List(2,4,1,9,10,3,7,6,5,0)
    val res = max(list)

    println("max value = " + res)
  }

}
