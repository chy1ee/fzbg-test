package com.chylee.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Oauth2Application {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2Application.class);
    }
}
