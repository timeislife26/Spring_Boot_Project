package com.example.myproject.controllers.rest;
import com.example.myproject.entities.MyUser;
import com.example.myproject.repository.UserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceRepository userServiceRepository;

    @PostMapping
    public ResponseEntity<MyUser> createUser(@RequestBody MyUser user) {
        return ResponseEntity.ok(userServiceRepository.createUser(user));
    }

    @PutMapping("/{username}/password")
    public ResponseEntity<MyUser> editUserPassword(@PathVariable String username, @RequestParam String newPassword) {
        return ResponseEntity.ok(userServiceRepository.editUserPassword(username, newPassword));
    }

    @PutMapping("/{username}/unlock")
    public ResponseEntity<MyUser> toggleUserUnlock(@PathVariable String username) {
        return ResponseEntity.ok(userServiceRepository.toggleUserUnlock(username));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        userServiceRepository.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

}
