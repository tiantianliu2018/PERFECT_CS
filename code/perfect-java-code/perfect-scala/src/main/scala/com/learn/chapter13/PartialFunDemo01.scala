package com.learn.chapter13

/**
 * @author Kelly
 * @create 2021-05-10 09:50
 * 给你一个集合 val list = List(1, 2, 3, 4, "abc") ，
 * 请完成如下要求: 将集合 list 中的所有数字+1，并返回一个新的集合
 * 要求忽略掉 非数字 的元素，即返回的 新的集合 形式为 (2, 3, 4, 5)
 */
object PartialFunDemo01 {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, "abc")
    println(list.filter(f1).map(f3).map(f2))
  }

  def f1(n: Any): Boolean = {
    n.isInstanceOf[Int]
  }

  def f2(n: Int): Int = {
    n + 1
  }

  def f3(n: Any): Int = {
    n.asInstanceOf[Int]
  }

}
