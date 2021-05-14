package com.learn.chapter17.observer.localinternetobserver

/**
 * @author Kelly
 * @create 2021-05-14 10:28
 */
// 气象局的天气公告板
class CurrentConditions {
  private var mTemperature: Float = _
  private var mPressure: Float = _
  private var mHumidity: Float = _

  def display(): Unit = {
    println("*** 气象局的天气公告板 Today mTemperature: " + mTemperature + " ***")
    println("*** 气象局的天气公告板 Today mPressure: " + mPressure + " ***")
    println("*** 气象局的天气公告板 Today mHumidity: " + mHumidity + " ***")
  }

  def update(mTemperature: Float, mPressure: Float, mHumidity: Float): Unit = {
    // 更新天气公告板
    this.mTemperature = mTemperature
    this.mPressure = mPressure
    this.mHumidity = mHumidity

    // 显示
    display()
  }
}
