package com.learn.sparkcore.wordcount

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Kelly
 * @create 2021-04-18 14:21
 */
object WordCount3 {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local").setAppName("word-count")
    val sc = new SparkContext(sparkConf)

    val lines = sc.textFile("perfect-big-data-spark/src/main/resources/files")
    val words = lines.flatMap(_.split(" "))
    val wordToOne = words.map(
      word => (word, 1)
    )
    // spark 框架提供了更多的功能，可以将分组聚合使用一个方法实现
    // reduceByKey: 相同的 key 的数据，可以对 value 进行 reduce 聚合
//    wordToOne.reduceByKey((x, y) => {x + y})
//    wordToOne.reduceByKey((x, y) => x + y)
    val wordToCount = wordToOne.reduceByKey(_ + _)
    val array = wordToCount.collect()
    array.foreach(println)

    sc.stop()
  }


}
