package com.example.wph_service_provider.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyEmail {
    //电子邮件
    public static final String CHECK ="^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";




    public static boolean isEmail(String email){
        Pattern regex = Pattern.compile(CHECK);
        Matcher matcher = regex.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        boolean email = isEmail("595264@qq.com");
        System.out.println(email);
    }





}
