package xyz.ieden.consumer.group;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by Gavin on 2018.04.23.
 */
public class GroupConsumerTest {

    public void ConsumerRecords() {
        String bootstrapServers = "192.168.80.136:9092";
        String groupId = "page_visits";
        Consumer<String, String> consumer = createConsumerByAutoCommit(bootstrapServers, groupId);
        consumer.subscribe(Arrays.asList("foo", "bar"));
        while (true)

        {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
        }
    }

    /**
     * 创建自动提交的 Consumer
     *
     * @param zookeeperService
     * @param groupId
     * @return
     */
    public Consumer<String, String> createConsumerByUnAutoCommit(String zookeeperService, String groupId) {
        Consumer<String, String> consumer = createConsumer(zookeeperService, groupId, false);
        return consumer;
    }

    /**
     * 创建自动提交的 Consumer
     *
     * @param zookeeperService
     * @param groupId
     * @return
     */
    public Consumer<String, String> createConsumerByAutoCommit(String zookeeperService, String groupId) {
        Consumer<String, String> consumer = createConsumer(zookeeperService, groupId, true);
        return consumer;
    }

    /**
     * 创建 Consumer
     *
     * @param zookeeperService
     * @param groupId
     * @param autoCommit
     * @return
     */
    public Consumer<String, String> createConsumer(String zookeeperService, String groupId, Boolean autoCommit) {
        Properties props = new Properties();
        // zookeeper 地址
        props.put("bootstrap.servers", zookeeperService);
        // 消费组 ID
        props.put("group.id", groupId);
        // 如果value合法，则自动提交偏移量
        props.put("enable.auto.commit", autoCommit);
        // 更新被消费消息的偏移量间隔
        props.put("auto.commit.interval.ms", "1000");
        // 设置会话响应的时间，超过这个时间kafka可以选择放弃消费或者消费下一条消息
        props.put("session.timeout.ms", "30000");
        // key 序列化
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        // value 序列化
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        Consumer<String, String> consumer = new KafkaConsumer<>(props);
        return consumer;
    }

}
