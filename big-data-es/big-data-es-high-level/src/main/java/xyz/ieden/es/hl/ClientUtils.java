package xyz.ieden.es.hl;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;

import java.io.IOException;
import java.util.Objects;

/**
 * @author ThinkPad
 * @date Created by 2018/5/11 15:10
 */
public class ClientUtils {

    /**
     * 结束 RestClient
     *
     * @param restClient
     */
    public static void closeClient(RestClient restClient) {
        if (Objects.nonNull(restClient)) {
            try {
                restClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建 RestClient
     *
     * @param httpHosts
     * @return
     */
    public static RestClient createClient(HttpHost[] httpHosts) {
        RestClientBuilder restClientBuilder = RestClient.builder(httpHosts);
        // 设置最大重试超时毫秒
        restClientBuilder.setMaxRetryTimeoutMillis(1000);
        RestClient restClient = restClientBuilder.build();

        return restClient;
    }

}
