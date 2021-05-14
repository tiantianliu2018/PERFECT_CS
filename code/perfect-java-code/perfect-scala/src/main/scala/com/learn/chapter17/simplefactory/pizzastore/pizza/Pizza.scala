package com.learn.chapter17.simplefactory.pizzastore.pizza

/**
 * @author Kelly
 * @create 2021-05-13 15:27
 */
abstract class Pizza {
  var name: String = _

  // 抽象方法
  def prepare()

  def cut(): Unit ={
    println(this.name + " cutting...")
  }

  def bake(): Unit = {
    println(this.name + " baking...")
  }

  def box(): Unit = {
    println(this.name + " boxing...")
  }

}
