package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.entity.User;
import web.service.UserService;


@Controller
@RequestMapping("/")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String showUsers(ModelMap model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/{id}")
    public String showUserById(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("users", userService.findById(id));
        return "singleuser";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("users") User user){
        return "new";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("users") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("user", userService.findById(id));
        return "updateuser";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute User user, @PathVariable("id") int id) {
        userService.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/";
    }

}

