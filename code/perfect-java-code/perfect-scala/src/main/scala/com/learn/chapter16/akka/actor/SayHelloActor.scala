package com.learn.chapter16.akka.actor

import akka.actor.Actor

/**
 * @author Kelly
 * @create 2021-05-13 09:53
 */
class SayHelloActor extends Actor {
  override def receive: Receive = {

    case "hello" => println("收到 hello，回应 hello ~~ ")
    case "ok" => println("收到 ok，回应 ok， too ~~ ")
    case "exit" => {
      println("接收到 exit 指令，退出系统")

      // 停止 actoref
      context.stop(self)

      // 退出 actorsystem
      context.system.terminate()
    }
    case _ => println("匹配不到")
  }
}
