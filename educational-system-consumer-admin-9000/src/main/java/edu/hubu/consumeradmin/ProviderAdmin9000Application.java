package edu.hubu.consumeradmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @author moonlan
 * date 2021/1/25 下午4:03
 */
@SuppressWarnings(value = "unused")
@SpringBootApplication
@ComponentScans(value = {
        @ComponentScan(value = "edu.hubu.commons.config"),
        @ComponentScan(value = "edu.hubu.commons.controller")
})
public class ProviderAdmin9000Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderAdmin9000Application.class, args);
    }

}
