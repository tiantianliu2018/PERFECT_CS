package com.learn.chapter07.myextends

/**
 * @author Kelly
 * @create 2021-05-02 11:14
 */
object MethodOverride {
  def main(args: Array[String]): Unit = {
    val emp = new NewEmp
    emp.printName()
  }

}

class NewPerson {
  var name: String = "Marry"

  def printName(): Unit = {
    println("name = " + this.name)
  }

  def sayHi(): Unit = {
    println(this.name + " say Hi~~")
  }
}
class NewEmp extends NewPerson {
  // 显式的使用 override, 覆盖父类的方法
  override def printName(): Unit = {
    println("Emp printName() " + name)

    // 在子类中调用父类的方法，使用 super
    super.printName()

    sayHi()
  }
}