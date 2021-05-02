package com.hyuntaek5.library.user;

import com.hyuntaek5.library.user.User;
import com.hyuntaek5.library.utilities.SHA256Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class UserInterfaceMethod implements User {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final List<UserVO> list = new LinkedList<UserVO>();
    private UserVO uservo;

    public UserInterfaceMethod() {
        UserVO us = new UserVO();
        us.setId("admin");
        us.setAdminPwd("admin1234");
        us.setUsername("관리자");
        list.add(us);
    }
    @Override
    public void join() {
        System.out.println("\nSign In");
        try{
            UserVO us = new UserVO();

            System.out.println("ID:");
            us.setId(br.readLine());
            if (readUser(us.getId()) != null) {
                System.out.println("Already made ID\n");
            }

            System.out.print("Password:");
            String pwd = br.readLine();
            String salt = SHA256Util.generateSalt();
            String encrypPwd = SHA256Util.getEncrypt(pwd, salt);
            us.setPwd(encrypPwd, salt);

            System.out.print("UserName:");
            us.setUsername(br.readLine());

            list.add(us);
            System.out.println("Thank you for sign in. Please Login.");
        } catch (IOException e){
            System.out.println(e.toString());
        }
    }

    @Override
    public void login() {
        System.out.println("User Login");
        String id, pwd;

        try{
            System.out.print("ID:");
            id = br.readLine();
            System.out.println("Password:");
            pwd = br.readLine();
            UserVO us = readUser(id);
            if(us!=null){
                String salt = us.getSalt();
                String temp_pwd = SHA256Util.Hashing(pwd.getBytes(),salt);
                if(us.getPwd().equals(temp_pwd)){
                     uservo = us;
                } else {
                    System.out.println("Invalid Password!");
                }
            } else {
                System.out.println("There is no User by the ID:"+id);
            }
        } catch (IOException e){
            System.out.println(e.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void logOut(){
        uservo = null;
        System.out.println("LogOut!\n");
    }

    @Override
    public void userDelete(){
        UserVO us1 = readUser(uservo.getId());
        try{
            if(!uservo.getId().equals("admin")){
                System.out.println("\nDelete User");

                System.out.println("Rewrite the password");
                String pwd = br.readLine();

                if (!us1.getPwd().equals(pwd)) {
                    System.out.println("Wrong Password.\n");
                }
            }else if(uservo.getId().equals("admin")){
                System.out.println("\nDelete User");

                System.out.println("ID to Delete:");
                us1 = readUser(br.readLine());
                if(us1==null){
                    System.out.println("ID does not exist.");
                    return;
                }
                System.out.println(us1.getId()+"\t");
                System.out.println(us1.getUsername()+"\t");
                System.out.println("Are you Sure to erase? [Y/N]");
                String a1 = br.readLine();
                if (a1.equals("Y")||a1.equals("y")){
                    list.remove(us1);
                    System.out.println("Complete to delete User.");
                } else {
                    System.out.println("Canacel deleting User.");
                }
            }
        } catch (IOException e){
            System.out.println(e.toString());
        }
        uservo = null;
    }

    private UserVO readUser(String id) {
        UserVO us = null;

        for (UserVO data: list){
            if(data.getId().equals(id)){
                us = data;
                break;
            }
        }
        return us;
    }

    public UserVO loginMember() {
        return uservo;
    }

}
