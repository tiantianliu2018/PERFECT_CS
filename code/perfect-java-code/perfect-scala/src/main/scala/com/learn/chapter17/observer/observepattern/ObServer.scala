package com.learn.chapter17.observer.observepattern

/**
 * @author Kelly
 * @create 2021-05-14 10:49
 */
trait ObServer {
  // 抽象方法，等待其它的观察者实现
  def update(mTemperature: Float, mPressure: Float, mHumidity: Float)
}
