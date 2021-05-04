package com.learn.chapter07.myextends

/**
 * @author Kelly
 * @create 2021-05-02 11:09
 */
object ExtendsDemo {
  def main(args: Array[String]): Unit = {
    val student = new Student
    student.name = "Jack"
    student.age = 10

    student.showInfo()
    student.studying()

  }

}

class Person1 {
  var name: String = _
  var age: Int = _
  def showInfo(): Unit ={
    println("学生信息如下：")
    println("name = " + name + ", age = " + age)
  }
}

class Student extends Person1 {
  def studying(): Unit = {
    println(this.name + " 在学习 scala...")
  }
}
