package com.learn.chapter16.akka.actors

import akka.actor.Actor

/**
 * @author Kelly
 * @create 2021-05-13 10:26
 */
class BActor extends Actor{
  override def receive: Receive = {

    case "我打" => {
      println("BActor(乔峰) 挺猛 看我降龙十八掌")
      Thread.sleep(1000)
      // 通过 sender() 可以获取到发现消息的 actor 的 ref
      sender() ! "我打"
    }
  }
}
