package com.hyuntaek5.library.user;

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

    public void setAdminPwd(String pwd){
        this.pwd = pwd;
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
}
