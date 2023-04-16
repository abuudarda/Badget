package com.example.badget.Model;

public class Expense {
    private String EId, note, cat, type;
    private int amount,time;

    public String getEId() {
        return EId;
    }

    public void setEId(String EId) {
        this.EId = EId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Expense(String EId, String note, String cat, String type, int amount, int time) {
        this.EId = EId;
        this.note = note;
        this.cat = cat;
        this.type = type;
        this.amount = amount;
        this.time = time;
    }
}
