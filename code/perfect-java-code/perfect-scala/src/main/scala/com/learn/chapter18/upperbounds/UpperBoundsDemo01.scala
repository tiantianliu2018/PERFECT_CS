package com.learn.chapter18.upperbounds

/**
 * @author Kelly
 * @create 2021-05-20 09:57
 */
object UpperBoundsDemo01 {
  def main(args: Array[String]): Unit = {
    val compareInt = new CompareInt(10, 40)
    println("res = " + compareInt.greater)

    // 上界的用法
    val value1 = new CommonCompare(Integer.valueOf(10), Integer.valueOf(40))
    println("value1 = " + value1.greater)

    val value2 = new CommonCompare(java.lang.Float.valueOf(1.1f), java.lang.Float.valueOf(2.1f))
    println("value2 = " + value2.greater)
  }

}


/**
 * 编写一个通用的类， 可以进行 Int 之间、Float 之间、等
 * 实现了 Comparable 接口的值直接的比较. //java.lang.Integer
 * 分别使用传统方法和上界的方式来完成，体会上界使用的好处.
 */

// 传统方法
class CompareInt(n1: Int, n2: Int) {
  // 返回较大的值
  def greater = if (n1 > n2) n1 else n2
}

/**
 * 使用上界(上限)来完成
 * [T <: Comparable[T]] 表示 T 类型是 Comparable 子类型
 * 这样的写法(使用上界的写法)通用性比传统的好
 * @param obj1
 * @param obj2
 * @tparam T 传入的 T 类要继承 Comparable 接口
 */
class CommonCompare[T <: Comparable[T]](obj1: T, obj2: T) {
  def greater = if (obj1.compareTo(obj2) > 0) obj1 else obj2
}
