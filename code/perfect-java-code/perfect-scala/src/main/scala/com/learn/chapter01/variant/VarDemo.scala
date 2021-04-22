package com.learn.chapter01.variant

/**
 * @author Kelly
 * @create 2021-04-20 09:39
 */
object VarDemo {
  def main(args: Array[String]): Unit = {
    var age:Int = 10
    var salary:Double = 10.9
    var name:String = "Tom"
    var isPass:Boolean = true
    var score:Float = 98.5F
    println(s"name:${name} age=${age} salary=${salary} ")

    var age2 = 10
    println(age2.isInstanceOf[Int])

    // var 和 val 的区别
    // var 修饰的变量可改变，val 修饰的变量不可改变
    var age3 = 10
    age3 = 30
  }

}
