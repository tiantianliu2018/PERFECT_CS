package com.learn.chapter10.set

import scala.collection.mutable

/**
 * @author Kelly
 * @create 2021-05-08 10:50
 */
object SetDemo {
  def main(args: Array[String]): Unit = {
    val set = Set(1, 2, 3)  // 不可变集合
    println("不可变集合 set = " + set)

    val set1 = mutable.Set(1, 2, 3)
    println("可变集合 set1 = " + set1)

    set1.add(4)
    set1 += 6
    set1 += 5
    println("new set1 = " + set1)

    // 可变集合的删除
    val set2 = mutable.Set(1, 2, 4, "abc")
    set2 -= 2
    println("set2 = " + set2)

    set2.remove(1)
    println("set2 = " + set2)

    // 集合的遍历
    val set3 = mutable.Set(1, 2, 4, "abc")
    for (x <- set3) println(x)
  }

}
