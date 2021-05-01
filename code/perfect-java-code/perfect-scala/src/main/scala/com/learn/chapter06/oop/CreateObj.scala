package com.learn.chapter06.oop

/**
 * @author Kelly
 * @create 2021-04-30 10:13
 */
object CreateObj {
  def main(args: Array[String]): Unit = {
    val emp = new Emp  // emp 类型是 Emp
    // 如果希望将子类对象交给父类的一个引用，要指明变量的类型
    val person: Person1 = new Emp

  }

}
class Person1{

}
class Emp extends Person1{

}