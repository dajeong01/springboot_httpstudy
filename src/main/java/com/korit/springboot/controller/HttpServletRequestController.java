package com.korit.springboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
    HttpServletRequest 객체란?
    외부에서 tomcat 웹 서버로 요청시 생성되는 요청정보객체이다.

 */
@RestController
public class HttpServletRequestController {

//    @GetMapping("/api/name2")
//    public String getName2(HttpServletRequest request) {
//        System.out.println(request.getParameter("address"));
//        return "제다정";
//    } // 예전 방식

    @GetMapping("/api/name2")
    public String getName2(@RequestParam(required = false) String a,
                           @RequestParam(required = false) int b){
        System.out.println(a);
        System.out.println(b+10);
        return "제다정";
    }   // 요즘 방식

//    @GetMapping("/api/count")
//    public String getCount(@RequestParam(required = false) int a){
//        System.out.println(a);
//        int count = 0;
//        if(a > 0){
//            count += a;
//            System.out.println(count);
//        } else {
//            System.out.println("count가 음수입니다.");
//        }
//        return "카운트페이지";
//    } // 이거 안됨 일회용임 백엔드


//    @GetMapping("/api/name2")
//    public String getName2(@RequestParam(required = false, value = "address") String a){
//        System.out.println(a);
//        return "제다정";
//    }   // 요즘 방식

}
