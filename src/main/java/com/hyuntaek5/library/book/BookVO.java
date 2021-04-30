package com.hyuntaek5.library.book;

import java.util.Scanner;

public class BookVO {
    Scanner sc = new Scanner(System.in);
    private String Title;
    private String Author;
    private int Stock;
    private boolean Available;

    public String getTitle(){
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getAuthor(){
        return Author;
    }

    public void setAuthor(String author) {
        this.Author = author;
    }

    public Boolean isAvailable(){
        return Available;
    }

    public void setAvailable(boolean available) {
        this.Available = available;
    }

    public int getStock(){
        return Stock;
    }

    public void setStock(int stock) {
        this.Stock = stock;
    }
}
