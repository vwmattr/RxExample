package com.vwmattr.rxexample.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Represents the response returned from StackOverflow's /questions endpoint
 */
public class QuestionList {

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("quota_max")
    private int quotaMax;

    @SerializedName("quota_remaining")
    private int quotaRemaining;

    private List<Question> items;

    public List<Question> getItems() {
        return items;
    }

    public QuestionList setItems(List<Question> items) {
        this.items = items;
        return this;
    }

    public int getQuotaMax() {
        return quotaMax;
    }

    public void setQuotaMax(int quotaMax) {
        this.quotaMax = quotaMax;
    }

    public int getQuotaRemaining() {
        return quotaRemaining;
    }

    public void setQuotaRemaining(int quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

}
