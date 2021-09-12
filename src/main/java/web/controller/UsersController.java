package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String readUsers(Model model) {
        model.addAttribute("userList", userService.getUserList());
        return "users";
    }

    @GetMapping("/new")
    public String newUserPageForm(User user) {
        return "new";
    }

    @PostMapping("/new")
    public String createUserAction(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }


    @GetMapping("/edit/{id}")
    public String updateUserForm(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.showUser(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String updateUser(User user) {
        userService.update(user.getUserId(), user);
        return "redirect:/users";
    }
}
