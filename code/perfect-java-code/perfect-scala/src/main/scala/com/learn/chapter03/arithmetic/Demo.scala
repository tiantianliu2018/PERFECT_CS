package com.learn.chapter03.arithmetic

/**
 * @author Kelly
 * @create 2021-04-21 09:51
 */
object Demo {
  def main(args: Array[String]): Unit = {
    var r1 : Int = 10 / 3   // 3
    println("r1 = " + r1)

    var r2 : Double = 10 / 3   // 3.0
    println("r2 = " + r2)

    var r3: Double = 10.0 / 3   // 3.3333333333333333
    println("r3 = " + r3)

    println("r3 = " + r3.formatted("%.2f"))
  }

}
