package xyz.ieden.kafka.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Gavin
 * @date 2018.04.15
 */
public class User implements Serializable {

    @JSONField(name = "id")
    private Integer userId;
    private String userName;
    @JSONField(serialize = false)
    private String password;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public User() {
    }

    public User(Integer userId, String userName, String password, Date createTime) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
