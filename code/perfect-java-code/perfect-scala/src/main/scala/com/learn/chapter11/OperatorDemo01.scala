package com.learn.chapter11

/**
 * @author Kelly
 * @create 2021-05-09 10:37
 */
object OperatorDemo01 {
  def main(args: Array[String]): Unit = {
    val n1 = 1
    val n2 = 2
    val r1 = n1 + n2 // 3
    println("r1 = " + r1)

    val r2 = n1.+(n2) // 3 看 Int 的源码即可说明
    println("r2 = " + r2)

    val monster = new Monster
    monster + 10
    println("monster.money=" + monster.money) // 20

    monster.+(10)
    println("monster.money=" + monster.money) // 30

    println(monster++)
    println("monster.money=" + monster.money) // 31

    println(monster.++)
    println("monster.money=" + monster.money) // 32

    !monster
    println("monster.money=" + monster.money) // -32
  }

}

class Monster {
  var money: Int = 10

  //对操作符进行重载 (中置操作符)
  def +(n:Int): Unit = { this.money += n }

  //对操作符进行重载(后置操作符)
  def ++(): Unit = { this.money += 1 }

  //对操作符进行重载(前置操作符，一元运算符)
  def unary_!(): Unit = { this.money = -this.money }
}
