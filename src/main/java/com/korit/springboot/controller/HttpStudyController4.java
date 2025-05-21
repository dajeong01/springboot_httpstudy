package com.korit.springboot.controller;

/*
    * REST API : 웹상의 자원을 이름으로 구분하고 해당 자원의 상태를 주고 받는 모든 것
    * RESTful API : REST를 기반으로 만들어진 API => REST 원리를 잘 따르는 시스템을 RESTful하다~ 라고 표현됨
    * REST API 주의할점
    url은 명사 ( /users (o) /getUsers(x), 소문자 쓰기, _(밑줄) 쓰지않기
    요청과 응답
    * https://hahahoho5915.tistory.com/54#google_vignette
    * https://m.blog.naver.com/codingbarbie/223233477242
 */

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;

public class HttpStudyController4 {

    @GetMapping("/api/study/http/get")
    public ResponseEntity<Map<String,Object>> get(){
//        return new ResponseEntity<>(Map.of("name","김준일","age",32), HttpStatus.BAD_REQUEST);
        return ResponseEntity.badRequest().body(Map.of("name","김준일","age",32));
        // static method(ex.ResponseEntity.~ 점뒤에 나오는 메서드) 쓰는 두가지방법
    }
}
