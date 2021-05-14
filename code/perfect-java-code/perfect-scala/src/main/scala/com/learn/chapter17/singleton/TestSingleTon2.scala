package com.learn.chapter17.singleton

/**
 * @author Kelly
 * @create 2021-05-13 16:15
 */
object TestSingleTon2 {
  def main(args: Array[String]): Unit = {
    val instance1 = SingleTon2.getInstance()
    val instance2 = SingleTon2.getInstance()

    if (instance1 == instance2) {
      println("两个实例对象相等")
    }
  }

}

class SingleTon2 private() {}

// 饿汉式
object SingleTon2 {
  private val s: SingleTon2 = new SingleTon2

  def getInstance() = {
    s
  }
}
