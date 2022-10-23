package com.mounir.hrms.DTO.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenUserInfo {
    private String fullName;
    private String username;
    private String department;
    private String jobTitle;
    private String email;
}
