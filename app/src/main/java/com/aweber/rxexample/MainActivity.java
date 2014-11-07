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
        server.questions(new QuestionsCallback());
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

    class QuestionsCallback implements Callback<QuestionList> {

        @Override
        public void success(QuestionList questionList, Response response) {
            Toast.makeText(MainActivity.this, "Success!", Toast.LENGTH_SHORT).show();
            if (questionList != null && questionList.getItems() != null) {
                Log.d("QuestionsCallback", "Question Count: " + questionList.getItems().size());
                adapter.setQuestions(questionList.getItems());
            }
        }

        @Override
        public void failure(RetrofitError error) {
            Toast.makeText(MainActivity.this, "ERROR!", Toast.LENGTH_SHORT).show();
        }
    }
}
