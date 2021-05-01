package com.learn.chapter06.oop

/**
 * @author Kelly
 * @create 2021-04-30 10:03
 */
object PropertyDemo {
  def main(args: Array[String]): Unit = {
    val p1 = new Person2
    println(p1.name)
    println(p1.address.isInstanceOf[String])

  }

}
class Person2{
  var age: Int = 10
  var sal = 8090.0
  var name = null
  var address: String = null
}
