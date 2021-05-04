package com.learn.chapter08.mytrait

/**
 * @author Kelly
 * @create 2021-05-04 12:39
 */
object SelfTypeDemo {
  def main(args: Array[String]): Unit = {

  }

}

trait Logger {
  // 明确告诉编译器，我就是 Exception,
  this: Exception =>

  def log(): Unit = {
    println(getMessage)  // 可以调用 Exception 的 getMessage 方法
  }


}
