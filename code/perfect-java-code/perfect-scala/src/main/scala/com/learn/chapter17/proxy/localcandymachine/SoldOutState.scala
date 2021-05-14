package com.learn.chapter17.proxy.localcandymachine

/**
 * @author Kelly
 * @create 2021-05-14 11:24
 */

// 销售完的状态
class SoldOutState extends State {

  // @transient 注解将字段标记为瞬态的, 即表示一个域不是该对象串行化的一部分
  @transient private var mCandyMachine: CandyMachine = _

  def this(mCandyMachine: CandyMachine) {
    this
    this.mCandyMachine = mCandyMachine
  }

  override def insertCoin(): Unit = println("you can't insert coin, the machine sold out!")

  override def returnCoin(): Unit = println("you can't return, you haven't inserted a coin yet!")

  override def turnCrank(): Unit = println("you turned, but there are no candies!")

  override def printState(): Unit = println("*** Sold Out State ***")

  override def getStateName(): String = "sold out state"

  override def dispense(): Unit = {

  }
}
