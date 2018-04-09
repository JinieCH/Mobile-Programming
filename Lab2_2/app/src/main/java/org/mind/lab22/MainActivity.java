package org.mind.lab22;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText url;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = findViewById(R.id.urlEdit);
        nextBtn = findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){ //when click the button
                String urlStr = url.getText().toString(); //get the url string and store to urlStr
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class); //make intent that will sent to Main2Activity
                intent.putExtra("url", urlStr); //put the srlStr in the intent
                startActivity(intent);
            }
        });
    }
}
