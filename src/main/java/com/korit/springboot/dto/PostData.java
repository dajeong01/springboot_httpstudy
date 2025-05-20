package com.korit.springboot.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

//@ToString   // 1번 나타내기 PostData(name=null, age=null, address=null)
//@Setter     // 2번 PostData(name=제다정, age=25, address=com.korit.springboot.dto.Address@24fd547d)
//@Getter     // 5번 컨트롤러3으로 출력을 보내기위해
@Data           // 1 + 2 + 5 합친거
public class PostData {
    private String name;
    private Integer age;
    private Address address;
}


