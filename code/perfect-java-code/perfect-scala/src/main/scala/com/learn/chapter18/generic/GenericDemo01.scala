package com.learn.chapter18.generic

/**
 * @author Kelly
 * @create 2021-05-14 16:53
 */
object GenericDemo01 {
  def main(args: Array[String]): Unit = {
    val value = new IntMessage[Int](10)
    println(value)

    val strMessage = new StringMessage[String]("abc")
    println(strMessage)
  }

}

/*
   编写一个 Message 类
   可以构建 Int 类型的 Message,
   String 类型的 Message.
   要求使用泛型来完成设计, (说 明：不能使用 Any)
*/
abstract class Message[T](s: T) {
  def get = s
}

class IntMessage[Int](v: Int) extends Message(v)
class StringMessage[String](s: String) extends Message(s)