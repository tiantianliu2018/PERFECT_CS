package com.learn.chapter17.simplefactory.pizzastore.pizza

/**
 * @author Kelly
 * @create 2021-05-13 15:36
 */
class CheesePizza extends Pizza {
  override def prepare(): Unit = {
    this.name = "Cheese Pizza"
    println(this.name + " preparing")
  }
}
