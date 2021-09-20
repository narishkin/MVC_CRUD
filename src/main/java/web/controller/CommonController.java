package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
@GetMapping("/hello")
    public String getHello(){
        return "hello";
    }

    @GetMapping("/user")
    public String getUserHomePage(){
        return "user";
    }

    @GetMapping("/admin")
    public String getAdminHomePage(){
        return "admin";
    }


}
