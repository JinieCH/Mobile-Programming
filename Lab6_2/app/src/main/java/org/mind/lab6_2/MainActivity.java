package org.mind.lab6_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button getBtn, saveBtn, clearBtn;
    EditText nameText, snText;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;
    String name="", sn="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.name);
        snText = findViewById(R.id.sn);

        saveBtn=findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameText.getText().toString();
                sn = snText.getText().toString();
                sharedPreferences();
            }
        });

        getBtn=findViewById(R.id.getBtn);
        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applySharedPreference();
            }
        });

        clearBtn=findViewById(R.id.clearBtn);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameText.setText("");
                snText.setText("");
            }
        });


    }

    public void sharedPreferences(){
        sh_Pref = getSharedPreferences("Info", MODE_PRIVATE);
        toEdit = sh_Pref.edit();
        toEdit.putString("sn", sn);
        toEdit.putString("name", name);
        toEdit.commit();
    }

    public void applySharedPreference(){
        sh_Pref = getSharedPreferences("Info",MODE_PRIVATE);
        if(sh_Pref!=null&&sh_Pref.contains("name")){
            String name = sh_Pref.getString("name", "none");
            String sn = sh_Pref.getString("sn","0");

            nameText.setText(name);
            snText.setText(sn);
        }
    }
}
