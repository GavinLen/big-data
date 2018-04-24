package xyz.ieden.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;

import java.util.Properties;

/**
 * @author ThinkPad
 * @date Created by 2018/4/24 17:28
 */
public class ProducerByAsync {

    /**
     * 同步
     * @param bootstrapServers
     * @return
     */
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
