package xyz.ieden.es.hl.utils;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.Closeable;
import java.io.IOException;
import java.util.Objects;

/**
 * @author ThinkPad
 * @date Created by 2018/5/11 17:35
 */
public class ClientUtils {

    /**
     * Close client
     *
     * @param client
     */
    public static void closeClient(Closeable client) {
        if (Objects.nonNull(client)) {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取 RestHighLevelClient
     *
     * @return
     */
    public static RestHighLevelClient getHighLevelClient() {
        HttpHost[] httpHosts = {new HttpHost("192.168.80.136", 9200, "http")};
        RestHighLevelClient client = getHighLevelClient(httpHosts);
        return client;

    }

    /**
     * 获取 RestHighLevelClient
     *
     * @return
     */
    public static RestHighLevelClient getHighLevelClient(HttpHost[] httpHosts) {
        RestClientBuilder restClientBuilder = RestClient.builder(httpHosts);
        // 设置最大重试超时毫秒
        restClientBuilder.setMaxRetryTimeoutMillis(1000);

        RestHighLevelClient client = new RestHighLevelClient(restClientBuilder);
        return client;

    }
}
