package com.learn.chapter07.mypackage

import com.learn.chapter07.mypackage.xm.Tiger

/**
 * @author Kelly
 * @create 2021-05-01 11:44
 */
object TestTiger {
  def main(args: Array[String]): Unit = {
    val tiger1 = new com.learn.chapter07.mypackage.xm.Tiger
    val tiger2 = new com.learn.chapter07.mypackage.xh.Tiger
    println("Tiger1 = " + tiger1 + "\nTiger2 = " + tiger2)
  }
}
