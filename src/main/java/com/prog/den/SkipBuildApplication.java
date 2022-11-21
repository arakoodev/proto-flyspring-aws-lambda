package com.prog.den;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@RequiredArgsConstructor
@SpringBootApplication
public class SkipBuildApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SkipBuildApplication.class, args);
    }
}
