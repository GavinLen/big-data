package xyz.ieden.kafka.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.ieden.kafka.component.DataSourceComponent;

import javax.sql.DataSource;

/**
 * @author ThinkPad
 * @date Created by 2018/4/18 13:30
 * <p>
 * 数据源配置
 */
@Configuration
public class DataSourceConfig {


    @Autowired
    private DataSourceComponent dataSourceComponent;

    /**
     * ali Druid 数据源
     *
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(dataSourceComponent.getDriverClassName());
        druidDataSource.setUrl(dataSourceComponent.getUrl());
        druidDataSource.setUsername(dataSourceComponent.getUsername());
        druidDataSource.setPassword(dataSourceComponent.getPassword());
        return druidDataSource;
    }
}
