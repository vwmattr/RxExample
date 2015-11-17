package com.vwmattr.rxexample;

import com.vwmattr.rxexample.entities.QuestionList;

import retrofit.Call;
import retrofit.http.GET;

/**
 * API service interface. Used by Retrofit to handle server
 * communication.
 */
public interface Server {

    static final String QUESTIONS_ENDPOINT =
            "/2.2/questions?order=desc&sort=activity&tagged=android&site=stackoverflow";

    //Straight up Retrofit 2.0 way:
    @GET(QUESTIONS_ENDPOINT)
    Call<QuestionList> questions();

    //Retrofit 1.7 + RxJava way:
//    @GET(QUESTIONS_ENDPOINT)
//    Observable<QuestionList> questions();

}
