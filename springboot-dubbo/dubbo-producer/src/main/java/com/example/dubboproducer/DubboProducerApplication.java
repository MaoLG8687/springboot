package com.example.dubboproducer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo  //启动dubbo的配置
public class DubboProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboProducerApplication.class, args);
	}

}

