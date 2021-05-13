package com.learn.chapter16.akka.yellowchicken.server

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.learn.chapter16.akka.yellowchicken.common.{ClientMessage, ServerMessage}
import com.typesafe.config.ConfigFactory

/**
 * @author Kelly
 * @create 2021-05-13 10:38
 */
class YellowChickenServer extends Actor {
  override def receive: Receive = {
    case "start" => println("start 小黄鸡客服开始工作了....")
    case ClientMessage(message) => {
      message match {
        case "大数据学费" => sender() ! ServerMessage("35000RMB")
        case "学校地址" => sender() ! ServerMessage("上海市嘉定区曹安公路 999 号")
        case "学习什么技术？" => sender() ! ServerMessage("scala")
        case _ => sender() ! ServerMessage("你说的啥子~")
      }
    }
  }
}

object YellowChickenServer extends App {
  // 服务端ip地址
  val host = "127.0.0.1"
  val port = 9999

  // 创建config对象,指定协议类型，监听的ip和端口
  val config = ConfigFactory.parseString(
    s"""
       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=$host
       |akka.remote.netty.tcp.port=$port
        """.stripMargin)

  // 创建ActorSystem
  // url (统一资源定位)
  val serverActorSystem = ActorSystem("Server",config)
  val yellowChickenServerRef: ActorRef = serverActorSystem.actorOf(Props[YellowChickenServer], "YellowChickenServer")

  // 启动
  yellowChickenServerRef ! "start"
}