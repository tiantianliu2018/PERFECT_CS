package com.learn.chapter12

/**
 * @author Kelly
 * @create 2021-05-09 17:49
 */
object CaseClassDemo02 {
  def main(args: Array[String]): Unit = {
    for (amt <- Array(Dollar2(1000.0), Currency2(1000.0, "RMB"), NoAmount2)) {
      val result = amt match {
        case Dollar2(v) => "$" + v
        case Currency2(v, u) => v + " " + u
        case NoAmount2 => ""
      }
      println(amt + ": " + result)
    }
  }
}
abstract class Amount2
case class Dollar2(value: Double) extends Amount2 // 样例类
case class Currency2(value: Double, unit: String) extends Amount2 // 样例类
case object NoAmount2 extends Amount2 // 样例类