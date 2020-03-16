package springBootCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springBootCrud.model.User;
import springBootCrud.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/admin")
    public String printUsers(ModelMap model) {
        model.addAttribute("users", userService.getUsers());
        return "admin";
    }

    @GetMapping(value = "/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, ModelMap model) {
        User user = userService.getUserById(id);
        if (user != null) {
            userService.delete(user);
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/admin/add")
    public String addUser(@ModelAttribute("user") User user, String role) {
        userService.add(user, role);
        return "redirect:/admin";
    }

//    @GetMapping(value = "/admin/edit/{id}")
//    public String editUserPage(@PathVariable("id") Long id, ModelMap model) {
//        User tempUser = userService.getUserById(id);
//        model.addAttribute("user", tempUser);
//        model.addAttribute("id", id);
//        return "edit";
//    }

    @PostMapping(value = "/admin/edit")
    public String editUser(@RequestParam(value = "id") Long id, @ModelAttribute("user") User user, String role) {
        System.out.println(id);
        user.setId(id);
        userService.update(user, role);
        return "redirect:/admin";
    }

}
