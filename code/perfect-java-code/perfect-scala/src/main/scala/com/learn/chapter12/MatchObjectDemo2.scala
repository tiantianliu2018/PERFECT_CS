package com.learn.chapter12

/**
 * @author Kelly
 * @create 2021-05-09 17:35
 */
object MatchObjectDemo2 {
  def main(args: Array[String]): Unit = {
    val namesString = "Alice,Bob,Thomas" // 字符串
    namesString match {
      case Names(first, second, third) => {
        println("the string contains three people's names")
        // 打印字符串
        println(s"$first $second $third")
      }
      case _ => println("nothing matched")
    }
  }
}

object Names {
//  def apply: Any = ???
  def unapplySeq(str: String): Option[Seq[String]] = {
    if (str.contains(",")) Some(str.split(","))
    else None
  }
}
