package org.mind.lab22;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.*;
import java.lang.String;


public class Main2Activity extends AppCompatActivity {

    TextView textView;
    Button goBtn;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.urlPrint);
        goBtn = findViewById(R.id.goBtn);
        backBtn = findViewById(R.id.backBtn);

        final Intent passedIntent = getIntent(); //receive the intent
        final String passedUrl  = passedIntent.getStringExtra("url"); //get the url in the intent and store in string

        textView.setText(passedUrl); //viewing the text

        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//when click the button
                if (!passedUrl.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + passedUrl)); //open the url link
                    startActivity(intent);
                } else { //if passedUrl is null
                    Toast.makeText(getApplicationContext(),"주소를 다시 입력해주세요", Toast.LENGTH_SHORT).show(); //view the toast message
                }
            }
        });


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //when click the button
                Toast.makeText(getApplication(),"뒤로가기 버튼을 눌렀습니다",Toast.LENGTH_LONG).show(); //view the toast message
                finish(); //previous page
            }
        });
    }
}
