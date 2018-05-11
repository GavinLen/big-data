package xyz.ieden.es.hl;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.common.settings.Settings;

/**
 * @author ThinkPad
 * @date Created by 2018/5/11 15:28
 */
public class IndexUtils {

    private static final String SHARD_KEY = "index.number_of_shards";
    private static final Integer SHARD_VALUE_DEFAULT = 5;
    private static final String REPLICA_KEY = "index.number_of_replicas";
    private static final Integer REPLICA_VALUE_DEFAULT = 1;

    /**
     * Index 映射
     *
     * @param indexRequest
     * @param indexName
     * @param indexValue
     * @return
     */
    public static CreateIndexRequest indexMapper(CreateIndexRequest indexRequest, String indexName, String indexValue) {
        return null;
    }

    /**
     * 获取 indexRequest
     *
     * @return
     */
    public static CreateIndexRequest getIndexRequest() {
        CreateIndexRequest indexRequest = getIndexRequest(SHARD_VALUE_DEFAULT, REPLICA_VALUE_DEFAULT);
        return indexRequest;
    }

    /**
     * 获取 indexRequest
     *
     * @return
     */
    public static CreateIndexRequest getIndexRequest(Integer shardValue, Integer replicaValue) {
        CreateIndexRequest indexRequest = new CreateIndexRequest();
        Settings.Builder builder = Settings.builder();
        builder.put(SHARD_KEY, shardValue);
        builder.put(REPLICA_KEY, replicaValue);
        indexRequest.settings(builder);
        return indexRequest;
    }

}
