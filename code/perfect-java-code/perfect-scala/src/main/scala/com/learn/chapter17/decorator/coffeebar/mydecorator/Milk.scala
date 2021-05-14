package com.learn.chapter17.decorator.coffeebar.mydecorator

import com.learn.chapter17.decorator.coffeebar.Drink

/**
 * @author Kelly
 * @create 2021-05-14 10:13
 */
class Milk(obj: Drink) extends Decorator(obj) {

  super.setDescription("Milk")
  super.setPrice(2.0f)

}
