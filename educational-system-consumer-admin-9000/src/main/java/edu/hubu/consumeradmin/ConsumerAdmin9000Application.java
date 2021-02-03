package edu.hubu.consumeradmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author moonlan
 * date 2021/1/25 下午4:03
 */
@SuppressWarnings(value = "unused")
@SpringBootApplication(scanBasePackages = "edu.hubu")
@EnableFeignClients
@EnableDiscoveryClient
public class ConsumerAdmin9000Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerAdmin9000Application.class, args);
    }

}