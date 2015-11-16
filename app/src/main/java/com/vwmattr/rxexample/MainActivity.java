package com.vwmattr.rxexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.vwmattr.rxexample.components.AppComponent;
import com.vwmattr.rxexample.components.DaggerMainComponent;
import com.vwmattr.rxexample.entities.QuestionList;
import com.vwmattr.rxexample.modules.MainModule;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class MainActivity extends Activity {

    @Inject
    Server server;
    ListView listView;
    QuestionListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent(App.get(this).component());
        setContentView(R.layout.activity_main);

        adapter = new QuestionListAdapter(this);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        server.questions()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<QuestionList>() {
                    @Override
                    public void call(QuestionList questionList) {
                        if (questionList != null && questionList.getItems() != null) {
                            Log.d("QuestionsCallback", "Question Count: " + questionList.getItems().size());
                            adapter.setQuestions(questionList.getItems());
                        } else {
                            Log.d("QuestionsCallback", "No questions returned from /questions API call");
                        }
                    }
                });
    }

    protected void setupComponent(AppComponent appComponent) {
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .mainModule(new MainModule())
                .build()
                .inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
