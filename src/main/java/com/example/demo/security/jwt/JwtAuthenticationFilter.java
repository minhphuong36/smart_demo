package com.example.demo.security.jwt;



import com.example.demo.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

//    Xác thực và lấy thông tin từ Jwt
    @Autowired
    private JwtService jwtService;

//    lấy thông tin người dùng
    @Autowired
    private IUserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String jwt = getJwtFromRequest(request);
            if (jwt != null && jwtService.validateJwtToken(jwt)) {
                String username = jwtService.getUserNameFromJwtToken(jwt);

//              Tạo đối tượng chứa thông tin người dùng với tên đăng nhập được chỉ định.
                UserDetails userDetails = userService.loadUserByUsername(username);

//              Xác thực thông tin đăng nhập
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            logger.error("Can NOT set user authentication -> Message: {}", e);
        }

        filterChain.doFilter(request, response);
    }


//    Lấy Jwt từ request
    private String getJwtFromRequest(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.replace("Bearer ", "");
        }

        return null;
    }
}
