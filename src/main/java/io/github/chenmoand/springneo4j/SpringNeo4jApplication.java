package io.github.chenmoand.springneo4j;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@SpringBootApplication
public class SpringNeo4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringNeo4jApplication.class, args);
        log.info("项目成功启动,祝您使用愉快! [api调试地址-> http://127.0.0.1:8080/swagger-ui.html]");
        log.info("@author: chenmoand");
    }

}
