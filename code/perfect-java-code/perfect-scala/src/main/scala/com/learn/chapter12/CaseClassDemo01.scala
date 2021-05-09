package com.learn.chapter12

/**
 * @author Kelly
 * @create 2021-05-09 17:44
 */
object CaseClassDemo01 {
  def main(args: Array[String]): Unit = {
    println("hello~~")
  }

}
abstract class Amount
case class Dollar(value: Double) extends Amount
case class Currency(value: Double, unit: String) extends Amount
case object NoAmount extends Amount
