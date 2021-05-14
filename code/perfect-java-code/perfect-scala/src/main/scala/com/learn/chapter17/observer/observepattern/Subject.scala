package com.learn.chapter17.observer.observepattern

/**
 * @author Kelly
 * @create 2021-05-14 10:49
 */
trait Subject {
  // 注册
  def registerObserver(o: ObServer)

  // 移除
  def removeObserver(o: ObServer)

  // 通知所有的注册的用户
  def notifyObservers()
}
