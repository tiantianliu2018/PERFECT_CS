package com.learn.chapter11

import scala.collection.mutable

/**
 * @author Kelly
 * @create 2021-05-09 10:10
 */
object Exercise03 {
  def main(args: Array[String]): Unit = {
    val sentence = "AAAAAAAAAABBBBBBBBCCCCCDDDDDDD"

    val charMap = sentence.foldLeft(Map[Char, Int]())(charCount)
    println("charMap = " + charMap)

    // 使用可变 Map
    val map2 = mutable.Map[Char, Int]()
    sentence.foldLeft(map2)(charCount2)
    println("map2 = " + map2)
  }

  // 使用不可变 map 实现
  def charCount(map: Map[Char, Int], c: Char): Map[Char, Int] = {
    map + (c -> (map.getOrElse(c, 0) + 1))
  }

  def charCount2(map: mutable.Map[Char, Int], c: Char): mutable.Map[Char, Int] = {
    map += (c -> (map.getOrElse(c, 0) + 1))
  }
}
