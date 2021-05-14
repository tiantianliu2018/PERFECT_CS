package com.learn.chapter17.observer.observepattern

import scala.collection.mutable.ListBuffer

/**
 * @author Kelly
 * @create 2021-05-14 10:56
 */
class WeatherDataSt extends Subject {

  private var mTemperature: Float = _
  private var mPressure: Float = _
  private var mHumidity: Float = _

  // 集合，用于管理所有的观察者
  private val mObservers: ListBuffer[ObServer] = ListBuffer()

  def getTemperature() = {
    mTemperature
  }

  def getPressure() = {
    mPressure
  }

  def getHumidity() = {
    mHumidity
  }

  def dataChange(): Unit = {
    // 一旦天气变化，就通知所有观察者
    notifyObservers()
  }

  def setData(mTemperature: Float, mPressure: Float, mHumidity: Float): Unit = {
    this.mTemperature = mTemperature
    this.mPressure = mPressure
    this.mHumidity = mHumidity

    dataChange()
  }

  override def registerObserver(o: ObServer): Unit = mObservers.append(o)

  override def removeObserver(o: ObServer): Unit = {
    if (mObservers.contains(o)) {
      mObservers -= o
    }
  }

  // 通知，天气情况变化了，我们就通知所有的观察者
  override def notifyObservers(): Unit = {
    for (observer <- mObservers) {
      observer.update(mTemperature, mPressure, mHumidity)
    }
  }
}
