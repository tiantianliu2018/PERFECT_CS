package com.learn.reducejoin;

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
    @Override
    protected void reduce(Text key, Iterable<TableBean> values, Context context) throws IOException, InterruptedException {
        // 创建集合
        ArrayList<TableBean> orderBeans = new ArrayList<TableBean>();
        TableBean pdBean = new TableBean();

        // 循环遍历
        for (TableBean value : values) {
            if ("order".equals(value.getFlag())) {  // 处理订单表
                // 创建一个临时表
                TableBean tempTableBean = new TableBean();

                // 复制对象
                try {
                    BeanUtils.copyProperties(tempTableBean, value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                orderBeans.add(tempTableBean);
            } else { // 处理商品表
                try {
                    BeanUtils.copyProperties(pdBean, value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            }
        }

        // 循环遍历 orderBeans，赋值 pname
        for (TableBean orderBean : orderBeans) {
            orderBean.setPname(pdBean.getPname());
            context.write(orderBean, NullWritable.get());
        }
    }
}
