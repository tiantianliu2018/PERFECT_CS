package com.learn.chapter17.observer.observepattern

/**
 * @author Kelly
 * @create 2021-05-14 11:06
 */
class SinaCurrentConditions extends ObServer {

  private var mTemperature: Float = _
  private var mPressure: Float = _
  private var mHumidity: Float = _

  def display() = {
    if (this.mTemperature > 40) {
      println("*** 新浪的天气公告板 Today mTemperature: " + mTemperature + " *** 赶紧离开地球")
    } else if (mTemperature > 16 && mTemperature < 28) {
      println("*** 新浪的天气公告板 Today mTemperature: " + mTemperature + " *** 赶紧回到地球")
    }

    println("*** 新浪的天气公告板 Today mPressure: " + mPressure + " ***")
    println("*** 新浪的天气公告板 Today mHumidity: " + mHumidity + " ***")
  }

  override def update(mTemperature: Float, mPressure: Float, mHumidity: Float): Unit = {
    this.mTemperature = mTemperature
    this.mPressure = mPressure
    this.mHumidity = mHumidity

    display()
  }
}
