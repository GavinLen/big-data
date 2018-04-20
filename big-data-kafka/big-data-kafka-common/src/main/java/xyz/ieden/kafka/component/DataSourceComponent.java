package xyz.ieden.kafka.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ThinkPad
 * @date Created by 2018/4/17 17:58
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceComponent {

    private String type;
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    // Setter and Getter Method


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
