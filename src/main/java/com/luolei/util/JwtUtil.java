package com.luolei.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;

public class JwtUtil {
    //设置时间
    private static final long EXPRI_TIME= 6*60*24*1000L;
    //设置签名的算法
    private static final String SIGN=new SlatUtil().getSlat(10);
    //创建jwt
    public String createToken(HashMap<String,String> hm){
        JWTCreator.Builder builder = JWT.create();
        //设置令牌中的数据
        hm.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        //设置令牌的有效时间
        builder.withExpiresAt(new Date(System.currentTimeMillis()+ EXPRI_TIME));

        //设置签名的算法
        String token = builder.sign(Algorithm.HMAC256(SIGN));

        return token;
    }

    //解析jwt
    public DecodedJWT verify(String token){
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        return verify;
    }
}
