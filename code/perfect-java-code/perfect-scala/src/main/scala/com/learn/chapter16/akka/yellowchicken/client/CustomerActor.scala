package com.learn.chapter16.akka.yellowchicken.client

import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}
import com.learn.chapter16.akka.yellowchicken.common.{ClientMessage, ServerMessage}
import com.typesafe.config.ConfigFactory

import scala.io.StdIn

/**
 * @author Kelly
 * @create 2021-05-13 10:52
 */
class CustomerActor(serverHost: String, serverPort: Int) extends Actor {
  // 定义一个 YellowChickenServerRef
  var serverActorRef: ActorSelection = _

  // 进行初始化工作的方法
  override def preStart(): Unit = {
    println("preStart 执行")
    serverActorRef = context.actorSelection(s"akka.tcp://Server@${serverHost}:${serverPort}/user/YellowChickenServer")
    println("serverActorRef = " + serverActorRef)
  }

  override def receive: Receive = {
    case "start" => println("start,客户端运行，可以咨询问题")
    case mes: String => {
      serverActorRef !ClientMessage(mes)
    }
    // 如果接收到服务器的回复
    case ServerMessage(mes) => {
      println(s"收到小黄鸡客服(Server): $mes")
    }
  }
}

object CustomerActor extends App {
  val (clientHost, clientPort, serverHost, serverPort) = ("127.0.0.1", 9990, "127.0.0.1", 9999)
  val config = ConfigFactory.parseString(
    s""" |akka.actor.provider="akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname=$clientHost
         |akka.remote.netty.tcp.port=$clientPort
         """.stripMargin)

  // 创建 ActorSystem
  val clientActorSystem: ActorSystem = ActorSystem("client", config)
  val customerActorRef: ActorRef = clientActorSystem.actorOf(Props(new CustomerActor(serverHost, serverPort)), "customerActor")

  customerActorRef ! "start"

  while (true) {
    println("请输入要咨询的问题")
    val mes = StdIn.readLine()
    customerActorRef ! mes
  }
}