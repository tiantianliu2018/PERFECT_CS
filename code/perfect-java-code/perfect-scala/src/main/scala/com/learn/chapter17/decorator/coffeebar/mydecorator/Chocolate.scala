package com.learn.chapter17.decorator.coffeebar.mydecorator

import com.learn.chapter17.decorator.coffeebar.Drink

/**
 * @author Kelly
 * @create 2021-05-14 10:08
 */
class Chocolate(obj: Drink) extends Decorator(obj) {
  super.setDescription("Chocolate")
  super.setPrice(3.0f)
}
