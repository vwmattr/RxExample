package com.vwmattr.rxexample;

import com.vwmattr.rxexample.entities.QuestionList;

import retrofit.http.GET;
import rx.Observable;

/**
 * API service interface. Used by Retrofit to handle server
 * communication.
 */
public interface Server {

    static final String QUESTIONS_ENDPOINT =
            "/2.2/questions?order=desc&sort=activity&tagged=android&site=stackoverflow";

    @GET(QUESTIONS_ENDPOINT)
    Observable<QuestionList> questions();

}
