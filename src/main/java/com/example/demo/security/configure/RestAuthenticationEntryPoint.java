package com.example.demo.security.configure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//xác định cách xử lý các yêu cầu không được xác thực.
//sử dụng để bắt ngoại lệ này và xác định cách xử lý nó.
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

//    Logger là một thành phần trong các thư viện logging của Java,
//    được sử dụng để ghi lại các thông tin
//    về hành vi hoạt động của ứng dụng vào một bản ghi
    private static final Logger logger = LoggerFactory.getLogger(RestAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException e)
            throws IOException {
        logger.error("Unauthorized error. Message - {}", e.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error -> Unauthorized");
    }
}
