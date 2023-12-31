package com.example.imtahan6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.UserDetailsAwareConfigurer;

@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class Imtahan6Application {

    public static void main(String[] args) {
        SpringApplication.run(Imtahan6Application.class, args);
    }

}
