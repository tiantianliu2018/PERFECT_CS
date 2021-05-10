package com.learn.chapter13

/**
 * @author Kelly
 * @create 2021-05-10 11:20
 *
 * 函数柯里化
 */
object CurryDemo01 {
  def main(args: Array[String]): Unit = {
    def mul(x: Int, y: Int) = x * y
    println(mul(3, 4))

    // 接受多个参数的函数都可以转化为接受单个参数的函数，
    def mulCurry(x: Int) = (y: Int) => x * y
    println(mulCurry(3)(4))

    def mulCurry2(x: Int)(y: Int) = x * y
    println(mulCurry2(3)(4))
  }

}
