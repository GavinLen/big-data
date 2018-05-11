package xyz.ieden.es.hl;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import xyz.ieden.es.hl.utils.ClientUtils;

import java.io.IOException;

/**
 * @author ThinkPad
 * @date Created by 2018/5/11 17:34
 */
public class HighLeveIndexOperate {

    private static RestHighLevelClient client = null;
    private static final String SHARD_KEY = "index.number_of_shards";
    private static final Integer SHARD_VALUE_DEFAULT = 5;
    private static final String REPLICA_KEY = "index.number_of_replicas";
    private static final Integer REPLICA_VALUE_DEFAULT = 1;
    https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high-open-index.html
    @BeforeClass
    public static void getClient() {
        client = ClientUtils.getHighLevelClient();
    }

    @AfterClass
    public static void closeClient() {
        ClientUtils.closeClient(client);
    }

    @Test
    public void testDeleteIndexByAsync() {
        DeleteIndexRequest indexRequest = new DeleteIndexRequest("my_twitter_async");
//        indexRequest.alias(new Alias("twitter_alias"));
        indexRequest.timeout(TimeValue.timeValueMillis(2000));

        client.indices().deleteAsync(indexRequest, new ActionListener<DeleteIndexResponse>() {
            @Override
            public void onResponse(DeleteIndexResponse deleteIndexResponse) {
                System.out.println("异步删除成功。");
            }

            @Override
            public void onFailure(Exception e) {
                System.out.println("异步删除失败。");
            }
        });
        System.out.println("删除执行完成。");
    }

    /**
     * 异步创建 Index
     */
    @Test
    public void testCreateIndexByAsync() {
        CreateIndexRequest indexRequest = new CreateIndexRequest("my_twitter_async");
//        indexRequest.alias(new Alias("twitter_alias"));
        indexRequest.timeout(TimeValue.timeValueMillis(2000));

        client.indices().createAsync(indexRequest, new ActionListener<CreateIndexResponse>() {
            @Override
            public void onResponse(CreateIndexResponse createIndexResponse) {
                System.out.println("异步添加成功。");
            }

            @Override
            public void onFailure(Exception e) {
                System.out.println("异步添加失败。");
            }
        });
        System.out.println("添加执行完成。");

    }

    /**
     * 同步删除 Index
     */
    @Test
    public void testDeleteIndexBySync() {
        DeleteIndexRequest indexRequest = new DeleteIndexRequest("my_twitter");
        indexRequest.timeout(TimeValue.timeValueMillis(2000));
        // Setting IndicesOptions controls how unavailable indices are resolved and how wildcard expressions are expanded
        indexRequest.indicesOptions(IndicesOptions.lenientExpandOpen());
        try {
            DeleteIndexResponse response = client.indices().delete(indexRequest);
            boolean acknowledged = response.isAcknowledged();
            System.out.println(acknowledged);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 同步创建 Index
     */
    @Test
    public void testCreateIndexBySync() {
        CreateIndexRequest indexRequest = new CreateIndexRequest("my_twitter");
//        indexRequest.alias(new Alias("twitter_alias"));
        indexRequest.timeout(TimeValue.timeValueMillis(2000));
        Settings.Builder builder = Settings.builder();
        builder.put(SHARD_KEY, SHARD_VALUE_DEFAULT);
        builder.put(REPLICA_KEY, REPLICA_VALUE_DEFAULT);
        indexRequest.settings(builder);
        try {
            CreateIndexResponse createIndexResponse = client.indices().create(indexRequest);
            // 所有的节点都确认
            boolean acknowledged = createIndexResponse.isAcknowledged();
            // 在超时之前为索引中的每个分片启动了必要的分片副本数
            boolean shardsAcknowledged = createIndexResponse.isShardsAcknowledged();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
