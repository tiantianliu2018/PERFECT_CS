package com.learn.sparkcore.rdd.builder

import org.apache.spark.{SparkConf, SparkContext}
;

/**
 * @author Kelly
 * @create 2021-04-22 16:21
 */
object MemoryPartition {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("partition")
    val sc = new SparkContext(sparkConf)

    // 创建 RDD
    // 四个数据分两个区 numSlices, 第二个参数可以不传，使用默认的并行度
    val rdd = sc.makeRDD(
      List(1, 2, 3, 4, 5), 3
    )

    // 将处理的数据保存成分区文件
    rdd.saveAsTextFile("perfect-big-data-spark/src/main/resources/output")

    sc.stop()
  }
}
