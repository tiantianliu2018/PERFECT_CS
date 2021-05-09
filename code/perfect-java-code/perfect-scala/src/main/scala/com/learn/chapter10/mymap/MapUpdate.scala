package com.learn.chapter10.mymap

import scala.collection.mutable

/**
 * @author Kelly
 * @create 2021-05-08 10:22
 */
object MapUpdate {
  def main(args: Array[String]): Unit = {
    val map1 = mutable.Map(("A", 1), ("B", "上海"), ("C", 3))
    // 修改 map 中元素的值
    map1("A") = 20
    println("map1 = " + map1)

    // 添加一个 key 不存在的元素
    map1 += ("D" -> 4)
    println("map1 = " + map1)

    // 添加一个 key 已经存在的元素，原来的值会被覆盖
    map1 += ("B" -> 50)
    println("map1 = " + map1)

    // 添加多个元素
    val map2 = mutable.Map(("A", 1), ("B", "上海"), ("C", 3))
    val map3 = map2 + (("E" -> 1), ("F" -> 2))
    println("map3 = " + map3)

    map3 -= ("A", "B", "AAA")
    println("map3 = " + map3)

    // 遍历 map 中的元素
    val map4 = mutable.Map(("A", 1), ("B", "上海"), ("C", 3))

    println("---- (k, v) <- map4 --------")
    for ((k,v) <- map4) println(k + " is mapping to " + v)

    // 遍历 key
    println(" ---- k <- map4.keys --------")
    for (k <- map4.keys) println(k)

    // 遍历 values
    println("---- v <- map4.values --------")
    for (v <- map4.values) println(v)

    println(" ---- item <- map4 --------")
    for (item <- map4) println(item + ", key = " + item._1 + ", value = " + item._2)


  }

}
