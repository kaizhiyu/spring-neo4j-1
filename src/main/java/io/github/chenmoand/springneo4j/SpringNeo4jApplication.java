package io.github.chenmoand.springneo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class SpringNeo4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringNeo4jApplication.class, args);
    }

}
