package com.learn.chapter17.decorator.coffeebar.mydecorator

import com.learn.chapter17.decorator.coffeebar.Drink

/**
 * @author Kelly
 * @create 2021-05-14 10:10
 */
class Decorator extends Drink {
  //  drink 是被装饰的对象
  private var drink: Drink = null

  def this(drink: Drink) {
    this
    this.drink = drink
  }

  // 实现 cost 方法，递归方式实现
  override def cost(): Float = {
    super.getPrice() + drink.cost()
  }

  override def getDescription(): String = {
    super.getDescription() + " && " + drink.getDescription()
  }
}
