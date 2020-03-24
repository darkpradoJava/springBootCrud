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

    @PutMapping("/add")
    ResponseEntity<Void> addUser(User user, String role) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.add(user, role);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    ResponseEntity<Void> deleteUser(@RequestParam(value = "id") Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            userService.delete(user);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping(value = "/edit")
    ResponseEntity<Void> editUser(User user, String role, Long id) {
        user.setId(id);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.update(user, role);
        return ResponseEntity.ok().build();
    }

}
