package com.learn.chapter17.singleton

/**
 * @author Kelly
 * @create 2021-05-13 16:09
 */
object TestSingleTon {
  def main(args: Array[String]): Unit = {
    val instance1 = SingleTon.getInstance()
    val instance2 = SingleTon.getInstance()
    if (instance1 == instance2) {
      println("两个实例对象相等")
    }
  }

}

// 将 SingleTon 的构造方法私有化
class SingleTon private() {}

// 懒汉式
object SingleTon {
  private var s: SingleTon = null

  def getInstance() = {
    if (s == null) {
      s = new SingleTon
    }
  }
}