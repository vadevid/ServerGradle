package com.example.models;

public class CardAnswerModel {
    Integer id;
    String valueName;
    String answer;
    String answerDate;

    public CardAnswerModel(Integer id, String valueName, String answer, String answerDate) {
        this.id = id;
        this.valueName = valueName;
        this.answer = answer;
        this.answerDate = answerDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(String answerDate) {
        this.answerDate = answerDate;
    }
}
