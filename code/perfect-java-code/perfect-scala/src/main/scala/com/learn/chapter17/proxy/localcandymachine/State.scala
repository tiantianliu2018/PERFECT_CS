package com.learn.chapter17.proxy.localcandymachine

/**
 * @author Kelly
 * @create 2021-05-14 11:20
 */
trait State extends Serializable {
  def insertCoin() // 插入硬币
  def returnCoin() // 返回硬币
  def turnCrank()  // 转动曲柄
  def printState() // 输出状态
  def getStateName(): String // 返回状态名字
  def dispense()   //分配状态的，比如:卖出一块糖，后，就看看当前糖果机应该进入哪个状态.

}
