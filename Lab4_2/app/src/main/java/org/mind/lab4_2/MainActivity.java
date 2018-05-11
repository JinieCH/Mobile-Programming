package org.mind.lab4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.Button;
import android.view.animation.AnimationUtils;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    boolean isPageOpen = false;
    Animation translateLeftAnim;
    Animation translateRightAnim;
    LinearLayout slidingPage01;

    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slidingPage01 = (LinearLayout)findViewById(R.id.slidingPage01);
        button1 = (Button)findViewById(R.id.buton1);

        translateLeftAnim = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translateRightAnim = AnimationUtils.loadAnimation(this, R.anim.translate_right);

        //setting animation listener
        SlidingPageAnimationListener animationListener = new SlidingPageAnimationListener();
        translateLeftAnim.setAnimationListener(animationListener);
        translateRightAnim.setAnimationListener(animationListener);
    }

    public void onButton1Clicked(View v){
        //when close
        if(isPageOpen){
            slidingPage01.startAnimation(translateRightAnim);
        }
        //when open
        else{
            slidingPage01.setVisibility(View.VISIBLE);
            slidingPage01.startAnimation(translateLeftAnim);
        }
    }

    //animation listener
    private class SlidingPageAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationEnd(Animation animation) {
            //slide open to close
            if(isPageOpen){
                slidingPage01.setVisibility(View.INVISIBLE);
                button1.setText("Open");
                isPageOpen = false;
            }
            //slide close to open
            else{
                button1.setText("Close");
                isPageOpen = true;
            }
        }
        @Override
        public void onAnimationRepeat(Animation animation) {

        }
        @Override
        public void onAnimationStart(Animation animation) {

        }
    }
}