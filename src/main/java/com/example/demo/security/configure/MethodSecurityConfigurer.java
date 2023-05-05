package com.example.demo.security.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
//cấu hình phương thức bảo mật trong ứng dụng
public class MethodSecurityConfigurer extends GlobalMethodSecurityConfiguration {
}
