package com.learn.chapter12

/**
 * @author Kelly
 * @create 2021-05-09 17:27
 */
object MatchObject {
  def main(args: Array[String]): Unit = {
    val number: Double = Square(5.0)

    number match {
      /**
       * 当匹配到 case Square(n)
       * 调用 Square 的 unapply(z: Double), z 的值就是 number
       */
      case Square(n) => println("匹配成功 n = " + n)
      case _ => println("nothing matched")
    }
  }

}

object Square {
  def apply(d: Double): Double = d * d

  def unapply(z: Double): Option[Double] = {
    println("unapply 被调用 z = " + z)
    Some(math.sqrt(z))
//    None
  }
}
