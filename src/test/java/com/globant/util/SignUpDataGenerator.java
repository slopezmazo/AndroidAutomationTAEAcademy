package com.globant.util;

import java.util.Random;

public class SignUpDataGenerator {

    private static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890-#$%&*";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 15) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
    public static String getEmail() {
        String email= getSaltString().concat("@gmail.com");
        return email;
    }

    public static String getPassword() {
        String psw = getSaltString();
        return psw;
    }
}
