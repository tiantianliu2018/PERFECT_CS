package com.learn.sparkcore.wordcount

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Kelly
 * @create 2021-04-18 14:11
 */
object WordCount2 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
      .setMaster("local")
      .setAppName("word-count")

    val sc = new SparkContext(sparkConf)

    val lines = sc.textFile("perfect-big-data-spark/src/main/resources/files")

    val words = lines.flatMap(_.split(" "))

    val wordToOne = words.map(
      word => (word, 1)
    )

    val wordGroup = wordToOne.groupBy(
      t => t._1
    )

    val wordToCount = wordGroup.map {
      case (word, list) => {
        list.reduce(
          (t1, t2) => {
            (t1._1, t1._2 + t2._2)
          }
        )
      }
    }

    val array = wordToCount.collect()

    array.foreach(println)

    sc.stop()
  }

}
