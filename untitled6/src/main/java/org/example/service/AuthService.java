package org.example.service;

import org.example.model.UserCredentials;
import org.example.repository.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AuthService {
    private final UserCredentialsRepository userCredentialsRepository;
    @Autowired
    public AuthService(UserCredentialsRepository userCredentialsRepository) {
        this.userCredentialsRepository = userCredentialsRepository;
    }
    public boolean authenticate(String email, String password) {
        UserCredentials userCredentials = userCredentialsRepository.findByUsername(email);
        return userCredentials != null && userCredentials.getPassword().equals(password);
    }
}