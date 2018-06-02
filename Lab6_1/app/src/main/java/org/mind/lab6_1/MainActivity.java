package org.mind.lab6_1;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText txtData;
    Button writeBtn, clearBtn, readBtn, finishBtn;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtData = findViewById(R.id.txtData);
        File sdCard = Environment.getExternalStorageDirectory();
        File directory = new File(sdCard.getAbsolutePath()+"/MyFiles");
        directory.mkdirs();
        file = new File(directory, "textsdfile.txt");

        writeBtn=findViewById(R.id.writeBtn);
        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fOut = new FileOutputStream(file);
                    OutputStreamWriter osw = new OutputStreamWriter(fOut);
                    String text = txtData.getText().toString();
                    osw.write(text);
                    Toast.makeText(getApplicationContext(), "Done write 'mysdfile.txt'", Toast.LENGTH_LONG).show();
                    osw.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        });

        clearBtn=findViewById(R.id.clearBtn);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtData.setText("");
            }
        });

        readBtn = findViewById(R.id.readBtn);
        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fIn = new FileInputStream(file);
                    if(fIn != null) {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(fIn));
                        String str = "";
                        StringBuffer buf = new StringBuffer();
                        while((str = reader.readLine())!=null){
                            buf.append(str+"  ");
                        }
                        fIn.close();
                        txtData.setText(buf.toString());
                    }
                }catch (Throwable t){
                }
                Toast.makeText(getApplicationContext(), "Done reading mysdfile.txt",Toast.LENGTH_SHORT).show();
            }
        });
//        readBtn=findViewById(R.id.readBtn);
//        readBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    FileInputStream fIn = new FileInputStream(file);
//                    InputStreamReader isr = new InputStreamReader(fIn);
//                    int i=0;
//
//                    StringBuffer buf = new StringBuffer();
//
//                    while(isr.read()!=i){
//                        buf.append((char)i);
//                    }
//                    Toast.makeText(getApplicationContext(), "Done reading SD 'mysdfile.txt'", Toast.LENGTH_LONG).show();
//                    isr.close();
//
//                    txtData.setText(buf.toString());
//                }catch(FileNotFoundException e){
//                    e.printStackTrace();
//                }catch(IOException e){
//                    e.printStackTrace();
//                }
//            }
//        });

        finishBtn=findViewById(R.id.finishBtn);
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
