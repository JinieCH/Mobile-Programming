package org.mind.lab1_2;

import java.lang.String;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class MainActivity extends AppCompatActivity {
    public EditText edit_name;

    public Button btn_print;
    public Button btn_clear;
    public TextView view_print;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
    //view object reference function
    public void init() {
        btn_print = (Button) findViewById(R.id.print);
        btn_clear = (Button) findViewById(R.id.clear);
        edit_name = (EditText) findViewById(R.id.enter_name);
        view_print = (TextView) findViewById(R.id.text);
    }

    //When push the clear button, clear the edit text
    public void clearClicked(View v) {
        edit_name.setText("");
        view_print.setText("");
    }

    //When push the print button, prints text at text view area
    public void printClicked(View v) {
        String text = "";
        text = edit_name.getText().toString();
        view_print.setText(text);
    }
}