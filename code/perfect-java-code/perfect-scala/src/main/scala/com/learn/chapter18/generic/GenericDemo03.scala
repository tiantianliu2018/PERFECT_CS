package com.learn.chapter18.generic

/**
 * @author Kelly
 * @create 2021-05-14 17:15
 *
 * 获取各种类型的 List 的中间 index 的值
 */
object GenericDemo03 {
  def main(args: Array[String]): Unit = {
    val list1 = List("hello", "dog", "world")
    val list2 = List(90, 10, 23)
    println(midList[String](list1)) // "dog"
    println(midList[Int](list2))    // 10
  }

  def midList[E](l: List[E]): E = { l(l.length / 2) }

}
