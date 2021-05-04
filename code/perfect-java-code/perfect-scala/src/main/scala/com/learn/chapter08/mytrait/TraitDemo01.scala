package com.learn.chapter08.mytrait

/**
 * @author Kelly
 * @create 2021-05-04 11:58
 */
object TraitDemo01 {
  def main(args: Array[String]): Unit = {
    println("~~~~~")
    val sheep = new Sheep
    sheep.sayHi()
    sheep.sayHello()
  }

}
trait Trait01 {
  // 抽象方法
  def sayHi()

  def sayHello(): Unit = {
    println("普通方法 sayHello()")
  }
}

class Sheep extends Trait01 {
  override def sayHi(): Unit = println("小羊 say Hi~~~")
}
