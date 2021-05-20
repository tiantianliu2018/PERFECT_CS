package com.learn.chapter18.viewbounds

/**
 * @author Kelly
 * @create 2021-05-20 11:05
 */
object ViewBoundsDemo {
  def main(args: Array[String]): Unit = {
    val tom = new Person("Tom", 13)
    val jack = new Person("Jack", 10)

    import MyImplicit._
    val compareCommon = new CompareCommon(tom, jack)
    println(compareCommon.greater)
    println(compareCommon.greater2)

  }

}

class Person(val name: String, val age: Int) {
  override def toString: String = this.name + "\t" + this.age
}

class CompareCommon[T <% Ordered[T]](obj1: T, obj2: T) {
  def greater = if (obj1 > obj2) obj1 else obj2

  def greater2 = if (obj1.compare(obj2) > 0) obj1 else obj2
}