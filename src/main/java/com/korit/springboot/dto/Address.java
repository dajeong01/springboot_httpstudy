package com.korit.springboot.dto;

import lombok.Data;

import java.util.List;

//@ToString   // 3번 PostData(name=제다정, age=25, address=Address(address1=null, address2=null, address3=null, address4=null))
//@Setter     // 4번 PostData(name=제다정, age=25, address=Address(address1=부산광역시, address2=사하구, address3=다대동, address4=[다대대우아파트, 103동]))
//@Getter     // 6번 컨트롤러3으로 출력 보내기위해
@Data   // 3 + 4 + 6 합친거
public class Address {
    private String address1;
    private String address2;
    private String address3;
    private List<String> address4;
}

