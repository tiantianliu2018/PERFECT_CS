package com.learn.chapter17.decorator.coffeebar.mydecorator

import com.learn.chapter17.decorator.coffeebar.Drink

/**
 * @author Kelly
 * @create 2021-05-14 10:14
 */
class NewMilk(obj: Drink) extends Decorator(obj) {

  super.setDescription("NewMilk")
  super.setPrice(4.0f)

}
