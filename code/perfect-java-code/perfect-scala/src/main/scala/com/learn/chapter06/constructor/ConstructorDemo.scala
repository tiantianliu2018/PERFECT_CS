package com.learn.chapter06.constructor

/**
 * @author Kelly
 * @create 2021-04-30 10:53
 */
object ConstructorDemo {
  def main(args: Array[String]): Unit = {
//    var p1 = new Person("Jack", 20)
//    println(p1)
    val p2 = new Person1("Tom")
    println(p2)
  }
}
class Person1(inName: String, inAge: Int) {
  // 创建 Person 对象的时候同时初始化对象的 name 和 age 属性
  var name: String = inName
  var age: Int = inAge
  age += 10
  println("~~~~~~~~~")

  override def toString: String = {
    "name = " + this.name + ", age = " + this.age
  }

  println("ok~~~~~~~")
  println("age = " + this.age)

  def this(name:String) {
    // 辅助构造器必须在第一行显式调用主构造器，可以是直接也可以是间接
    this("Jack", 10)
    this.name = name
  }
}
