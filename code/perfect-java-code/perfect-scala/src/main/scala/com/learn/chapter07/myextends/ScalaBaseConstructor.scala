package com.learn.chapter07.myextends

/**
 * @author Kelly
 * @create 2021-05-03 10:38
 */
object ScalaBaseConstructor {
  def main(args: Array[String]): Unit = {
    // 先构建父类部分 extends Person
    // Person 主构造器部分
    // Emp 主构造器
    // Emp 辅助构造器
    val emp = new Emp("Lisi")
    println("=====================")

    val emp2 = new Emp("Marry")

    println("**************************")

    val emp3 = new Emp("smith")
    println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%")

    val emp4 = new Emp("terry", 10)
    emp4.showInfo() // 雇员的名字 terry
  }

}

// 父类
class Person(pName: String) {
  var name = pName
  println("Person...")
  println("name = " + this.name)

  def this() {
    this("默认名字") // 显示调用主构造器
    println("Person 辅助构造器")
  }
}

// 子类继承父类
class Emp(eName: String, eAge: Int) extends Person(eName) {
  println("Emp...")

  def this(name: String) {
    this(name, 100)  // 调用主构造器
    this.name = name
    println("Emp 辅助构造器 ~")
  }

  def showInfo(): Unit = { println("雇员的名字 ", name) }
}
