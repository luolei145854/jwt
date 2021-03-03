package com.luolei.util;

import org.springframework.stereotype.Component;

@Component
public class SlatUtil {

    public String getSlat(int number){
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwhyz1234567890~!@#$%^&&*";
        StringBuilder sb = new StringBuilder();
        for(int i =0;i < number;i++){
            int random = (int)(Math.random() * s.length());
            String substring = s.substring(random, random + 1);
            sb.append(substring);
        }
        return sb.toString();
    }
}
