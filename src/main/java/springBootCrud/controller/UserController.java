package springBootCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springBootCrud.dao.UserDao;
import springBootCrud.model.Role;
import springBootCrud.model.User;

import java.util.Set;

@Controller
public class UserController {

    private UserDao userDao;

    @Autowired
    public void setUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "/admin")
    public String printUsers(ModelMap model) {
//        model.addAttribute("users", userDao.getUsers());
        return "admin";
    }

    @GetMapping(value = "/admin/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        userDao.deleteById(id);
        return modelAndView;
    }

    @GetMapping(value = "/admin/add")
    public ModelAndView addPage(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        return modelAndView;
    }

    @PostMapping(value = "/admin/add")
    public ModelAndView addUser(@ModelAttribute("user") User user, String role) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
//        userDao.add(user, role);
        return modelAndView;
    }

//    @GetMapping(value = "/admin/edit/{id}")
//    public ModelAndView editUserPage(@PathVariable("id") Long id) {
//        ModelAndView modelAndView = new ModelAndView();
//        User tempUser = userDao.getUserById(id);
//        modelAndView.addObject("user", tempUser);
//        modelAndView.setViewName("/edit");
//        modelAndView.addObject("id", id);
//        return modelAndView;
//    }

//    @PostMapping(value = "/admin/edit")
//    public ModelAndView editUser(@RequestParam(value = "id") Long id, @ModelAttribute("user") User user, String role) {
//        ModelAndView modelAndView = new ModelAndView();
//        Set<Role> set = user.getRoles();
//        user.setId(id);
//        modelAndView.setViewName("redirect:/admin");
//        userDao.update(user, role);
//        return modelAndView;
//    }

}
