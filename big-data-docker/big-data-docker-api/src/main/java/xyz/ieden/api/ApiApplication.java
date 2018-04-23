package xyz.ieden.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ThinkPad
 * @date Created by 2018/4/18 13:34
 */
@SpringBootApplication
@ComponentScan(basePackages = {"xyz.ieden"})
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}
