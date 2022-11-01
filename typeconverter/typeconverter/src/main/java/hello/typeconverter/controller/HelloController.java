package hello.typeconverter.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController{
    
    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request){
        String data = request.getParameter("data");// 문자 타입 조회
        Integer intValue = Integer.valueOf(data);// 숫자 타입으로 변경
        System.out.println("intValue = " + intValue);
        return "ok";
    }

    // Spring 이 제공하는 RequestParam 을 사용하여 중간에서 타입 변환
    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data){
        System.out.println("data = " + data);
        return "ok";
    }

}