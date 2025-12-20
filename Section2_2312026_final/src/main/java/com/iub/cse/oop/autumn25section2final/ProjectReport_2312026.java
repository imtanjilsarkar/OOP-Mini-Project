package com.iub.cse.oop.autumn25section2final;

import java.io.Serializable;
import java.time.LocalDate;

public class ProjectReport_2312026 implements Serializable {
    private String title;
    private String author;
    private String binding;
    private LocalDate date;
    private int mark1;
    private int mark2;

    public ProjectReport_2312026(int mark2, int mark1, LocalDate date, String binding, String author, String title) {
        this.mark2 = mark2;
        this.mark1 = mark1;
        this.date = date;
        this.binding = binding;
        this.author = author;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getMark1() {
        return mark1;
    }

    public void setMark1(int mark1) {
        this.mark1 = mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public void setMark2(int mark2) {
        this.mark2 = mark2;
    }

    @Override
    public String toString() {
        return "ProjectReport_2312026{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", binding='" + binding + '\'' +
                ", date=" + date +
                ", mark1=" + mark1 +
                ", mark2=" + mark2 +
                '}';
    }
}
