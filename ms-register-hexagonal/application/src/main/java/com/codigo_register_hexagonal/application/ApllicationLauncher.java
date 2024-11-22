package com.codigo_register_hexagonal.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.codigo_register_hexagonal.*")
@EntityScan("com.codigo_register_hexagonal.*")
@EnableFeignClients("com.codigo_register_hexagonal.*")
@ImportAutoConfiguration({FeignAutoConfiguration.class})
@EnableJpaRepositories("com.codigo_register_hexagonal.*")
public class ApllicationLauncher {
    public static void main(String[] args){
        SpringApplication.run(ApllicationLauncher.class,args);
    }
}
