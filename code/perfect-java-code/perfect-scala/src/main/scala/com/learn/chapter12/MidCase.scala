package com.learn.chapter12

/**
 * @author Kelly
 * @create 2021-05-09 17:57
 */
object MidCase {
  def main(args: Array[String]): Unit = {
    List(1, 3, 5, 9) match {
      case first::second::rest => println(first + " " + second + " "+ rest.length + " " + rest)
      case _ => println(" 匹配不到..." )
    }
  }

}
