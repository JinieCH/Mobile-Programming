package org.mind.lab5_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1;
    ImageView imageView2;
    EditText editText;
    Button button;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //When clicks button, start threads
                DogThread thread1 = new DogThread(0);
                thread1.start();
                DogThread thread2 = new DogThread(1);
                thread2.start();
            }
        });
    }

    class DogThread extends Thread {
        int dogIndex;
        int stateIndex;

        ArrayList<Integer> images = new ArrayList<Integer>();

        public DogThread(int index){ //constructor
            dogIndex = index;
            images.add(R.drawable.default_dog);
            images.add(R.drawable.eating_dog);
            images.add(R.drawable.standing_dog);
        }

        public void run(){ //thread run
            stateIndex = 0;
            for(int i=0;i<9;i++){
                final String msg = "dog # "+dogIndex +" state: "+stateIndex;
                handler.post(new Runnable(){
                    public void run(){
                        editText.append(msg+"\n"); //setting the text

                        if(dogIndex == 0) { //setting images in imageView1
                            imageView1.setImageResource(images.get(stateIndex));
                        }
                        else if(dogIndex == 1){ //setting images in imageView2
                            imageView2.setImageResource(images.get(stateIndex));
                        }
                    }
                });

                try{
                    int sleepTime = getRandomTime(500, 3000); //get random integer
                    Thread.sleep(sleepTime); //sleep the thread
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

                stateIndex++;
                if(stateIndex >= images.size()){
                    stateIndex = 0;
                }
            }
        }
        public int getRandomTime(int min, int max){
            return min+(int)(Math.random()*(max-min));
        }
    }

}