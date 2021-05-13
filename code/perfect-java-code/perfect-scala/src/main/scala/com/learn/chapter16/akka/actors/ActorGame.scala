package com.learn.chapter16.akka.actors

import akka.actor.{ActorRef, ActorSystem, Props}

/**
 * @author Kelly
 * @create 2021-05-13 10:29
 */
object ActorGame extends App {
  // 创建 ActorSystem
  private val actorFactory: ActorSystem = ActorSystem("actorFactory")

  // 创建 BActor 的引用
  private val bActorRef: ActorRef = actorFactory.actorOf(Props[BActor], "bActor")

  //创建 AActor 的引用
  private val aActorRef: ActorRef = actorFactory.actorOf(Props(new AActor(bActorRef)), "aActor")

  aActorRef ! "start"
}
