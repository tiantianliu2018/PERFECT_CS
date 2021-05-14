package com.learn.chapter17.observer.observepattern

/**
 * @author Kelly
 * @create 2021-05-14 11:03
 */
class CurrentConditions extends ObServer {

  private var mTemperature: Float = _
  private var mPressure: Float = _
  private var mHumidity: Float = _

  def display() = {
    println("*** 气象局的天气公告板 Today mTemperature: " + mTemperature + " ***")
    println("*** 气象局的天气公告板 Today mPressure: " + mPressure + " ***")
    println("*** 气象局的天气公告板 Today mHumidity: " + mHumidity + " ***")
  }

  override def update(mTemperature: Float, mPressure: Float, mHumidity: Float): Unit = {
    this.mTemperature = mTemperature
    this.mPressure = mPressure
    this.mHumidity = mHumidity
    // 展示
    display()
  }


}
