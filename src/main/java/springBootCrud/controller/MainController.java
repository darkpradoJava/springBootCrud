package springBootCrud.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @GetMapping("/")
    public String getLoginPage(Authentication authentication, ModelMap model) {
        if (authentication != null) {
            model.addAttribute("user", authentication.getName());
            return "user";
        }
        return "login";
    }

    @GetMapping("/login")
    public String getLoginPage(Authentication authentication, ModelMap model, HttpServletRequest request) {
        if (authentication != null) {
            return "user";
        }
        if (request.getParameterMap().containsKey("error")) {
            model.addAttribute("error", true);
        }
        return "login";
    }

    @GetMapping("/user")
    public String getUserPage(Authentication authentication, ModelMap model) {
        model.addAttribute("user", authentication.getName());
        return "user";
    }

    @GetMapping("/error")
    public String getErrorPage() {
        return "error";
    }

}
