package com.learn.chapter16.akka.yellowchicken.common

/**
 * @author Kelly
 * @create 2021-05-13 10:43
 */
// 使用样例类来构建协议

// 客户端发给服务器协议(序列化的对象)
case class ClientMessage(message: String)

// 服务端发给客户端的协议(样例类对象)
case class ServerMessage(message: String)
