package com.petcare.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class UserServiceApplication {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(UserServiceApplication.class, args);

        /*while (true) {
            String userName = applicationContext.getEnvironment().getProperty("user.name");
            String userAge  = applicationContext.getEnvironment().getProperty("user.age");
            String config = applicationContext.getEnvironment().getProperty("user.config");
            System.out.println("userName: " + userName + ", userAge: " + userAge + ", config: " + config);
            TimeUnit.SECONDS.sleep(1);
        }*/
    }
}
