package edu.hubu.provideradmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author moonlan
 * date 2021/2/1 下午3:54
 */
@SuppressWarnings(value = "unused")
@SpringBootApplication(scanBasePackages = "edu.hubu")
@EnableDiscoveryClient
public class ProviderAdmin8003Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderAdmin8003Application.class, args);
    }

}
