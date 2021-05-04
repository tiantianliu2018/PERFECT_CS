package com.learn.chapter08

/**
 * @author Kelly
 * @create 2021-05-04 11:00
 */
object AccompanyObject {
  def main(args: Array[String]): Unit = {
    println(ScalaPerson.sex)
    ScalaPerson.sayHi()
  }

}

// 伴生类
class ScalaPerson {
  var name: String = _
}

// 伴生对象
object ScalaPerson {
  var sex: Boolean = true

  def sayHi(): Unit = {
    println("object ScalaPerson sayHi~~")
  }
}
