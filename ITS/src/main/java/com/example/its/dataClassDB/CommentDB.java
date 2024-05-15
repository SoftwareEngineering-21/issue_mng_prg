package com.example.its.dataClassDB;

public class CommentDB {
    private int id;
    private String text;
    private String reporter;
    private String date;

    public CommentDB(int id, String text, String reporter, String date)
    {
        this.id = id;
        this.text = text;
        this.reporter = reporter;
        this.date = date;
    }

    public int readId() {return this.id;}
    public String readText() {return this.text;}
    public String readReporter() {return this.reporter;}
    public String readDate() {return this.date;}
    public void updateId(int id) {this.id=id;}
    public void updateText(String text) {this.text=text;}
    public void updateReporter(String reporter) {this.reporter=reporter;}
    public void updateDate(String date) {this.date=date;}
}
