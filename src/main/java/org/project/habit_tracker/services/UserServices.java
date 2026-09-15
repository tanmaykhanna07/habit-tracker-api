package org.project.habit_tracker.services;

import org.project.habit_tracker.dtos.UserRequestDTO;
import org.project.habit_tracker.dtos.UserResponseDTO;
import org.project.habit_tracker.models.Users;
import org.project.habit_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JWTService jwtService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public UserResponseDTO register(UserRequestDTO requestDTO){
        Users user = new Users();
        user.setUsername(requestDTO.getUsername());
        user.setPassword(encoder.encode(requestDTO.getPassword()));
        Users savedUser = userRepository.save(user);

        return convertToDTO(savedUser);
    }

    public String verify(UserRequestDTO requestDTO){
        Authentication authentication = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(requestDTO.getUsername(), requestDTO.getPassword()));
        if(authentication.isAuthenticated()) return jwtService.generateToken(requestDTO.getUsername());
        return "Failed";
    }

    private UserResponseDTO convertToDTO(Users newUser){
        return new UserResponseDTO(
                newUser.getId(),
                newUser.getUsername()
        );
    }
}
