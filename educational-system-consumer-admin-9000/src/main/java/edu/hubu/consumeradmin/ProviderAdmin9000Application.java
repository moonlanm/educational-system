package edu.hubu.consumeradmin;

import edu.hubu.commons.annotations.EnableCommons;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @author moonlan
 * date 2021/1/25 下午4:03
 */
@SuppressWarnings(value = "unused")
@SpringBootApplication(scanBasePackages = "edu.hubu")
//@EnableCommons
public class ProviderAdmin9000Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderAdmin9000Application.class, args);
    }

}
