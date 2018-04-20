package xyz.ieden.base;

import org.apache.kafka.clients.producer.*;
import org.junit.Test;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

/**
 * @author ThinkPad
 * @date Created by 2018/4/20 16:40
 */
public class ProducerTest {

    @Test
    public void testHelloWord() {
        long events = 5;
        Random rnd = new Random();

        Properties props = new Properties();
        // 设置 broker 地址
        props.put("bootstrap.servers", "192.168.80.136:9092");
        // 请求时需要确认
        props.put("acks", "all");
        // 请i去失败需要重试
        props.put("retries", 0);
        // 批处理个数
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        // 内存缓冲区
        props.put("buffer.memory", 33554432);
        // key 序列化方式
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // value 序列化方式
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //配置partitionner选择策略，可选配置
//        props.put("partitioner.class", "cn.ljh.kafka.kafka_helloworld.SimplePartitioner2");

        // 创建消费者
        Producer<String, String> producer = new KafkaProducer<>(props);

        for (long nEvents = 0; nEvents < events; nEvents++) {
            long runtime = new Date().getTime();
            String ip = "192.168.2." + rnd.nextInt(255);
            String msg = runtime + ",www.example.com," + ip;
            ProducerRecord<String, String> data = new ProducerRecord<>("page_visits", ip, msg);
            producer.send(data, (metadata, e) -> {
                if (e != null) {
                    e.printStackTrace();
                } else {
                    System.out.println("The offset of the record we just sent is: " + metadata.offset());
                }
            });
        }
        producer.close();
    }

}