package com.aweber.rxexample.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a single Question item from StackOverflow's /questions endpoint
 */
public class Question {

    @SerializedName("is_answered")
    private boolean answered;

    @SerializedName("question_id")
    private int questionId;

    private String link;

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

}
