package edu.hubu.consumerteacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author moonlan
 * date 2021/2/1 下午4:54
 */
@SuppressWarnings(value = "unused")
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerTeacher9002Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerTeacher9002Application.class, args);
    }

}
