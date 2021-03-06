package com.hyuntaek5.library;


import com.hyuntaek5.library.book.BookInterfaceMethod;
import com.hyuntaek5.library.user.UserInterfaceMethod;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        UserInterfaceMethod user = new UserInterfaceMethod();
        BookInterfaceMethod book = new BookInterfaceMethod();
        String ch1;
        int ch2;

        while (true) {
            if(user.loginMember()==null){
                try{
                    do{
                        System.out.print("[1]Login\n[2]SignIn\n[3]Quit\n");
                        ch1 = sc.next();
                        ch2 = Integer.parseInt(ch1);
                    } while (ch2<1||ch2>2);
                    if (ch1.equals("Q")) {System.out.println("Good Bye!");break;}
                    switch (ch2){
                        case 1:{
                            user.login();
                            break;
                        }
                        case 2:{
                            user.join();
                            break;
                        }
                    }
                } catch (NumberFormatException e) {
                    break;
                }
            } else if(user.loginMember().getId().equals("admin")) {
                do {
                    System.out.print("[1]Manage Book\n[2]LogOut\n[3]Return\n");
                    ch2 = sc.nextInt();
                } while (ch2<1||ch2>3);
                if(ch2==3) break;
                switch (ch2) {
                    case 1: do{
                        System.out.println("[1]Add Book\n[2]Delete Book\n[3]BookList\n[4]Return\n");
                        ch2 = sc.nextInt();
                    } while (ch2<1||ch2>4);
                    if(ch2==4) break;
                    switch (ch2){
                        case 1: book.addBook(); break;
                        case 2: book.deleteBook(); break;
                        case 3: book.printBookList(); break;
                    } break;

                    case 2: user.logOut();break;
                }
            }
            else {
                try {
                    do{
                        System.out.print("[1]Borrow Book\n[2]Back Book\n[3]Look at BookList\n[4]LogOut\n[5]Delete User\n[6]Quit(Input Q)\n");
                        ch1 = sc.next();
                        ch2 = Integer.parseInt(ch1);
                    } while (ch2<1||ch2>6);
                    if (ch1.equals("Q")) break;
                    switch (ch2) {
                        case 1: book.borrow(); break;
                        case 2: book.back(); break;
                        case 3: book.printBookList(); break;
                        case 4: user.logOut(); break;
                        case 5: user.userDelete(); break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input the right number.\nIf you want to quit, input 'Q'.");
                    break;
                }
            }
        }
    }
}
