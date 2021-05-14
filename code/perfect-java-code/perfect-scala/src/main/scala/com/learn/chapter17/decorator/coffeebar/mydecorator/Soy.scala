package com.learn.chapter17.decorator.coffeebar.mydecorator

import com.learn.chapter17.decorator.coffeebar.Drink

/**
 * @author Kelly
 * @create 2021-05-14 10:15
 */
class Soy(obj: Drink) extends Decorator(obj) {

  super.setDescription("Soy")
  super.setPrice(1.5f)

}
