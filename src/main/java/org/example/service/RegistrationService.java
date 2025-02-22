package org.example.service;

import org.example.model.User;
import org.example.model.UserCredentials;
import org.example.repository.UserCredentialsRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final UserRepository userRepository;
    private final UserCredentialsRepository userCredentialsRepository;

    @Autowired
    public RegistrationService(UserRepository userRepository, UserCredentialsRepository userCredentialsRepository) {
        this.userRepository = userRepository;
        this.userCredentialsRepository = userCredentialsRepository;
    }

    public void registerUser(User user, UserCredentials userCredentials) {
        User savedUser = userRepository.save(user);
        userCredentials.setUsername(String.valueOf(savedUser));
        userCredentialsRepository.save(userCredentials);
    }
}