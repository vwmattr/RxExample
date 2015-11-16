package com.vwmattr.rxexample.modules;

import com.vwmattr.rxexample.Server;
import com.vwmattr.rxexample.entities.Question;
import com.vwmattr.rxexample.entities.QuestionList;

import java.util.Arrays;

import dagger.Module;
import dagger.Provides;
import rx.Observable;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by rein on 11/16/15.
 */
@Module
public class MockApiModule {

    @Provides
    Server provideServer() {
        Server server = mock(Server.class);
        Question q1 = new Question().setTitle("Question 1 Title");
        Question q2 = new Question().setTitle("2nd Question Title");
        Question q3 = new Question().setTitle("Title of question 3");
        QuestionList questionList = new QuestionList().setItems(Arrays.asList(q1, q2, q3));

        when(server.questions()).thenReturn(Observable.just(questionList));
        return server;
    }

}
