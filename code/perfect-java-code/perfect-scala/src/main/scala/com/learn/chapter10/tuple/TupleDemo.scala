package com.learn.chapter10.tuple

/**
 * @author Kelly
 * @create 2021-05-06 09:35
 */
object TupleDemo {
  def main(args: Array[String]): Unit = {
    val tuple1 = (1, 2, 3, "hello", 4)
    println(tuple1)

    println("============== 访问元组 ================")
    val t1 = (1, "a", "b", true, 2)
    println(t1._1)  // 访问元组的第一个元素，从 1 开始
    println(t1._2)

    println(t1.productElement(0)) // 访问元组的第一个元素

    println("============== 遍历元组 ================")
    for (item <- t1.productIterator) {
      println("item = " + item)
    }
  }

}
