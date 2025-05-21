package com.korit.springboot.config;

import com.korit.springboot.controller.BeanStudy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudyConfig {

    @Bean
    public BeanStudy bean1(){
        System.out.println("bean 생성");
        return new BeanStudy();
    }

//    @Bean
//    public Criteria criteria(){
//        return new
//    }
// 외부 라이브러리를 등록해서 쓸때 @Bean 쓰기, 그리고 여러개 객체 생성 가능(component는 한개밖에 안돼)
}
