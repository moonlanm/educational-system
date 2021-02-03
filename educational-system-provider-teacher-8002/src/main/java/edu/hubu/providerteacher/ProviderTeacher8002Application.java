package edu.hubu.providerteacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author moonlan
 * date 2021/1/25 下午7:02
 */
@SuppressWarnings(value = "unused")
@SpringBootApplication(scanBasePackages = "edu.hubu")
@EnableDiscoveryClient
public class ProviderTeacher8002Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderTeacher8002Application.class, args);
    }

}