package com.learn.chapter17.simplefactory.pizzastore.pizza

/**
 * @author Kelly
 * @create 2021-05-13 15:39
 */
class PepperPizza extends Pizza {
  override def prepare(): Unit = {
    this.name = "Pepper Pizza"
    println(this.name + " preparing...")
  }
}
