package com.learn.chapter10.array

import scala.collection.mutable.ArrayBuffer

/**
 * @author Kelly
 * @create 2021-05-05 11:33
 */
object Array2ArrayBuffer {
  def main(args: Array[String]): Unit = {
    val arr1 = ArrayBuffer[Int]()
    arr1.append(1, 2, 3)
    println(arr1)

    val arr2 = arr1.toArray
    println(arr2)

    val arr3 = arr2.toBuffer
    arr3.append(4, 5, 6)

    println(arr2)
    println(arr3)

  }

}
