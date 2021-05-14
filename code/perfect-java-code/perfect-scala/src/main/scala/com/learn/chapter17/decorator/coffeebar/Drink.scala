package com.learn.chapter17.decorator.coffeebar

/**
 * @author Kelly
 * @create 2021-05-13 16:30
 *
 * 抽象类
 */
abstract class Drink {
  var description = ""
  private var price = 0.0f

  def setDescription(description: String): Unit ={
    this.description = description
  }

  def getDescription(): String = {
    this.description
  }

  def setPrice(price: Float): Unit = {
    this.price = price
  }

  def getPrice(): Float = {
    this.price
  }

  // 将计算成本的方法做成一个抽象方法 cost
  def cost(): Float


}
