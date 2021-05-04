package com.learn.chapter07.visit

/**
 * @author Kelly
 * @create 2021-05-02 10:27
 */
object TestVisit {
  def main(args: Array[String]): Unit = {
    val clerk = new Clerk
    clerk.shouInfo()
//    println(clerk.age)  // protected 关键字，同包不能访问
    Clerk.test(clerk)

    val p = new Person
    println(p.name)
  }

}

class Clerk {
  var name: String = "Jack"
  private var salary: Double = 99999.9
  protected var age: Int = 10

  def shouInfo(): Unit = {
    // 在当前类中可以使用私有变量
    println("name = " + name + ", salary = " + salary)
  }
}

// 当一个文件中，出现了同名的 class 和 object，
// 类被称为伴生类：非静态的内容
// 对象为伴生对象：静态内容
// 在伴生对象中可以访问类的私有属性
object Clerk {
  def test(c: Clerk): Unit = {
    println("test() name = " + c.name + ", salary = " + c.salary)
  }
}

class Person {
  // 仍然是该类的私有属性
  // 扩大了访问权限，使得在 visit 包中也可以使用该属性
  private[visit] val name = "Jack"
}
