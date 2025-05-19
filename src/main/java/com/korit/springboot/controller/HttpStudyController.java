package com.korit.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController             // 이걸 달아놓으면 @ResponseBody 생략가능 => controller + responsebody 합쳐놓은거
//@Controller
@RequestMapping("/api")
// 공통사항들은 위에 세팅한다
public class HttpStudyController {

    @GetMapping("/http")
//    @ResponseBody       // 데이터만 응답하겠다 라는 의미 (responsebody가 없으면 view로 응답)
    public String get(){return "";}

    @GetMapping("/name")
//    @ResponseBody
    public String getName(){return "제다정";}

}
