package com.learn.sparkcore.test

/**
 * @author Kelly
 * @create 2021-04-20 14:51
 */
class Task extends Serializable {
  val data = List(1, 2, 3, 4)

  val logic = (num:Int) => {num * 2}

  // 定义计算
//  def calculate() = {
//    data.map(logic)
//  }
}
