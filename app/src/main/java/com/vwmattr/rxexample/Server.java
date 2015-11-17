package com.vwmattr.rxexample;

import com.vwmattr.rxexample.entities.QuestionList;

import retrofit.Call;
import retrofit.http.GET;
import rx.Observable;

/**
 * API service interface. Used by Retrofit to handle server
 * communication.
 */
public interface Server {

    String QUESTIONS_ENDPOINT =
            "/2.2/questions?order=desc&sort=activity&tagged=android&site=stackoverflow";

    //Vanilla Retrofit 2.0:
    @GET(QUESTIONS_ENDPOINT)
    Call<QuestionList> questions();

    //Retrofit 2.0 + RxJava:
    @GET(QUESTIONS_ENDPOINT)
    Observable<QuestionList> questionsRx();

}
