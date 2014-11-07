package com.aweber.rxexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.aweber.rxexample.entities.QuestionList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class MainActivity extends Activity {

    Server server;
    ListView listView;
    QuestionListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new QuestionListAdapter(this);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        RestAdapter restAdapter = createRestAdapter();
        server = restAdapter.create(Server.class);

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

    private RestAdapter createRestAdapter() {
        final RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint("https://api.stackexchange.com")
                .setLogLevel(RestAdapter.LogLevel.FULL);

        return builder.build();
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
