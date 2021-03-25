package com.xkcoding.helloworld;

import cn.hutool.core.util.StrUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * SpringBoot启动类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-09-28 14:49
 */
@SpringBootApplication
@RestController
public class SpringBootDemoHelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoHelloworldApplication.class, args);
    }

    /**
     * Hello，World
     *
     * @param firstName 参数，非必须
     * @param lastName 参数，非必须
     * @return Hello, ${firstName lastName}
     */
    @GetMapping("/hello")
    public String sayHello(@RequestParam(required = false, name = "firstName") String firstName, @RequestParam(required = false,  name = "lastName") String lastName) {
        if (firstName == null) {
            firstName = "";
        }
        if (lastName == null) {
            lastName = "";
        }
        String name = firstName + " " + lastName;
        if (StrUtil.isBlank(firstName) && StrUtil.isBlank(lastName)) {
            name = "Spring boot";
        }
        return StrUtil.format("Hello, {}!", name);
    }
}
