package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController{
    
    @GetMapping("hello") //hello라는 요청이 들어오면 이 함수를 실행시킴
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value="name")String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }
}