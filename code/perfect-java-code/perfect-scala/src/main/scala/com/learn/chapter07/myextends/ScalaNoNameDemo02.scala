package com.learn.chapter07.myextends

/**
 * @author Kelly
 * @create 2021-05-03 11:48
 */
object ScalaNoNameDemo02 {
  def main(args: Array[String]): Unit = {
    val monster = new Monster {
      override var name: String = "Jack"

      override def cry(): Unit = {
        println("哇哇哇")
      }
    }

    monster.cry()
  }

}

abstract class Monster {
  var name: String

  def cry()
}
