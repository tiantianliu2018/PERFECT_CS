package com.learn.chapter17.proxy.localcandymachine

/**
 * @author Kelly
 * @create 2021-05-14 11:28
 */
class OnReadyState extends State {
  @transient private var mCandyMachine: CandyMachine = _

  def this(mCandyMachine: CandyMachine) {
    this
    this.mCandyMachine = mCandyMachine
  }

  override def insertCoin(): Unit = {
    println("you have inserted a coin, next, please turn crank!")
    // 同时给糖果机设置，有硬币的状态
    this.mCandyMachine.setState(mCandyMachine.mHasCoin)
  }

  override def returnCoin(): Unit = println("you haven't inserted a coin yet!")

  override def turnCrank(): Unit = println("you turned, but you haven't inserted a coin!")

  override def printState(): Unit = println("*** On Ready State ***")

  override def getStateName(): String = "On Ready State"

  override def dispense(): Unit = {

  }
}
