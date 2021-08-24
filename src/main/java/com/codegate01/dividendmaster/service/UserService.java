package com.codegate01.dividendmaster.service;

import com.codegate01.dividendmaster.errors.UserNotFoundException;
import com.codegate01.dividendmaster.model.User;
import com.codegate01.dividendmaster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(s).orElseThrow(() -> new RuntimeException("User not found: " + s));
       // GrantedAuthority authority = new SimpleGrantedAuthority(user.getRoles().name());
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRoles().toString());
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Arrays.asList(authority));
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findUserByUserId(id)
                .orElseThrow(() -> new UserNotFoundException("User id " + id + " was not found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteUserByUserId(id);
    }

    public void updateUserPassword(Long id, String psw){
        userRepository.updateUserPassword(id, psw);

    }

}
