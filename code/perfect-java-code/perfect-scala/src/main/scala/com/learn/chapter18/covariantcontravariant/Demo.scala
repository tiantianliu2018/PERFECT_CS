package com.learn.chapter18.covariantcontravariant

/**
 * @author Kelly
 * @create 2021-05-20 11:59
 */
object Demo {
  def main(args: Array[String]): Unit = {
    val t1: Temp[Sub] = new Temp[Sub]("hello")
    println("t1 = " + t1)

//    val t2: Temp[Sub] = new Temp[Super]("Hi")  // error
//    val t2: Temp[Super] = new Temp[Sub]("Hi")  // error

    val t4: Temp2[Sub] = new Temp2[Sub]("hello"); //ok
    println("t4 = " + t4)
    val t5: Temp2[Super] = new Temp2[Sub]("hello"); //ok
    println("t5 = " + t5)

//    val t6: Temp2[Sub] = new Temp2[Super]("hello"); // error
//    println("t2 = " + t2)

    val t7: Temp3[Sub] = new Temp3[Sub]("hello");   //ok
    val t8: Temp3[Sub] = new Temp3[Super]("hello"); //ok
//    val t9: Temp3[Super] = new Temp3[Sub]("hello"); //ok
  }

}
class Super

class Sub extends Super

class Temp[A](title: String) {
  override def toString: String = title
}

class Temp2[+A](title: String) {
  override def toString: String = title
}

class Temp3[-A](title: String) {
  override def toString: String = title
}