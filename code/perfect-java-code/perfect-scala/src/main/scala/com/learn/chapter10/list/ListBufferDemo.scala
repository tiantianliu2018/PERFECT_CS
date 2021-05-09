package com.learn.chapter10.list

import scala.collection.mutable.ListBuffer

/**
 * @author Kelly
 * @create 2021-05-06 10:21
 */
object ListBufferDemo {
  def main(args: Array[String]): Unit = {
    val list01 = ListBuffer[Int](1, 2, 3)
    println("list01(2) = " + list01(2))

    for (item <- list01) {
      println("item = " + item)
    }

    // 动态的增加元素，list01 就会变化, 增加一个一个的元素
    val list02 = new ListBuffer[Int]  // 空的 ListBuffer
    list02 += 4
    list02.append(5)

    list01 ++= list02

    println("list01 = " + list01)

    val list03 = list01 ++ list02
    println("list03 = " + list03)

    val list04 = list01 :+ 5
    println("list04 = " + list04)

    println("============== 删除 ==============")
    println("list01 = " + list01)
    list01.remove(1)
    for (elem <- list01) {
      println("elem = " + elem)
    }

  }

}
