package com.learn.mapjoin;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * @author Kelly
 * @create 2021-04-12 15:52
 */
public class TableReducer extends Reducer<Text, TableBean, TableBean, NullWritable> {
}
