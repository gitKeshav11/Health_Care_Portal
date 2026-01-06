package com.example.Nabha_HealthCare.Service;

import com.example.Nabha_HealthCare.DTO.LoginRequest;
import com.example.Nabha_HealthCare.DTO.LoginResponseDTO;
import com.example.Nabha_HealthCare.DTO.UserResponse;
import com.example.Nabha_HealthCare.Entity.User;
import com.example.Nabha_HealthCare.Repositories.User_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class User_Service {

    @Autowired
    private User_Repo userRepository;

    public UserResponse register(User userInput) {
        if (userRepository.existsByEmail(userInput.getEmail())) {
            throw new RuntimeException("User already registered!");
        }
        String role = userInput.getRole();
        if (role == null || role.trim().isEmpty()) role = "patient";

        userInput.setRole(role.toLowerCase());
        User saved = userRepository.save(userInput);
        userInput.setCreatedAt(LocalDateTime.now());
        return mapToResponse(saved);
    }

    public LoginResponseDTO login(LoginRequest loginRequest) {
        Optional<User> opt = userRepository.findByEmail(loginRequest.getEmail());
        if (opt.isEmpty()) {
            throw new RuntimeException("Invalid credentials");
        }
        User user = opt.get();
        // simple plaintext compare (replace with hashed compare in real app)
        if (!Objects.equals(user.getPassword(), loginRequest.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return mapToLoginResponse(user);
    }

    public List<UserResponse> getAllUsers() {
        List<User> list = userRepository.findAll();
        List<UserResponse> out = new ArrayList<>();
        for (User u : list) out.add(mapToResponse(u));
        return out;
    }

    public UserResponse getById(Long id) {
        return userRepository.findById(id).map(this::mapToResponse).orElse(null);
    }

    public UserResponse updateUser(Long id, User newData) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        if (newData.getName() != null) user.setName(newData.getName());
        if (newData.getPhone() != null) user.setPhone(newData.getPhone());
        if (newData.getGender() != null) user.setGender(newData.getGender());
        if (newData.getPassword() != null) user.setPassword(newData.getPassword());
        if (newData.getRole() != null) user.setRole(newData.getRole().toLowerCase());
        // email should not be changed easily; if you allow, check uniqueness.
        User saved = userRepository.save(user);
        return mapToResponse(saved);
    }

    public void deleteUser(Long id) {
         userRepository.deleteById(id);
    }

    /* ------------------ Helper methods ------------------ */

    public List<String> permissionsForRole(String role) {
        if (role == null) role = "patient";
        role = role.toLowerCase();
        List<String> perms = new ArrayList<>();
        // Base permissions: anyone logged in (patient/user)
        perms.add("VIEW_HOSPITALS");
        perms.add("VIEW_DOCTORS");
        perms.add("VIEW_MEDICINES");
        perms.add("BOOK_APPOINTMENT");
        perms.add("VIEW_OWN_APPOINTMENTS");
        perms.add("VIEW_PRESCRIPTIONS");

        if ("doctor".equals(role)) {
            // doctors get base + doctor-specific
            perms.add("VIEW_ASSIGNED_PATIENTS");
            perms.add("ADD_PRESCRIPTION");
            perms.add("EDIT_PRESCRIPTION");
            perms.add("VIEW_OWN_APPOINTMENTS");
            perms.add("UPDATE_PATIENT_NOTES");
        } else if ("admin".equals(role)) {
            // admin: add everything
            perms.add("MANAGE_HOSPITALS");
            perms.add("MANAGE_DOCTORS");
            perms.add("MANAGE_PATIENTS");
            perms.add("MANAGE_MEDICINES");
            perms.add("MANAGE_PAYMENTS");
            perms.add("VIEW_ALL_APPOINTMENTS");
            perms.add("VIEW_REPORTS");
        }
        return perms;
    }

    public UserResponse mapToResponse(User user) {
        return new UserResponse(user.getUserId(), user.getName(), user.getPhone(),user.getGender(),user.getEmail(), user.getRole(), user.getCreatedAt());
    }
    public LoginResponseDTO mapToLoginResponse(User user) {
        return new LoginResponseDTO(
                user.getUserId(),
                user.getName(),
                user.getPhone(),
                user.getGender(),
                user.getEmail(),
                user.getRole(),
                user.getCreatedAt()
        );
    }

}
