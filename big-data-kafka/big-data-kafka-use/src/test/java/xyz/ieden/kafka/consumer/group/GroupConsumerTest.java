package xyz.ieden.kafka.consumer.group;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * Created by Gavin on 2018.04.23.
 */
public class GroupConsumerTest {

//    @Test
//    public void ConsumerRecords() {
//        String bootstrapServers = "192.168.80.136:9092";
//        String groupId = "Consumer";
//        List<String> topicList = Arrays.asList("page_visits");
//        Consumer<String, String> consumer = createConsumerByAutoCommit(bootstrapServers, groupId);
//        consumer.subscribe(topicList);
//        while (true)
//
//        {
//            ConsumerRecords<String, String> records = consumer.poll(100);
//            for (ConsumerRecord<String, String> record : records)
//                System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
//        }
//    }



}
