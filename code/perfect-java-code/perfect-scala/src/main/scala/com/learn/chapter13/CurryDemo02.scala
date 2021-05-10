package com.learn.chapter13

/**
 * @author Kelly
 * @create 2021-05-10 11:25
 *
 * 比较两个字符串在忽略大小写的情况下是否相等
 */
object CurryDemo02 {
  def main(args: Array[String]): Unit = {
    def eq(s1: String, s2: String): Boolean = {
      s1.equals(s2)
    }

  }

  // 隐式类
  implicit class TestEq(s: String) {
    def checkEq(ss: String)(f: (String, String) => Boolean): Boolean = {
      f(s.toLowerCase, ss.toLowerCase)
    }
  }

  val str1 = "hello"
//  println(str1.checkEq("HELLO")(eq))

  println(str1.checkEq("HeLLO")(_.equals(_)))



}
