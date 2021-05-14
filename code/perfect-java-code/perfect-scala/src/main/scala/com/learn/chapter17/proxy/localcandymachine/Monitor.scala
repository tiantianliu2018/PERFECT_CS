package com.learn.chapter17.proxy.localcandymachine

import scala.collection.mutable.ListBuffer

/**
 * @author Kelly
 * @create 2021-05-14 11:40
 */
class Monitor {
  // 监控的糖果机列表
  private val candyMachineList: ListBuffer[CandyMachine] = ListBuffer()

  // 给监控器增加一个糖果机
  def addMachine(mCandyMachine: CandyMachine): Unit = {
    candyMachineList.append(mCandyMachine)
  }

  //输出该监控器，管理的各个糖果机的信息
  def  report() = {
    //var mCandyMachine:CandyMachine = null
    for (mCandyMachine <- this.candyMachineList) {
      println("----------------------------------------")
      println("Machine Loc = " + mCandyMachine.getLocation())
      println("Machine Candy count = " + mCandyMachine.getCount())
      println("Machine State = " + mCandyMachine.getState().getStateName())
    }
  }
}
