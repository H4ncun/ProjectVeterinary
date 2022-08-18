package com.gft.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.gft.entities.SystemUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class AuthService {


    @Value("${api.jwt.expiration}")
    private String EXPIRE_DURATION;

    @Value("${api.jwt.secret}")
    private String SECRET_KEY;

    @Value("${api.jwr.issuer}")
    private String ISSUER;

    private Algorithm createAlgorithm() {
        return Algorithm.HMAC256(SECRET_KEY);
    }


    public String createToken(Authentication auth) {

        SystemUser principal = (SystemUser) auth.getPrincipal();
        Date timestamp = new Date();
        Date expirationDate = new Date(timestamp.getTime() + Long.parseLong(EXPIRE_DURATION));

        return JWT.create().withIssuer(ISSUER)
                .withExpiresAt(expirationDate)
                .withSubject(principal.getId().toString())
                .sign(this.createAlgorithm());
    }

    public boolean validateAcessToken(String token) {
        try {
            if (token == null) {
                return false;
            }

            JWT.require(this.createAlgorithm()).withIssuer(ISSUER).build().verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            return false;
        }
    }

    public Long returnIdUser(String token) {
        String subject = JWT.require(this.createAlgorithm())
                .withIssuer(ISSUER)
                .build()
                .verify(token)
                .getSubject();
        return Long.parseLong(subject);
    }

}
