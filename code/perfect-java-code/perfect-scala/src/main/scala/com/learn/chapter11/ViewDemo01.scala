package com.learn.chapter11

/**
 * @author Kelly
 * @create 2021-05-09 10:30
 */
object ViewDemo01 {
  def main(args: Array[String]): Unit = {
    def multiple(num: Int): Int = {
      num
    }

    //如果这个数， 逆序后和原来数相等，就返回 true,否则返回 false
    def eq(num: Int): Boolean = {
//      println("eq 被调用.." )
      num.toString.equals(num.toString.reverse)
    }

    //    没有使用 view, 常规方式
    val seq = (1 to 100).filter(eq)
    println(seq)

    // 不立刻执行，在使用到结果才执行，则可以使用 view 来进行优化
    val seq2 = (1 to 100).view.filter(eq)
    println(seq2)

    for (item <- seq2) {
      println("item = " + item)
    }

  }

}
