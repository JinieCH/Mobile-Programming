package org.mind.lab21;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class newActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent passedIntent = getIntent(); //receive the intent from MainActivity and store

        if(passedIntent!=null){
            String loginName = passedIntent.getStringExtra("loginName"); //get the user name string in the intent
            String loginAge = passedIntent.getStringExtra("loginAge"); //get the user age string in the intent

            Toast.makeText(getApplication(),"Student info: "+loginName+" "+loginAge, Toast.LENGTH_LONG).show();
        }

        Button close = findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        }); // if click the close button, close the page
    }
}

