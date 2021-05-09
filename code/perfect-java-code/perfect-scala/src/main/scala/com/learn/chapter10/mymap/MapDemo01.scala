package com.learn.chapter10.mymap

import scala.collection.mutable

/**
 * @author Kelly
 * @create 2021-05-08 09:53
 *
 * Map 的创建与取值
 */
object MapDemo01 {
  def main(args: Array[String]): Unit = {
    // 不可变 Map 有序
    val map1 = Map("Alice" -> 10, "Bob" -> 20, "Kelly" -> "北京")
    println("map1 = " + map1)

    // 可变的 Map ，无序
    val map2 = mutable.Map("Alice" -> 10, "Bob" -> 20, "Kelly" -> "北京")
    println("map2 = " + map2)
    println("map2(\"Alice\") = " + map2("Alice"))

    // 创建空的 map
    val map3 = new mutable.HashMap[String, Int]()
    println("map3 = " + map3)

    val map4 = mutable.Map(("Alice", 10), ("Bob", 20), ("Kelly", "北京"))
    println("map4 = " + map4)

//    println(map4("alice"))  // 抛出 NoSuchElementException 异常

    println(map4.contains("Alice"))
    println(map4.contains("Tom"))

    if (map4.contains("Tom")) {
      println("key 存在，值 = " + map4("Alice"))
    } else {
      println("key 不存在 :)" )
    }

    println(map4.get("Alice").get)
//    println(map4.get("Tom").get)  // 抛出 NoSuchElementException 异常

    println(map4.getOrElse("Alice~", "默认的值 🐟"))
  }

}
