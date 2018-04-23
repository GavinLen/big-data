package xyz.ieden.base;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.Test;

import java.util.Collections;
import java.util.Properties;

/**
 * @author ThinkPad
 * @date Created by 2018/4/20 17:16
 */
public class ConsumerTest {

    @Test
    public void testHelloWord() {
        Properties props = new Properties();

        props.put("bootstrap.servers", "192.168.80.136:9092");
        //每个消费者分配独立的组号
        props.put("group.id", "page_visits");

        //如果value合法，则自动提交偏移量
        props.put("enable.auto.commit", "true");

        //设置多久一次更新被消费消息的偏移量
        props.put("auto.commit.interval.ms", "1000");

        //设置会话响应的时间，超过这个时间kafka可以选择放弃消费或者消费下一条消息
        props.put("session.timeout.ms", "30000");

        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        consumer.subscribe(Collections.singletonList("page_visits"));

        System.out.println("Subscribed to topic " + "page_visits");

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {

                // print the offset,key and value for the consumer records.
                System.out.printf("offset = %d, key = %s, value = %s\n", record.offset(), record.key(), record.value());
            }
        }
    }

}
