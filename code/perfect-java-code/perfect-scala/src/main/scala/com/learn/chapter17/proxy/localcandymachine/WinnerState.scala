package com.learn.chapter17.proxy.localcandymachine

/**
 * @author Kelly
 * @create 2021-05-14 11:34
 */
class WinnerState extends State {
  // transient注解将字段标记为瞬态的, 即表示一个域不是该对象串行化的一部分
  @transient private var mCandyMachine: CandyMachine = _

  def this(mCandyMachine: CandyMachine) {
    this
    this.mCandyMachine = mCandyMachine
  }

  override def getStateName(): String = {
    "Winner State"
  }

  // 根据当前状态， insertCoin 有不同的业务逻辑
  override def insertCoin(): Unit = {
    println("please wait! we are giving you a candy!")
  }

  override def printState(): Unit = {
    println("*** Winner State ***")
  }

  override def returnCoin(): Unit = {
    println("you haven't inserted a coin yet!")

  }

  override def turnCrank(): Unit = {
    println("we are giving you a candy,turning another get nothing,!");

  }

  override def dispense(): Unit = {
    mCandyMachine.releaseCandy()
    if (mCandyMachine.getCount() == 0) {
      mCandyMachine.setState(mCandyMachine.mSoldOutState);
    } else {
      println("you are a winner!you get another candy!")
      mCandyMachine.releaseCandy()
      if (mCandyMachine.getCount() > 0) {
        mCandyMachine.setState(mCandyMachine.mOnReadyState);
      } else {
        println("Oo,out of candies");
        mCandyMachine.setState(mCandyMachine.mSoldOutState);
      }
    }
  }
}
