package com.example.securitybasedrestapi.controller;

import com.example.securitybasedrestapi.dto.request.JwtRequest;
import com.example.securitybasedrestapi.dto.request.JwtResponse;
import com.example.securitybasedrestapi.service.CustomUserDetailsService;
import com.example.securitybasedrestapi.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
public class JwtController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/token")
    public ResponseEntity generateToken(@RequestBody JwtRequest jwtRequest)throws Exception {
        String token=null;
        System.out.println("Jwt Controller called");
        authenticat(jwtRequest.getUsername(),jwtRequest.getPswd());
       UserDetails userDetails = customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
       //userDetails.getAuthorities();
        token=jwtUtil.generateToken(userDetails);
        System.out.println("generate token ----------------  :"+token);
        return  ResponseEntity.ok(new JwtResponse(token));
    }

    public void authenticat(String username,String password)throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }
        catch (DisabledException ex){
            throw new Exception("USER_DISABLE",ex);
        }
        catch (BadCredentialsException ex){
            throw new Exception("INVALID_CREDENTIALS",ex);
        }
    }
}
