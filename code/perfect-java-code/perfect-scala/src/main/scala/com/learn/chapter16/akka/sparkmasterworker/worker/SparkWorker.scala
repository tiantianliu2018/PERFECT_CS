package com.learn.chapter16.akka.sparkmasterworker.worker

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.learn.chapter16.akka.sparkmasterworker.common.{HeartBeat, RegisterWorkerInfo, RegisteredWorkerInfo, SendHeartBeat}
import com.typesafe.config.ConfigFactory

import scala.concurrent.duration.DurationInt

/**
 * @author Kelly
 * @create 2021-05-13 11:46
 */
class SparkWorker(masterHost: String, masterPort: Int, masterName: String) extends Actor {
  var masterProxy: ActorSelection = _
  val id = java.util.UUID.randomUUID().toString

  override def preStart(): Unit ={
    println("preStart()调用")
    // 初始化masterProxy
    masterProxy = context.actorSelection(s"akka.tcp://SparkMaster@${masterHost}:${masterPort}/user/${masterName}")
    println("masterProxy = " + masterProxy)

  }
  override def receive: Receive = {
    case "start" => {
      println("worker启动了")
      //发出一个注册消息
      masterProxy ! RegisterWorkerInfo(id, 16, 16 * 1024)
    }
    case RegisteredWorkerInfo => {
      println("workerId = " + id + " 注册成功~")
      // 当注册成功后，就定义一个定时器,每隔一定时间，发送 SendHeartBeat 给自己
      import context.dispatcher
      context.system.scheduler.schedule(0 millis, 3000 millis, self, SendHeartBeat)
    }
    case SendHeartBeat => {
      println("worker = " + id + "给 master 发送心跳")
      masterProxy ! HeartBeat(id)
    }
  }
}

object SparkWorker {
  def main(args: Array[String]): Unit = {

    if (args.length != 6) {
      println("请输入参数 workerHost workerPort workerName masterHost masterPort masterName")
      sys.exit()
    }

    val workerHost = args(0)
    val workerPort = args(1)
    val workerName = args(2)
    val masterHost = args(3)
    val masterPort = args(4)
    val masterName = args(5)
    val config = ConfigFactory.parseString(
      s"""
         |akka.actor.provider="akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname=${workerHost}
         |akka.remote.netty.tcp.port=${workerPort}
            """.stripMargin)

    // 创建 ActorSystem
    val sparkWorkerSystem = ActorSystem("SparkWorker",config)

    // 创建 SparkWorker 的引用/代理
    val sparkWorkerRef = sparkWorkerSystem.actorOf(Props(new SparkWorker(masterHost, masterPort.toInt,masterName)), s"${workerName}")

    // 启动 actor
    sparkWorkerRef ! "start"
  }
}

