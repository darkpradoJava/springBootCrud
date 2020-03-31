package springBootCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import springBootCrud.model.User;
import springBootCrud.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersRestController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userService.getUsers();
    }

    @PostMapping("/add")
    ResponseEntity<Void> addUser(User user, @RequestParam String role) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.add(user, role);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    ResponseEntity<Void> deleteUser(@RequestParam Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            userService.delete(user);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/edit")
    ResponseEntity<Void> editUser(User user, @RequestParam("role") String role, @RequestParam("id") Long id) {
        user.setId(id);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.update(user, role);
        return ResponseEntity.ok().build();
    }

}
