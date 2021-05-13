package com.learn.chapter16.akka.sparkmasterworker.master

import akka.actor.{Actor, ActorSystem, Props}
import com.learn.chapter16.akka.sparkmasterworker.common.{HeartBeat, RegisterWorkerInfo, RegisteredWorkerInfo, RemoveTimeOutWorker, StartTimeOutWorker, WorkerInfo}
import com.typesafe.config.ConfigFactory

import scala.collection.mutable
import scala.concurrent.duration.DurationInt

/**
 * @author Kelly
 * @create 2021-05-13 11:32
 */
class SparkMaster extends Actor {

  // 定义一个 hashmap，用来管理 workers
  var workers = mutable.Map[String, WorkerInfo]()

  override def receive: Receive = {
    case "start" => {
      println("master 服务器启动了...")
      self ! StartTimeOutWorker
    }
    case RegisterWorkerInfo(id, cpu, ram) => {
      // 接收到 worker 注册信息
      if (!workers.contains(id)) {
        val workerInfo = new WorkerInfo(id, cpu, ram)
        workers += ((id, workerInfo))
        println("服务器的 workers = " + workers)

        // 回复一个注册成功的消息
        sender() ! RegisteredWorkerInfo
      }
    }
    case HeartBeat(id) => {
      // 更新对应的 worker 的心跳时间
      val workerInfo = workers(id)
      workerInfo.lastHeartBeat = System.currentTimeMillis()
      println("master 更新了 " + id + " 心跳时间...")
    }
    case StartTimeOutWorker => {
      println("开始了定时检测 worker 心跳的任务")
      import context.dispatcher
      context.system.scheduler.schedule(0 millis, 9000 millis, self, RemoveTimeOutWorker)
    }
    case RemoveTimeOutWorker => {
      val workInfos = workers.values
      val currentTime = System.currentTimeMillis()
      workInfos.filter(workInfo => (currentTime - workInfo.lastHeartBeat) > 6000)
        .foreach(workInfo => workers.remove(workInfo.id))

      println("当前有 " + workers.size + " 个 worker 存活的")
    }
  }

}

object SparkMaster {
  def main(args: Array[String]): Unit = {

    // 有 3 个 host,port,sparkMasterActor
    if (args.length != 3) {
      println("请输入参数 host port sparkMasterActor名字")
      sys.exit()
    }

    val host = args(0)
    val port = args(1)
    val name = args(2)

    //先创建ActorSystem
    val config = ConfigFactory.parseString(
      s"""
         |akka.actor.provider="akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname=${host}
         |akka.remote.netty.tcp.port=${port}
            """.stripMargin)

    val sparkMasterSystem = ActorSystem("SparkMaster", config)
    // 创建SparkMaster -actor
    val sparkMasterRef = sparkMasterSystem.actorOf(Props[SparkMaster], s"${name}")
    // 启动SparkMaster
    sparkMasterRef ! "start"
  }
}
