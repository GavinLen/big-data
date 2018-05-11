package xyz.ieden.es.hl;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Objects;

/**
 * @author ThinkPad
 * @date Created by 2018/5/11 15:50
 */
public class HighLevelRestClientTest {

    private static RestHighLevelClient client = null;

    /**
     * 获取 RestHighLevelClient
     *
     * @return
     */
    @BeforeClass
    public static void getHighLevelClient() {
        HttpHost[] httpHosts = {new HttpHost("192.168.80.136", 9200, "http")};
        RestClientBuilder restClientBuilder = RestClient.builder(httpHosts);
        // 设置最大重试超时毫秒
        restClientBuilder.setMaxRetryTimeoutMillis(1000);

        client = new RestHighLevelClient(restClientBuilder);
    }

    @AfterClass
    public static void closeClient() {
        if (Objects.nonNull(client)) {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testGetHighLevelClient() {
        RestHighLevelClient client = Objects.requireNonNull(this.client, "Client is Null");
    }
}
