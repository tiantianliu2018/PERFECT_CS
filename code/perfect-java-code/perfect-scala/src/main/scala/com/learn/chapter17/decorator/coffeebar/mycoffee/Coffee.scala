package com.learn.chapter17.decorator.coffeebar.mycoffee

import com.learn.chapter17.decorator.coffeebar.Drink

/**
 * @author Kelly
 * @create 2021-05-13 16:36
 */

// 在 Drink 和 单品咖啡，我做了一个缓冲层
// 这里是为了扩展，针对当前项目可以不要
class Coffee extends Drink {
  override def cost(): Float = super.getPrice()
}
