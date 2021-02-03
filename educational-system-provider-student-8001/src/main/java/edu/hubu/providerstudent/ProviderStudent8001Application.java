package edu.hubu.providerstudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author moonlan
 * date 2021/2/1 下午3:53
 */
@SuppressWarnings(value = "unused")
@SpringBootApplication(scanBasePackages = "edu.hubu")
@EnableDiscoveryClient
public class ProviderStudent8001Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderStudent8001Application.class, args);
    }

}
