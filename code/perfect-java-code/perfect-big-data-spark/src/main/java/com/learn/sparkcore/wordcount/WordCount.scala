package com.learn.sparkcore.wordcount

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Kelly
 * @create 2021-04-18 13:51
 */
object WordCount {
  def main(args: Array[String]): Unit = {
    // 应用程序
    // spark 框架
    // TODO 建立和 spark 框架的连接
    // JDBC: Connection
    // spark 基本配置
    val sparkConf = new SparkConf().setMaster("local").setAppName("wordcount")

    val sc = new SparkContext(sparkConf)

    // TODO 执行业务操作
    // 1.读取文件，获取一行一行数据
    val lines = sc.textFile("perfect-big-data-spark/src/main/resources/files")

    // 2.切分一行数据，分词  “hello world” --> "hello" "world"
    // 扁平化操作
    val words = lines.flatMap(_.split(" "))

    // 3.根据单词进行分组，便于统计
    val wordGroup = words.groupBy(word => word)

    // 4.对分组后的数据进行转换
    val wordToCount = wordGroup.map{
      case (word, list) => {
        (word, list.size)
      }
    }

    // 5.将采集结果打印到控制台
    val array = wordToCount.collect()
    array.foreach(println)

    // TODO 关闭连接
    sc.stop()
  }
}
