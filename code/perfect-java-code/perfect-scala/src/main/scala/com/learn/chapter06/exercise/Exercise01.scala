package com.learn.chapter06.exercise

/**
 * @author Kelly
 * @create 2021-04-30 10:28
 */
object Exercise01 {
  def main(args: Array[String]): Unit = {
    val rectangle = new Rectangle
    rectangle.printRect()

    rectangle.len = 10
    rectangle.width = 8
    println("Rectangle Area = " + rectangle.calArea())
  }

}
class Rectangle {
  // 属性
  var len = 0.0
  var width = 0.0

  // 方法
  def printRect(): Unit = {
    for (i <-0 until 10) {
      for (j <-0 until(8)) {
        print("*")
      }
      println()
    }
  }

  def calArea(): Double ={
    (this.len * this.width).formatted("%.2f").toDouble
  }
}