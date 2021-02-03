package edu.hubu.consumerstudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author moonlan
 * date 2021/2/3 下午2:02
 */
@SuppressWarnings(value = "unused")
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ConsumerStudent9001Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerStudent9001Application.class, args);
    }

}
