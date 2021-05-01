package com.learn.chapter06.constructor

/**
 * @author Kelly
 * @create 2021-04-30 11:07
 */
object ConstructorDemo02 {
  def main(args: Array[String]): Unit = {
    val p1 = new Person("Jack")
    p1.showInfo()
  }

}
class Person(){
  var name: String = _
  var age: Int = _

  // 辅助构造器
  def this(name : String) {
    this()  // 直接调用主构造器
    this.name = name
  }

  def this(name: String, age: Int) {
    this()
    this.name = name
    this.age = age
  }

  def this(age: Int) {
    this("匿名")
    this.age = age
  }

  def showInfo(): Unit ={
    println("person 信息如下：")
    println("name = " + this.name)
    println("age = " + this.age)
  }
}
