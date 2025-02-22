package org.example.service;

import org.example.model.Account;
import org.example.model.User;
import org.example.repository.AccountRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByEmail(String email) {
        return userRepository.findByUsername(email);
    }

    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            return getUserByEmail(username);
        } else {
            String username = principal.toString();
            return getUserByEmail(username);}
    }


    public User register(String name, String surname, String email, String password) {
        User user = new User( name, surname, email, password);//створився новий конструктор в User, чому і для чого?
        return userRepository.save(user);
    }

    public User login(String email, String password) throws InvalidCredentialsException {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        throw new InvalidCredentialsException();//за вимогою програми, чому?
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }


    @Service
    public class AccountService {
        private final AccountRepository accountRepository;

        public AccountService(AccountRepository accountRepository) {
            this.accountRepository = accountRepository;
        }

        public List<Account> getAccountsByUser(User user) {
            return accountRepository.findByUser(user);
        }

        public Account getAccountById(Long id) {
            return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        }

        public void saveAccount(Account account) {
            accountRepository.save(account);
        }
}}