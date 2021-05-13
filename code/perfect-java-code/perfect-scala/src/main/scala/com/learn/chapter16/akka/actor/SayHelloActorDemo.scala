package com.learn.chapter16.akka.actor

import akka.actor.{ActorSystem, Props}

/**
 * @author Kelly
 * @create 2021-05-13 10:08
 */
object SayHelloActorDemo {
  // 创建 actor 的 ActorSystem
  private val actorFactory = ActorSystem("actorFactory")

  // 创建一个 Actor 的同时，返回 Actor 的 ActorRef
  private val sayHelloActorRef = actorFactory.actorOf(Props[SayHelloActor], "sayHelloActor")

  def main(args: Array[String]): Unit = {
    sayHelloActorRef ! "Hello"
    sayHelloActorRef !"hello"
    sayHelloActorRef ! "ok"
    sayHelloActorRef ! "ok~"

    sayHelloActorRef ! "exit"

  }

}
