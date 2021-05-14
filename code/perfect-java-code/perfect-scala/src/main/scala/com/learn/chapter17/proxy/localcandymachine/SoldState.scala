package com.learn.chapter17.proxy.localcandymachine

/**
 * @author Kelly
 * @create 2021-05-14 11:33
 */
//处于销售的状态[正在出糖果...]
class SoldState extends State {
  // @transient注解将字段标记为瞬态的, 即表示一个域不是该对象串行化的一部分
  @transient private var mCandyMachine: CandyMachine = _

  def this(mCandyMachine: CandyMachine) {
    this
    this.mCandyMachine = mCandyMachine
  }

  override def getStateName(): String = {
    "Sold State"
  }

  // 根据当前状态, insertCoin 有不同的业务逻辑
  // 其它的方法同样存在这样的处理
  override def insertCoin(): Unit = {
    println("please wait! we are giving you a candy!")
  }

  override def printState(): Unit = {
    println("****** Sold State ******")
  }

  override def returnCoin(): Unit = {
    println("you haven't inserted a coin yet!")
  }

  override def turnCrank(): Unit = {
    println("we are giving you a candy, turning another get nothing!")
  }

  override def dispense(): Unit = {
    // TODO Auto-generated method stub

    mCandyMachine.releaseCandy() // 数量减去
    if (mCandyMachine.getCount() > 0) { // 如果还有糖，则进入 readystate
      mCandyMachine.setState(mCandyMachine.mOnReadyState);
    } else {
      // 没有糖，则进入sole out state
      println("Oo, out of candies");
      mCandyMachine.setState(mCandyMachine.mSoldOutState);
    }
  }
}

