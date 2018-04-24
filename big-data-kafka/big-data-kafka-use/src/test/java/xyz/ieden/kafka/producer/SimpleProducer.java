package xyz.ieden.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

/**
 * @author ThinkPad
 * @date Created by 2018/4/24 16:30
 */
public class SimpleProducer {

    @Test
    public void testHelloWord() {
        long events = 5;
        Random rnd = new Random();

        String bootstrapServers = "192.168.80.136:9092";

        Producer<String, String> producer = createProducer(bootstrapServers);

        producer.commitTransaction();

        for (long index = 0; index < events; index++) {
            long runtime = new Date().getTime();
            String ip = "192.168.10." + rnd.nextInt(255);
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


    public Producer<String, String> createProducer(String bootstrapServers) {
        Properties props = new Properties();
        // 设置 broker 地址
        props.put("bootstrap.servers", bootstrapServers);
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
        // props.put("partitioner.class", "cn.ljh.kafka.kafka_helloworld.SimplePartitioner2");

        // 创建消费者
        Producer<String, String> producer = new KafkaProducer<>(props);

        return producer;

    }

}
