package com.learn.chapter17.simplefactory.pizzastore.pizza

/**
 * @author Kelly
 * @create 2021-05-13 15:37
 */
class GreekPizza extends Pizza {
  override def prepare(): Unit = {
    this.name = "Greek Pizza"
    println(this.name + " preparing...")
  }
}
