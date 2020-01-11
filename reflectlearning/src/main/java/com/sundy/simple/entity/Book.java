package com.sundy.simple.entity;

import androidx.annotation.NonNull;

/**
 * 项目名称：AndroidStudy
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-11 21:44
 * 描述：
 */
public class Book {
    private static final String TAG = "Book";
    private String name;
    private String author;

    public Book(){

    }

    private Book(String name, String author) {
        this.name = name;
        this.author = author;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private String declaredMethod(int index) {
        String string = null;
        switch (index) {
            case 0:
                string = "I am declaredMethod 1 !";
                break;
            case 1:
                string = "I am declaredMethod 2 !";
                break;
            default:
                string = "I am declaredMethod 1 !";
        }

        return string;
    }

    @NonNull
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
