package com.learn.chapter17.decorator.coffeebar

import com.learn.chapter17.decorator.coffeebar.mycoffee.{Decaf, LongBlack}
import com.learn.chapter17.decorator.coffeebar.mydecorator.{Chocolate, Milk, NewMilk}

/**
 * @author Kelly
 * @create 2021-05-13 16:34
 */
object CoffeeBar {
  def main(args: Array[String]): Unit = {
    println("咖啡 bar..")

    val order: Drink = new Decaf
    println("order1 price = " + order.cost()) // 3.0
    println("order1 desc = " + order.getDescription())

    println("------------------------------------------")
    //  点一份 LongBlack,并加入 1 份 Milk 和 2 份 Chocolate
    var order2: Drink = new LongBlack // 5.4
    println("LongBlack price = " + order2.cost())
    order2 = new Milk(order2) // 2.0
    order2 = new Chocolate(order2)// 3.0
    order2 = new Chocolate(order2)// 3.0
    order2 = new NewMilk(order2)
    //
    println("order2 price = " + order2.cost()); //
    println("order2 desc = " + order2.getDescription())
  }

}
