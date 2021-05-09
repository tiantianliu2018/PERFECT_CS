package com.learn.chapter12

/**
 * @author Kelly
 * @create 2021-05-09 17:03
 *
 * 匹配列表
 */
object MatchList {
  def main(args: Array[String]): Unit = {
    for (list <- Array(List(0), List(1, 0), List(88), List(0, 0 ,0), List(1, 0, 0))) {
      val result = list match {
        case 0:: Nil => "0"
        case x::y::Nil => x + "" + y
        case 0::tail => "0..."
        case x::Nil => x
        case _ => "something else"
      }
      println(result)
    }
  }

}
