package org.mind.lab5_2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText inputNumber;
    Button btn;
    TextView factorialText, result;
    static int facto = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.editText);
        factorialText = findViewById(R.id.textView1);
        result = findViewById(R.id.textView2);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() { //When clicks the button, call the Factorial class
            @Override
            public void onClick(View v) {
                new Factorial().execute();
            }
        });
    }

    private class Factorial extends AsyncTask<Void, Integer, Void> {
        int number = 0 ;

        @Override
        protected void onPreExecute(){ //Setting before doing task
            number = Integer.parseInt(inputNumber.getText().toString());
            factorialText.setText("");
            result.setText("= ?");
        }

        @Override
        protected Void doInBackground(Void... params){
            for(int i=number;i>=1;i--){
                try{
                    Thread.sleep(500); //sleep the thread
                    publishProgress(i); //call the onProgress with factorial number
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values){
            factorialText.append(values[0].toString() + " "); //setting text that number
            facto = facto * values[0]; //calculates factorial
        }

        @Override
        protected void onPostExecute(Void avoid){
            result.setText("= "+facto); //setting text that result;
        }
    }

}
