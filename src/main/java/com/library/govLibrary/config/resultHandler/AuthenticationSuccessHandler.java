package com.library.govLibrary.config.resultHandler;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.library.govLibrary.model.Users;
import com.library.govLibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final long expirationTime;
    private final String secret;
    @Autowired
    private UserService userService;

    public AuthenticationSuccessHandler(@Value("${jwt.expirationTime}") long expirationTime, @Value("${jwt.secret}") String secret) {
        this.expirationTime = expirationTime;
        this.secret = secret;
    }


    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Users user = userService.getUser(userDetails.getUsername());
        Map<String, String> identity = new HashMap<>();
        identity.put("username", user.getUsername());
        identity.put("name", user.getName());
        identity.put("surname", user.getSurname());
        identity.put("email", user.getEmail());
        String tokenValue = JWT.create()
                .withSubject(userDetails.getUsername())
                .withClaim("identity", identity)
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
                .sign(Algorithm.HMAC512(secret));
        response.addHeader("ApplicationToken", "Token " + tokenValue);
    }

}
