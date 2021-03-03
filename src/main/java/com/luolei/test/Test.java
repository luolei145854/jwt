package com.luolei.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        //设置令牌
        String token = JWT.create().withClaim("name", "杨幂")//设置数据
                .withClaim("age", 20)
                .withExpiresAt(new Date(System.currentTimeMillis() + 3000))//设置令牌的有效时间
                .sign(Algorithm.HMAC384("fasffffffffff43424"));//设置签名的算法

        System.out.println(token);

        //获取token中的数据
        Verification verification = JWT.require(Algorithm.HMAC384("fasffffffffff43424"));
        JWTVerifier verifier = verification.build();
        DecodedJWT verify = verifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJuYW1lIjoi5p2o5bmCIiwiYWdlIjoyMH0.XlUoYdsRQr4wVLpD40DYAMA5RxssF2eZfOs5ThSkI_pMRx_YJ0Ppegor0dog4SGw");
        System.out.println(verify.getClaim("name").asString());
        System.out.println(verify.getClaim("age").asInt());//存储的是什么类型就用什么类型去取
    }
}
