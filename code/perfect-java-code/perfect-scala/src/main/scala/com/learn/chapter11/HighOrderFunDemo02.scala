package com.learn.chapter11

/**
 * @author Kelly
 * @create 2021-05-08 11:10
 */
object HighOrderFunDemo02 {

  def sayOk() = println("OK~")

  def main(args: Array[String]): Unit = {
    test(sayOk)
  }

  def test(f:() => Unit) = {
    f()
  }

  
}
