package com.aweber.rxexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends Activity {

    Server server;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

    class QuestionsCallback implements Callback<Response> {

        @Override
        public void success(Response response, Response response2) {
            Toast.makeText(MainActivity.this, "Success!", Toast.LENGTH_SHORT).show();
            Log.d("QuestionsCallback", response.getBody().toString());
        }

        @Override
        public void failure(RetrofitError error) {
            Toast.makeText(MainActivity.this, "ERROR!", Toast.LENGTH_SHORT).show();
        }
    }
}
