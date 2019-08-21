package com.example.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SearchPcodeAsyncTask getAllInfor = new SearchPcodeAsyncTask();
        getAllInfor.execute("3125");

    }
    private class SearchPcodeAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String result = null;
            result = Restful.findByPostcode(params[0]);
            return result;
        }
        @Override
        protected void onPostExecute(String result) {
             System.out.println(result);

        }
    }
}
