package com.example.securitybasedrestapi.service;

import com.example.securitybasedrestapi.entity.Users;
import com.example.securitybasedrestapi.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users=usersRepository.findByUsername(username);
        if(users==null){
            throw new UsernameNotFoundException("User doesn't exist : "+username);
        }else
            return new User(users.getUsername(),users.getPassword(),new ArrayList<>());
    }
}
