package com.learn.chapter10.array

/**
 * @author Kelly
 * @create 2021-05-05 11:42
 */
object MultiplyArray {
  def main(args: Array[String]): Unit = {
    val array = Array.ofDim[Int](3, 4)
    for (elem <- array) {
      for (i <- elem) {
        print(i + "\t")
      }
      println()
    }

    println("array(1)(1) = " + array(1)(1) )

    //修改值
    array(1)(1) = 5

    //遍历
    println("=====================")
    for (item <- array) {
      //取出二维数组的各个元素（一维数组）
      for (i <- item) {
        // 元素（一维数组） 遍历
        print(i + "\t")
      }
      println()
    }

    //使用传统的下标的方式来进行遍历
    println("===================")

    for (i <- 0 to(array.length - 1)) {
      for (j <- 0 to(array(i).length - 1)) {
        printf("arr[%d][%d]=%d\t", i, j, array(i)(j))
      }
      println()
    }

  }

}
