package com.hyuntaek5.library.book;

import com.hyuntaek5.library.book.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;

public class BookInterfaceMethod implements Book {
    Scanner scan = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<String, BookVO> map = new HashMap<>();
    DecimalFormat df = new DecimalFormat("000");
//    private final Calendar currentTime = Calendar.getInstance();

    @Override
    public void borrow() {
        try{
            String Title;
            System.out.println("Write a book title to borrow:");
            Title = br.readLine();

            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                String num = it.next();
                BookVO book = map.get(num);

                if(book.getTitle().startsWith(Title)){
                    if(!book.isAvailable()){
                        System.out.println("Already borrowed.");
                        break;
                    }
                    book.setStock(book.getStock()-1);
                    System.out.print(num+"\t");
                    System.out.println("====Borrowed Completed====");
                    System.out.print("|   "+book.getTitle()+"   |\n");
                    System.out.print("|   "+book.getAuthor()+"   |\n");
                    System.out.print("|   "+book.getStock()+"   |\n");
                    System.out.print("==========================");
                    book.setAvailable(false);
                }
            }
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }
    @Override
    public void back(){
        System.out.println("Write a book title to back:");
        String s = scan.next();

        for (String key : map.keySet()) {
            BookVO value = map.get(key);

            if (s.equals(value.getTitle())) {
                if (value.isAvailable()) {
                    System.out.println("Currently Avaliable.");
                } else if (!value.isAvailable()) {
                    System.out.println("Successfully Backed");
                    value.setStock(value.getStock() + 1);
                    value.setAvailable(true);
                }
            }
        }
    }

    @Override
    public void printBookList(){
        for (String key : map.keySet()) {
            BookVO value = map.get(key);
            System.out.println(key + "\t" + value.getTitle() + "\t" + value.getAuthor() + "\t" + value.getStock() + "\n");
        }
    }

    @Override
    public void addBook(){
        System.out.println("\nAdd com.hyuntaek5.library.book.Book...");

        try{
            String code;
            BookVO vo = new BookVO();

            System.out.println("Code:");
            code = br.readLine();

            System.out.println("com.hyuntaek5.library.book.Book Name:");
            vo.setTitle(br.readLine());

            System.out.println("Author Name:");
            vo.setAuthor(br.readLine());

            vo.setStock(vo.getStock()+1);

            map.put(code, vo);
            System.out.println("com.hyuntaek5.library.book.Book has been added");

        } catch (IOException e){
            System.out.println(e.toString());
        }
    }

    @Override
    public void deleteBook(){
        System.out.println("Write a book tilte to delete");

        String s = scan.next();

        for (String key : map.keySet()) {
            BookVO value = map.get(key);

            if (s.equals(value.getTitle())) {
                map.remove(key);
                System.out.println(s + "Successfully Deleted.");
                value.setStock(value.getStock() - 1);
            }
        }
    }

}
