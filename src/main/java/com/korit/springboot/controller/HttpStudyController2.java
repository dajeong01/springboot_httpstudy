package com.korit.springboot.controller;

// 요청 URL : /api/age, 응답 데이터 : {name: 김준일, age: 32}

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")

public class HttpStudyController2 {

    @GetMapping("/age")
    public Map<String, Object> getAge() {
//        return Map.of("name", "제다정","age",32);    // 이렇게만 한 줄만으로도 결과가 나옴
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "제다정");        // 값을 더하거나 바꿀수있을경우
        map1.put("age", 32);
//        map1.put("addrerss","다대동");     // 이런식으로 값 추가 가능
        Map<String, Object> map2 = Map.of("name", "제다정", "age", 32);  // 이렇게도 쓸수는 있 으나 데이터를 못 바꿈
//        map2.put("addrerss","다대동");             // 이거 안됨 => 상황에 맞게 쓰기
        return map1;
    }

    @GetMapping("/names")
    public List<String> getNames() {
//        return List.of("김준일","김준이","김준삼");        // 가능은 하나 값을 추가하거나 바꿀때는 안됨
        List<String> getNames = new ArrayList<>();
        getNames.add("김준일");
        getNames.add("김준이");
        getNames.add("김준삼");
        return getNames;
    }
//    @GetMapping("/names")                             // 이건 List 말고 배열을 쓸 경우
//    public String [] names(){
//        String[] names = {"김준일","김준이","김준삼"};
//        return names;
//    }

    @GetMapping("/students")
    public List<Map<String, Object>> getNameAndAge() {
//        return List.of(
//                Map.of("name", "김준일", "age", 32),
//                Map.of("name", "김준이", "age", 33)
//        );    // 이건 역시 값 수정 불가
        List<Map<String, Object>> getNameAndAgeList = new ArrayList<>();
        getNameAndAgeList.add(Map.of("name", "김준일", "age", 32));
        getNameAndAgeList.add(Map.of("name", "김준이", "age", 33));      // 이건 내가한 방법
//        Map<String, Object> map1 = new HashMap<>();
//        map1.put("name", "김준일");
//        map1.put("age", 32);    // 이런식도 가능
        // 여러가지 방법
        return getNameAndAgeList;
    }

    @GetMapping("/students2")
    public List<Map> getNameAndAgeAndHobby2() {
        List<Map> getNameAndAgeList2 = new ArrayList<>();
        getNameAndAgeList2.add(Map.of("name", "김준일", "age", 32, "hobby", new String[]{"축구", "농구"}));
        getNameAndAgeList2.add(Map.of("name", "김준이", "age", 33, "hobby", new String[]{"골프", "낚시"}));
        return getNameAndAgeList2;
    }
}
