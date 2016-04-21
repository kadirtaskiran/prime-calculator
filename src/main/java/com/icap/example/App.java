package com.icap.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.io.IOException;

@ComponentScan({"com.icap.example"})
@EnableAutoConfiguration
public class App
{
    public static void main( String[] args ){
        SpringApplication.run(App.class, args);
    }

    @PostConstruct
    public void initApplication() throws IOException {
    }
}
