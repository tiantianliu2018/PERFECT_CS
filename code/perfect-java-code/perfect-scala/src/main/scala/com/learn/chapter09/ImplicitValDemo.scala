package com.learn.chapter09

/**
 * @author Kelly
 * @create 2021-05-05 10:18
 */
object ImplicitValDemo {
  def main(args: Array[String]): Unit = {
    // 隐式值
//    implicit val str1: String = "Jack"

    //    同时有隐式值和参数默认值，隐式值 > 参数默认值
    def sayHello(implicit name: String = "Tom"): Unit = {
      println(name + ", Hello~")
    }

    sayHello

    //    当一个隐式参数匹配不到隐式值，仍然会使用默认值
    implicit val num: Int = 10
    def sayHi(implicit content: String = "Marry"): Unit = {
      println("Hello, " + content)
    }
    sayHi
  }

}
