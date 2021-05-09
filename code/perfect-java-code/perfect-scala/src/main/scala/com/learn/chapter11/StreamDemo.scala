package com.learn.chapter11

/**
 * @author Kelly
 * @create 2021-05-09 10:27
 */
object StreamDemo {
  def main(args: Array[String]): Unit = {
    def numsForm(n: BigInt): Stream[BigInt] = n #:: numsForm(n + 1)
    val stream1 = numsForm(1)
    println(stream1)

    // 取出第一个元素
    println(stream1.head)
    println(stream1.tail)
    println(stream1)

  }

}
