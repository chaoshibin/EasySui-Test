package com.sui.test;

import com.easysui.distribute.lock.aspect.EasyLockAspect;
import com.easysui.log.aspect.EasyLogAspect;
import com.easysui.validate.aspect.EasyValidateAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Bean
    public EasyLogAspect easyLogAspect() {
        return new EasyLogAspect();
    }

    @Bean
    public EasyValidateAspect easyValidateAspect() {
        return new EasyValidateAspect();
    }

    @Bean
    public EasyLockAspect easyLockAspect() {
        return new EasyLockAspect();
    }
}
