package com.learn.chapter10.array

/**
 * @author Kelly
 * @create 2021-05-05 10:48
 */
object ArrayDemo01 {
  def main(args: Array[String]): Unit = {
    // 创建数组第一种方式：
    // 先创建定长数组，再进行赋值
    val a = new Array[Int](4)
    println(a.length)

    println("a(0) = " + a(0))

    // 数组的遍历
    for (i <- a) {
      print(i + "\t")
    }

    println("\n---------------")
    // 赋值
    a(3) = 10
    a(1) = 7
    for (i <- a) {
      print(i + "\t")
    }

    println()
    /**
     * 创建数组的第②种方式，创建数组的同时进行赋值
     */
    val arr = Array(1, 2, "xx")
    arr(1) = "aa"
    for (i <- arr) {
      print(i + "\t")
    }

    println()

    // 按照下标遍历数组
    for (index <- 0 until(arr.length)) {
      printf("arr[%d] = %s", index, arr(index) + ", ")
    }


  }

}
