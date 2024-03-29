package com.learn.chapter17.proxy.localcandymachine

/**
 * @author Kelly
 * @create 2021-05-14 11:31
 */
// 用户插入了一块硬币的状态
class HasCoin extends State {
  //@transient注解将字段标记为瞬态的,即表示一个域不是该对象串行化的一部分
  @transient private var mCandyMachine: CandyMachine = _

  //观察的是这个 mCandyMachine糖果机
  def this(mCandyMachine: CandyMachine) {
    this
    this.mCandyMachine = mCandyMachine
  }

  override def getStateName(): String = {
    "HasCoin State"
  }

  //根据当前状态，我们的insertCoin有不同的业务逻辑
  override def insertCoin(): Unit = {
    println("you can't insert another coin!")
  }

  override def printState(): Unit = {
    println("*** HasCoin ***")
  }

  override def returnCoin(): Unit = {
    println("coin return!")
    //如果在有 Coin 的状态下，执行了 returnCoin, 那么糖果机又进入到 readyState
    mCandyMachine.setState(mCandyMachine.mOnReadyState);
  }

  // 转动手柄
  override def turnCrank(): Unit = {
    println("crank turn...!");
    val ranWinner = new java.util.Random()
    // 设置一个抽奖随机数, 如果返回一个0, 就再奖励一块糖
    var winner = ranWinner.nextInt(10)
    if (winner == 0) {
      mCandyMachine.setState(mCandyMachine.mWinnerState)

    } else {
      mCandyMachine.setState(mCandyMachine.mSoldState)
    }
  }
  // 没有逻辑
  override def dispense(): Unit = {

  }
}
