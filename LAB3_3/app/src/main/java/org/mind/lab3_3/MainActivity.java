package org.mind.lab3_3;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {
    private Button btn_frag1, btn_frag2;
    public Fragment1 fragment1;
    public Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setListener();
    }

    /*
     * Initialize Method that Connects View Variables and Views.
     */
    private void init() {
        btn_frag1 = (Button) findViewById(R.id.btnTab1);
        btn_frag2 = (Button) findViewById(R.id.btnTab2);
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();    }

    private void setListener(){

        btn_frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Do replace fragment to use fragment manager
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment1).commit();
            }
        });
        btn_frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Do replace fragment to use fragment manager
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment2).commit();

            }
        });
    }
}
