package com.vwmattr.rxexample.modules;

import com.vwmattr.rxexample.Server;
import com.vwmattr.rxexample.entities.Question;
import com.vwmattr.rxexample.entities.QuestionList;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Arrays;

import dagger.Module;
import dagger.Provides;
import retrofit.Call;
import retrofit.Callback;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
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
        final QuestionList questionList = new QuestionList().setItems(Arrays.asList(q1, q2, q3));

        //TODO: When we add Rx Back.. this may be helpful.
//        when(server.questions()).thenReturn(Observable.just(questionList));

        Call<QuestionList> mockCall = mock(Call.class);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                Callback<QuestionList> callback = (Callback) args[0];
                retrofit.Response<QuestionList> response = retrofit.Response.success(questionList);
                callback.onResponse(response, null);
                return null;
            }
        }).when(mockCall).enqueue(any(Callback.class));

        when(server.questions()).thenReturn(mockCall);

        return server;
    }

}
