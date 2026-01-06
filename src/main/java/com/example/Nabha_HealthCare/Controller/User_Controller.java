package com.example.Nabha_HealthCare.Controller;


import com.example.Nabha_HealthCare.DTO.AuthResponse;
import com.example.Nabha_HealthCare.DTO.LoginRequest;
import com.example.Nabha_HealthCare.DTO.LoginResponseDTO;
import com.example.Nabha_HealthCare.Entity.User;
import com.example.Nabha_HealthCare.DTO.UserResponse;
import com.example.Nabha_HealthCare.Service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class User_Controller {

    @Autowired
    private User_Service userService;

    @PostMapping("/register")
    public UserResponse register(@RequestBody User userInput) {
        return userService.register(userInput);
    }

    //done
    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequest loginRequest) {return userService.login(loginRequest);}

    @GetMapping("/me")
    public AuthResponse me(@RequestParam Long userId) {

        UserResponse user = userService.getById(userId);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        // 🟢 Role ke hisaab se permissions fetch
        List<String> permissions = userService.permissionsForRole(user.getRole());

        return new AuthResponse(user, permissions, "User info retrieved");
    }

    @GetMapping("/all")
    public List<UserResponse> allUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/patient/{id}")
    public UserResponse getPatientById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PutMapping("/update/{id}")
    public UserResponse update(@PathVariable Long id, @RequestBody User u) {
        return userService.updateUser(id, u);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User Deleted Successfully!");
    }
}
