package com.learn.chapter17.simplefactory.pizzastore.order

import com.learn.chapter17.simplefactory.pizzastore.pizza.{CheesePizza, GreekPizza, PepperPizza, Pizza}

/**
 * @author Kelly
 * @create 2021-05-13 15:46
 */
object SimpleFactory {

  def createPizza(t: String): Pizza ={
    var pizza: Pizza = null
    if (t.equals("greek")) {
      pizza = new GreekPizza
    } else if (t.equals("pepper")) {
      pizza = new PepperPizza
    } else if (t.equals("cheese")) {
      pizza = new CheesePizza
    }
    pizza
  }

}
