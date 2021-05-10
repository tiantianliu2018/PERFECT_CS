package com.learn.chapter13

/**
 * @author Kelly
 * @create 2021-05-10 10:21
 */
object PartialFunDemo02 {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, "hello")

    // PartialFunction[Any,Int] 表示偏函数接收的参数类型是 Any,返回类型是 Int
    // isDefinedAt(x: Any) 如果返回 true, 就会去调用 apply 构建对象实例, 如果是 false,过滤
    val partialFun = new PartialFunction[Any, Int] {
      override def isDefinedAt(x: Any) = {
        println("x = " + x)
        x.isInstanceOf[Int]
      }

      // apply 构造器, 对传入的值 + 1, 并返回（新的集合）
      override def apply(v1: Any) = {
        println("v1 = " + v1)
        v1.asInstanceOf[Int] + 1
      }
    }

    val list2 = list.collect(partialFun)
    println("list2 = " + list2)
  }

}
