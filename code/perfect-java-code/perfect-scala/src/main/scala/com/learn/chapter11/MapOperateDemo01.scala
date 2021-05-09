package com.learn.chapter11


/**
 * @author Kelly
 * @create 2021-05-08 10:59
 */
object MapOperateDemo01 {
  def main(args: Array[String]): Unit = {
    val list1 = List(3, 5, 7)
    println("list1 = " + list1)

    var list2 = List[Int]()
    // 1. 遍历 list1， 将每一个元素 *2，添加到一个新的元素里面
    for (elem <- list1) {
      list2 = list2 :+ elem * 2
    }
    println("list2 = " + list2)

    // 不够简洁，高效
    // 没有体现函数式编程特点 集合=》函数 => 新的集合 =》 函数 ..
    // 不利于处理复杂的数据处理业务
  }

}
