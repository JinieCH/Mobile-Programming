package org.mind.lab21;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public Button addButton;
    public EditText name;
    public EditText age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.addButton);
        name = findViewById(R.id.editTextName);
        age = findViewById(R.id.editTextAge);

        //when addButton is pushed, to do
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //when push the addButton
                String userName = name.getText().toString(); //receive the name to string
                String userAge = age.getText().toString(); //receive the age to string

                Intent intent = new Intent(getApplicationContext(), newActivity.class);
                intent.putExtra("loginName", userName); //add to user name in intent
                intent.putExtra("loginAge", userAge); //add to user age in intent
                startActivity(intent); //activity start
            }
        });
    }
}
