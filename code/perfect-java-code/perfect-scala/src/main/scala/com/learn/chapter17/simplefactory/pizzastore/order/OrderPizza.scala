package com.learn.chapter17.simplefactory.pizzastore.order

import com.learn.chapter17.simplefactory.pizzastore.pizza.Pizza

import scala.io.StdIn
import scala.util.control.Breaks.{break, breakable}

/**
 * @author Kelly
 * @create 2021-05-13 15:42
 */
class OrderPizza {
  var orderType: String = _
  var pizza: Pizza = _

  breakable {
    do {
      println("请输入 pizza 的类型, 使用简单工厂模式~~")
      orderType = StdIn.readLine()
      pizza = SimpleFactory.createPizza(orderType)
      if (pizza == null) {
        break()
      }
      this.pizza.prepare()
      this.pizza.bake()
      this.pizza.cut()
      this.pizza.box()
    } while (true)
  }
}
