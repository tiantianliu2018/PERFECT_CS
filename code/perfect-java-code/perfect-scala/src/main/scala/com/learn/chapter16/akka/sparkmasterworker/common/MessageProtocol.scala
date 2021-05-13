package com.learn.chapter16.akka.sparkmasterworker.common

// worker 注册信息
case class RegisterWorkerInfo(id: String, cpu: Int, ram: Int)

class WorkerInfo(val id: String, val cpu: Int, val ram: Int) {
  var lastHeartBeat: Long = System.currentTimeMillis()
}

// 当 worker 注册成功，服务器返回一个 RegisteredWorkerInfo 对象
case object RegisteredWorkerInfo

// worker 每隔一定时间由定时器发给自己的一个消息
case object SendHeartBeat

case class HeartBeat(id: String)

// master 给自己发送一个触发检查超时 worker 的信息
case object StartTimeOutWorker

// master 给自己发消息，检测 worker,对于心跳超时的.
case object RemoveTimeOutWorker
