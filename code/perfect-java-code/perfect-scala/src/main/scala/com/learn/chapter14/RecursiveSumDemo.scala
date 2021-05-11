package com.learn.chapter14

import java.text.SimpleDateFormat
import java.util.Date

/**
 * @author Kelly
 * @create 2021-05-11 09:49
 */
object RecursiveSumDemo {
  def main(args: Array[String]): Unit = {
    val now = new Date()
    val dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    val date = dateFormat.format(now)
    println("date = " + date) // 输出时间

    var res = BigInt(0)
    var num = BigInt(1)

    // 传统方式
    var maxVal = BigInt(99999999l)
    while (num <= maxVal) {
      res += num
      num += 1
    }
    println("res = " + res)

    val date2 = dateFormat.format(new Date())
    println("date2 = " + date2)

    // 递归方式
    def mx(num: BigInt, sum: BigInt): BigInt = {
      if (num <= 99999999l) return mx(num + 1, sum + num)
      else return sum
    }

    var sum = BigInt(0)
    var num2 = BigInt(1)
    var res2 = mx(num2, sum)
    println("res2 = " + res2)

    val date3 = dateFormat.format(new Date())
    println("date3 = " + date3)
  }

}
