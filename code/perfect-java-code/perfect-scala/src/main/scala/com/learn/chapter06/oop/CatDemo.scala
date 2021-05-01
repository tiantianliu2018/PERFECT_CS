package com.learn.chapter06.oop

/**
 * @author Kelly
 * @create 2021-04-28 10:03
 */
object CatDemo {
  def main(args: Array[String]): Unit = {
    // 创建一只猫
    val cat = new Cat
    // 给猫的属性赋值
    cat.name = "小白"
    cat.age = 3
    cat.color = "白色"
    println("ok")
    printf("\n小猫的信息如下：%s %d %s", cat.name, cat.age, cat.color)

  }

}

class Cat{
  // 定义/声明三个属性
  var name:String = ""
  var age:Int = _  // 表示给 age 一个默认值
  var color:String = _
}
