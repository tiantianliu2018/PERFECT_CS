package com.learn.chapter17.proxy.localcandymachine

/**
 * @author Kelly
 * @create 2021-05-14 11:20
 */
class CandyMachine {

  var mSoldOutState: State = _
  var mOnReadyState: State = _
  var mHasCoin: State = _
  var mSoldState: State = _
  var mWinnerState: State = _
  private var location = ""
  private var state: State = _
  private var count = 0

  def this(location: String, count: Int) {
    this
    this.location = location
    this.count = count
    mSoldOutState = new SoldOutState(this)
    mOnReadyState = new OnReadyState(this)
    mSoldState = new SoldState(this)
    mHasCoin = new HasCoin(this)
    mWinnerState = new WinnerState(this)

    if (count > 0) {
      state = mOnReadyState
    } else {
      state = mSoldOutState
    }
  }

  // 给糖果机设置状态
  def setState(state: State): Unit = {
    this.state = state
  }

  def getState(): State = {
    this.state
  }

  def getLocation(): String = {
    this.location
  }

  def getCount(): Int = {
    this.count
  }

  def insertCoin(): Unit = {
    state.insertCoin()
  }

  def returnCoin(): Unit ={
    state.returnCoin()
  }

  def printState(): Unit = {
    state.printState()
  }

  def turnCrank(): Unit = {
    state.turnCrank()
    state.dispense()
  }

  def releaseCandy(): Unit = {
    if (count > 0) {
      count -= 1
      println("a candy rolling out!")
    }
  }





}
