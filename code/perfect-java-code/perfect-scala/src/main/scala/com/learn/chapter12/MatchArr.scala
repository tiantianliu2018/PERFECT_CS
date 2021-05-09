package com.learn.chapter12

import scala.collection.mutable.ArrayBuffer

/**
 * @author Kelly
 * @create 2021-05-09 16:53
 *
 * 匹配数组
 */
object MatchArr {
  def main(args: Array[String]): Unit = {
    val arr = Array(Array(0), Array(1, 0), Array(0, 1, 0), Array(1, 1, 0), Array(1, 1, 0, 1))
    for (item <- arr) {
      val result = item match {
//        case Array(0) => "0"
        case Array(x, y) => ArrayBuffer(y, x) // x + "=" + y
//        case Array(0, _*) => "以 0 开头和数组"
        case _ => "什么集合都不是"
      }

      println("result = " + result)

//      if (result.isInstanceOf[ArrayBuffer]) {
//        println(result.asInstanceOf[ArrayBuffer])
//      }

//
    }
  }

}
