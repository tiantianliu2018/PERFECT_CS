package com.learn.chapter10.queue

import scala.collection.mutable

/**
 * @author Kelly
 * @create 2021-05-06 10:54
 */
object QueueDemo {
  def main(args: Array[String]): Unit = {
    var queue = new mutable.Queue[Int]
    println(queue)

    queue += 9
    println("queue = " + queue)

    queue ++= List(4, 5, 6)
    println("queue = " + queue)

    val val1 = queue.dequeue()
    println("queueElement = " + val1 + ", queue = " + queue)

    queue.enqueue(100, 10, 100, 88)
    println("queue = " + queue)

    println("============ Queue-返回队列的元素 =================")
    println("head = " + queue.head)  // 获取队列的第一个元素
    println("last = " + queue.last)  // 获取队列的最后一个元素

    // 取出队尾的数据，即：返回除了第一个以外剩余的元素，可以级联使用
    println("tail = " + queue.tail)
    println(queue.tail.tail)
    println(queue.tail.tail.tail)

    println("queue = " + queue)

  }

}
