package com.hyuntaek5.library.user;
import com.hyuntaek5.library.utilities.SHA256Util;

import java.security.SecureRandom;

public class UserVO {
    private String id;
    private String pwd;
    private String salt;
    private String username;

    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getPwd(){
        return pwd;
    }

    public void setPwd(String pwd, String salt){
        this.pwd = pwd;
        this.salt = salt;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalt(){
        return salt;
    }

    public String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        return Byte_to_String(salt);
    }

    public String Byte_to_String(byte[] temp) {
        StringBuilder sb = new StringBuilder();
        for(byte a : temp) {
            sb.append(String.format("%02x", a));
        }
        return sb.toString();
    }

}
