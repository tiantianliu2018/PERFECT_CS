package com.learn.partitioner;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @author Kelly
 * @create 2021-04-08 14:48
 */
public class ProvincePartitioner extends Partitioner<Text, FlowBean> {

    public int getPartition(Text text, FlowBean flowBean, int numPartitions) {
        String phone = text.toString();
        String prePhone = phone.substring(0, 3);

        int partition = 0;

        if ("136".equals(prePhone)) {
            partition = 0;
        } else if ("137".equals(prePhone)) {
            partition = 1;
        } else if ("138".equals(prePhone)) {
            partition = 2;
        } else if ("139".equals(prePhone)) {
            partition = 3;
        } else {
            partition = 4;
        }
        // 返回分区号
        return partition;
    }
}
