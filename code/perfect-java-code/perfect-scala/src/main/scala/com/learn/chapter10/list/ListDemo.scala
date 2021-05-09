package com.learn.chapter10.list

/**
 * @author Kelly
 * @create 2021-05-06 09:51
 */
object ListDemo {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, "abc")
    println(list)

    val list2 = Nil  // 空集合
    println(list2)

    // 访问元素
    val val1 = list(1)
    println("value1 = " + val1)

    println("------------- list 追加元素后的效果 -----------------")
    val list1 = List(1, 2, 3, "abc")
    val list3 = list1 :+ 4
    println(list1)
    println(list3)

    val list4 = 10 +: list1
    println(list4)

    val list5 = 4 :: 5 :: 6 :: list1
    println("list5 = " + list5)

    val list6 = 4 :: 5 :: 6 :: list1 ::: Nil
    println("list6 = " + list6)

    val list7 = 4 :: 5 :: list1 ::: list1 ::: Nil
    println("list7 = " + list7)


  }

}
