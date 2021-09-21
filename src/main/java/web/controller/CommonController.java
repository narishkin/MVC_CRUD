package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

@Controller
public class CommonController {
    @GetMapping("/hello")
    public String getHello() {
        return "hello";
    }

    @GetMapping("/user")
    public String getUserHomePage(Principal principal, Model model) {
        if (principal != null) {
            String s = principal.getName();
            model.addAttribute("userinfo", s);
        }
        return "user";
    }

    @GetMapping("/admin")
    public String getAdminHomePage() {
        return "admin";
    }
}
