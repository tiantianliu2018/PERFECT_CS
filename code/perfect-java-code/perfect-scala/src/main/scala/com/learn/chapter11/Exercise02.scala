package com.learn.chapter11

import scala.collection.mutable.ArrayBuffer

/**
 * @author Kelly
 * @create 2021-05-09 10:02
 */
object Exercise02 {
  def main(args: Array[String]): Unit = {
    val sentence = "AAAAAAAAAABBBBBBBBCCCCCDDDDDDD"

    val arrayBuffer = new ArrayBuffer[Char]()
    sentence.foldLeft(arrayBuffer)(putArray)
    println("arrayBuffer = " + arrayBuffer)


  }

  def putArray(array: ArrayBuffer[Char], c: Char): ArrayBuffer[Char] = {
    array.append(c)
    array
  }

}
