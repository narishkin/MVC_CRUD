package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("userList", userService.getAll());
        return "users";
    }

    @GetMapping("/new")
    public String createForm(User user) {
        return "new";
    }

    @PostMapping("/new")
    public String create(User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }


    @GetMapping("/edit/{id}")
    public String updateForm(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String update(User user) {
        userService.update(user.getId(), user);
        return "redirect:/users";
    }
}
