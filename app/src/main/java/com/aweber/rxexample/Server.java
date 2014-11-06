package com.aweber.rxexample;

import com.aweber.rxexample.entities.QuestionList;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;

/**
 * API service interface. Used by Retrofit to handle server
 * communication.
 */
public interface Server {

    static final String QUESTIONS_ENDPOINT =
            "/2.2/questions?order=desc&sort=activity&tagged=android&site=stackoverflow";

    @GET(QUESTIONS_ENDPOINT)
    void questions(Callback<QuestionList> callback);

}
