package com.learn.chapter07.myextends

/**
 * @author Kelly
 * @create 2021-05-02 11:20
 */
object TypeConvert {
  def main(args: Array[String]): Unit = {

    // classOf 可以得到类名
    println(classOf[String])
    val s = "king"
    println(s.getClass.getName)  // 使用反射机制

    // isInstanceOf asInstanceOf
    var p1 = new Person200
    var emp = new Emp200

    // 将子类引用交给父类，自动向上转型
    p1 = emp

    // 将父类引用重新转换为子类，向下转型
    val emp2 = p1.asInstanceOf[Emp200]

    emp2.printName()
    emp2.sayHello()

  }

}
class Person200 {
  var name = "tom"

  def printName(): Unit = {
    println("Person printName(): " + name)
  }

  def sayHi(): Unit = {
    println("Hi~~")
  }
}

class Emp200 extends Person200 {
  override def printName(): Unit = {
    println("Emp printName(): " + this.name)

    // 调用父类的方法
    super.printName()
    sayHi()
  }

  def sayHello(): Unit = {
    println("Hello~~")
  }
}
