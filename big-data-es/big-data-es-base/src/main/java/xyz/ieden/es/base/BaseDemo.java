package xyz.ieden.es.base;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;

import java.io.IOException;

/**
 * @author ThinkPad
 * @date Created by 2018/5/4 10:18
 */
public class BaseDemo {

    public static void main(String[] args) {
        RestClient restClient = createRestClient();
        try {
            Response response = restClient.performRequest("GET", "/");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 结束 RestClient
     *
     * @param restClient
     */
    public static void closeRestClient(RestClient restClient) {
        if (restClient != null) {
            try {
                restClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建 es 的 RestClient
     *
     * @return
     */
    public static RestClient createRestClient() {
        RestClientBuilder restClientBuilder = RestClient.builder(new HttpHost("192.168.80.136", 9200, "http"));
        // 设置最大重试超时毫秒
        restClientBuilder.setMaxRetryTimeoutMillis(1000);
        // 设置默认的标题
        Header[] defaultHeaders = {new BasicHeader("header", "value")};
        restClientBuilder.setDefaultHeaders(defaultHeaders);
        // 设置节点失败时的监听
//        restClientBuilder.setFailureListener(new RestClient.FailureListener() {
//            @Override
//            public void onFailure(HttpHost host) {
//                super.onFailure(host);
//            }
//        });
        // 设置请求配置的回调(请求超时、身份验证等)
//        restClientBuilder.setRequestConfigCallback((RequestConfig.Builder builder) -> {
//            return builder.setSocketTimeout(10000);
//        });
        // 设置HTTP客户端的回调(ssl 通信)
//        restClientBuilder.setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
//            @Override
//            public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpAsyncClientBuilder) {
//                return httpAsyncClientBuilder.setProxy(new HttpHost("proxy", 9000, "HTTP"));
//            }
//        });

        RestClient restClient = restClientBuilder.build();
        return restClient;

    }

}
