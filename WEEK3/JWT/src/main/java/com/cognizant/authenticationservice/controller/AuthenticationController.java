package com.cognizant.authenticationservice.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    private final SecretKey key =
            Keys.hmacShaKeyFor(
                    "thisIsASecretKeyForJwtGeneration12345"
                            .getBytes(StandardCharsets.UTF_8));

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authHeader) {

        LOGGER.info("START");

        LOGGER.debug("Authorization Header : {}", authHeader);

        String user = getUser(authHeader);

        LOGGER.debug("User : {}", user);

        String token = generateJwt(user);

        Map<String, String> map = new HashMap<>();

        map.put("token", token);

        LOGGER.info("END");

        return map;
    }

    private String getUser(String authHeader) {

        LOGGER.debug("Inside getUser()");

        String encodedCredentials = authHeader.substring(6);

        byte[] decoded = Base64.getDecoder().decode(encodedCredentials);

        String credentials = new String(decoded);

        return credentials.split(":")[0];
    }

    private String generateJwt(String user) {

        return Jwts.builder()
                .subject(user)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1200000))
                .signWith(key)
                .compact();
    }
}