package com.korit.springboot.controller;

import com.korit.springboot.dto.Address;
import com.korit.springboot.dto.PostData;
import com.korit.springboot.dto.Student;
import com.korit.springboot.dto.param.SearchStudyDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class HttpStudyController3 {

    private final RestClient.Builder builder;

    public HttpStudyController3(RestClient.Builder builder) {
        this.builder = builder;
    }

    /*
            get : 주소에 값을 입력한다.
            파라미터를 통해 값을 입력한다.
            파라미터란? 주소의 '?' 뒤에 따라오는 key value값을 의미한다.
            http://localhost:8080/api/~~~~~~?(이 부분이 파라미터부분)
            파라미터부분에서 여러개의 데이터를 요청시 '&'로 구분
         */
    @GetMapping("/study/get")
    public String get(
            @RequestParam String name,
            @RequestParam Integer age
    ) {
        return "get 요청입니다.";
    }

    /*
        post : 가능한 json으로 값을 입력한다. (@requestbody가 거의 필수로 쓰인다고보면됨)
        "{
            "key1" : "value",
            "key2" : value2,
            "key3" : {
                key4 : value3,
                key5 : [ "a", "b", "c", "d" ]
            }
        }"
     */
    @PostMapping("/study/post")
    public String post(@RequestBody Map<String, Object> data) {
        System.out.println(data);
        System.out.println(data.get("age"));
        System.out.println(data.get("address"));
        System.out.println(((Map<String, Object>) data.get("address")).get("address4"));

//        Object data2 = data.get("address");
//        Map<String,Object> map = (Map<String, Object>) data2;
//        System.out.println(data2);
//
//        Object data3 = map.get("address4");
//        List<String> list = (List<String>) data3;
//        System.out.println(data3);
        return "post 요청입니다.";
        /*
            이상의 코드들은 post2 처럼 PostData, Address 클래스처럼 안 쓸 경우 전부 하나씩 다운캐스팅을 해줘야함 -> 번거러움
         */
    }

    @PostMapping("/study/post2")
    public String post2(@RequestBody PostData postData) {
        System.out.println(postData);
        System.out.println(postData.getAddress());
        Address address = postData.getAddress();
        System.out.println(address.getAddress4());
        return "post2 요청입니다.";
    }

    /*
        ex)
        Class Student {name, age}

        get 요청
        /api/study/students
        응답: [{Student객체1}, {Student객체2}, {Student객체3}]

        post 요청
        /api/study/students
        응답 : {status : "성공", data : {Student 객체}}
     */
//    @GetMapping("/study/students")
//    public List<Student> getStudents() {
//        return List.of(new Student("제다정",25), new Student("제다정정",26));
//    }
    @GetMapping("/study/students")
    public List<Student> getSearchStudents(SearchStudyDto searchStudyDto) {
//        List<Student> students = List.of(
//                new Student("제다정",25),
//                new Student("이민서",26),
//                new Student("장지민",27),
//                new Student("이유진",28),
//                new Student("송채연",32),
//                new Student("신지원",27),
//                new Student("윤여진",32)
//                );
        List<Student> students = new ArrayList<>();         // 이건 번외로 랜덤으로 배열 좀 크게 만들어보기
        Random random = new Random();
        int startCode = 0xAC00; // 가
        int endCode = 0xD7A3;   // 힇
        for (int i = 0; i < 3000; i++){
            StringBuilder builder = new StringBuilder();
            builder.append((char)(startCode + random.nextInt(endCode - startCode + 1)));
            builder.append((char)(startCode + random.nextInt(endCode - startCode + 1)));
            builder.append((char)(startCode + random.nextInt(endCode - startCode + 1)));
            students.add(new Student(builder.toString(),random.nextInt(40)+1));
        }

        if(searchStudyDto.getPage() < 1){
            searchStudyDto.setPage(1);
        }
        /*
            page = 1 -> 0
            page = 2 -> 10
            page = 3 -> 20
         */
        List<Student> foundStudents = students;
        if(searchStudyDto.getSearchValue() != null && !searchStudyDto.getSearchValue().isBlank()){
            foundStudents = students.stream().filter(s -> s.getName().contains(searchStudyDto.getSearchValue())).collect(Collectors.toList());
        }

        int startIndex = (searchStudyDto.getPage() - 1) * searchStudyDto.getCount();
        List<Student> newStudents = new ArrayList<>();
        if(foundStudents.size() < startIndex){
            startIndex = 0;
        }

        for(int i = 0; i < (foundStudents.size() < searchStudyDto.getCount()? foundStudents.size() : searchStudyDto.getCount()); i++){
            try {
            newStudents.add(foundStudents.get(startIndex + i));
            } catch (Exception e){
                break;
            }
        }
        return newStudents;
    }   // 이건 검색기능

    @PostMapping("/study/students")
    public Map<String, Object> postStudent(@RequestBody Student student){
        return Map.of("status","성공","data",student);
    }
//    @PostMapping("/study/students")
//    public Map<String, Object> postSearchStudent(@RequestBody Student student){
//        return Map.of("status","성공","data",student);
//    }

    /*
        put : json으로 값을 입력한다.
     */
    @PutMapping("/study/put")
    public String put() {
        return "put 요청입니다.";
    }

    /*
        delete : 경로에 명확하게 값을 입력한다. delete는 유독 조심해서 쓰기
        /api/study/delete/book/10
     */
    @DeleteMapping("/study/delete/{category}/{id}")
    public String delete(@PathVariable String category, @PathVariable Long id) {
        return "delete 요청입니다.";
    }
}