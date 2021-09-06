package com.example.securitybasedrestapi.dto.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class JwtRequest {
    @NotNull(message = "fdsdfs")
    private String username;
    @Min(value = 1)
    private String pswd;
    }
