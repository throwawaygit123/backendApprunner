package com.quanbio.jwttoken;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JwtToken {
    private static final String SING = "!QAZWSX234EDCRFV45TGB6YHNUJM78KKI";
//
    /**
     * token，header.payload.sing
     * @return
     */
    public static String getToken(Map<String,String> map){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,7);   //It expires in 7 days by default
        // Create JWT builder
        JWTCreator.Builder builder = JWT.create();
        // Load the payload in the MAP
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });

        String token = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SING));// sign
        return token;
    }

    /**
     * verification token
     * Verifying Token Validity
     * @param token
     */
    public static DecodedJWT verify(String token){
        return JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
    }


}