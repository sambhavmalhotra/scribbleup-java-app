package com.scribbleup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * ScribbleUpJavaApp
 * Created by sambhavmalhotra on 08/05/18.
 */
@SpringBootApplication
@EnableSwagger2
public class ScribbleUpJavaApp {

    public static void main(final String[] args) {
        SpringApplication.run(ScribbleUpJavaApp.class, args);
    }

}