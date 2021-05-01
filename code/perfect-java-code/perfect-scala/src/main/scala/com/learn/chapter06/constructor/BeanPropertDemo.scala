package com.learn.chapter06.constructor

import scala.beans.BeanProperty

/**
 * @author Kelly
 * @create 2021-05-01 11:02
 */
object BeanPropertyDemo {
  def main(args: Array[String]): Unit = {
    val car = new Car
    car.setName("BMW")
    val name = car.getName
    println(name)

  }

}
class Car{
  @BeanProperty
  var name: String = _
}
