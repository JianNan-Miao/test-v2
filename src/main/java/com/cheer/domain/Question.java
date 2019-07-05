package com.cheer.domain;

public class Question {
    private  int id;
    private  String title;
    private  String qa;
    private  String qb;
    private  String qc;
    private  String qd;
    private  String answer;

    public Question() {
    }

    public Question(int id, String title, String qa, String qb, String qc, String qd, String answer) {
        this.id = id;
        this.title = title;
        this.qa = qa;
        this.qb = qb;
        this.qc = qc;
        this.qd = qd;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQa() {
        return qa;
    }

    public void setQa(String qa) {
        this.qa = qa;
    }

    public String getQb() {
        return qb;
    }

    public void setQb(String qb) {
        this.qb = qb;
    }

    public String getQc() {
        return qc;
    }

    public void setQc(String qc) {
        this.qc = qc;
    }

    public String getQd() {
        return qd;
    }

    public void setQd(String qd) {
        this.qd = qd;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", qa='" + qa + '\'' +
                ", qb='" + qb + '\'' +
                ", qc='" + qc + '\'' +
                ", qd='" + qd + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
