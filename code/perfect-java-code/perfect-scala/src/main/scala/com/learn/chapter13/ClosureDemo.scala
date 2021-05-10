package com.learn.chapter13

/**
 * @author Kelly
 * @create 2021-05-10 11:14
 *
 * 函数闭包
 * 1) 编写一个函数 makeSuffix(suffix: String) 可以接收一个文件后缀名(比如.jpg)，并返回一个闭包
 * 2) 调用闭包，可以传入一个文件名，如果该文件名没有指定的后缀(比如.jpg), 则返回 文件名.jpg, 如果已经有 .jpg 后缀，则返回原文件名
 * 3) 要求使用闭包的方式完成
 */
object ClosureDemo {
  def main(args: Array[String]): Unit = {
    val f = makeSuffix(".jpg")

    println(f("dog.jpg"))
    println(f("cat"))

  }

  def makeSuffix(suffix: String) = {
    // 返回一个匿名函数，回使用到 suffix
    (filename: String) => {
      if (filename.endsWith(".jpg")) {
        filename
      } else {
        filename + suffix
      }
    }
  }

}
