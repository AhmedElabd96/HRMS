package com.mounir.hrms.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="token")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Configuration
public class TokenConfig {
    private String secretKey;
}
