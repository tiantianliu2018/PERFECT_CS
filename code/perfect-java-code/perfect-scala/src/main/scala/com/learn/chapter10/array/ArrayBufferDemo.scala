package com.learn.chapter10.array

import scala.collection.mutable.ArrayBuffer

/**
 * @author Kelly
 * @create 2021-05-05 10:59
 */
object ArrayBufferDemo {
  def main(args: Array[String]): Unit = {
    val arr = ArrayBuffer[Any](3, 2, 5)

    // 访问
    println("arr(1) = " + arr(1))
    // 遍历
    for (elem <- arr) {
      print(elem + ", ")
    }
    println()
    println("arr.hashcode = " + arr.hashCode())

    // 修改值
    arr.append(990.0, 13)
    // 遍历
    for (elem <- arr) {
      print(elem + ", ")
    }
    println()
    println("arr.hashcode = " + arr.hashCode())

    println("==================")
    arr(1) = 89
    for (elem <- arr) {
      print(elem + ", ")
    }
    println()

    // 删除元素
    arr.remove(0)
    println("---------删除后的元素遍历-------")
    for (elem <- arr) {
      print(elem + ", ")
    }
    println()

    println("新的数组长度 = " + arr.length)


  }

}
