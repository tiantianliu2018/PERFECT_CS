package com.learn.chapter08

import com.learn.chapter08.Frock.currentNum

/**
 * @author Kelly
 * @create 2021-05-04 11:42
 */
object Exercise {
  def main(args: Array[String]): Unit = {
    val frock1 = new Frock
    frock1.printNum()

    val frock2 = new Frock
    frock2.printNum()

    val frock3 = new Frock
    frock3.printNum()
  }

}

class Frock {
  var serialNum: Int = _

  val num = Frock.getNextNum()
  this.serialNum = num

  def printNum(): Unit = {
    printf("当前服装编号为：%d \n", serialNum)
  }
}
object Frock {
  private var currentNum: Int = 100000

  def getNextNum(): Int = {
    currentNum += 100
    currentNum
  }
}
