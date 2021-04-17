package com.learn.partitionerandwritableComparable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @author Kelly
 * @create 2021-04-08 16:01
 */
public class ProvincePartitioner2 extends Partitioner<FlowBean, Text> {
    public int getPartition(FlowBean flowBean, Text text, int numPartitions) {
        String phone = text.toString();
        String prePhone = phone.substring(0, 3);

        //
        int partition;
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
        return partition;
    }
}
