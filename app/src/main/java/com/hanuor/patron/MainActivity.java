package com.hanuor.patron;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.hanuor.patron.API_DB.ApiContainer;
import com.hanuor.patron.GithubAPI.CoreAPI.Repository;
import com.hanuor.patron.GithubAPI.CoreAPI.service.RepositoryService;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ApiContainer ap;
    TextView tv;
    String user = "hanuor";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        ap = new ApiContainer();

        new AsyncTaskRunner().execute();
       
    }
    private class AsyncTaskRunner extends AsyncTask<Void, String, ArrayList<String>> {

        private String resp;
        ArrayList<String> ss = new ArrayList<String>();

        /*
         * (non-Javadoc)
         *
         * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
         */
        @Override
        protected void onPostExecute(ArrayList<String> result) {
            tv.setText(result.toString());
            // execution of result of Long time consuming operation
            //finalResult.setText(result);
        }

        @Override
        protected ArrayList<String> doInBackground(Void... voids) {
            RepositoryService repos = new RepositoryService();
            final String format = "{0}) {1}- created on {2}";
            int count = 1;
            try {
                for (Repository repo : repos.getRepositories(user)) {
                    ss.add( repo.getName());
                    Log.d("TAGGY",""+MessageFormat.format(format, count++,
                            repo.getName(), repo.getCreatedAt()));

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return ss;

        }

        /*
                         * (non-Javadoc)
                         *
                         * @see android.os.AsyncTask#onPreExecute()
                         */
        @Override
        protected void onPreExecute() {
            // Things to be done before execution of long running operation. For
            // example showing ProgessDialog
        }

        /*
         * (non-Javadoc)
         *
         * @see android.os.AsyncTask#onProgressUpdate(Progress[])
         */
        @Override
        protected void onProgressUpdate(String... text) {
            //finalResult.setText(text[0]);
            // Things to be done while execution of long running operation is in
            // progress. For example updating ProgessDialog
        }
    }


}
