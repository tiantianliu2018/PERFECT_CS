package com.learn.chapter17.proxy.localcandymachine

/**
 * @author Kelly
 * @create 2021-05-14 11:39
 */
object TestCandyMachine {
  def main(args: Array[String]): Unit = {
    // 创建一个监控器
    val monitor = new Monitor

    // 创建一个糖果机
    var candyMachine = new CandyMachine("上海-嘉定", 6)

    // 将糖果机加入监控
    monitor.addMachine(candyMachine)

    candyMachine = new CandyMachine("上海-浦东", 10)
    candyMachine.insertCoin()
    monitor.addMachine(candyMachine)

    candyMachine = new CandyMachine("上海-徐汇", 4)
    candyMachine.insertCoin()
    candyMachine.turnCrank()
    monitor.addMachine(candyMachine)

    monitor.report()
  }

}
