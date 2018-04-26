package org.mind.lab3_first;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = (Button) findViewById(R.id.btn);
        // Register Button For Context Menu.
        registerForContextMenu(mBtn);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo
            menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // Set Menu's Title.
        menu.setHeaderTitle("Button Menu");
        // Setting the menu.
        menu.add(0, 1, 0, "red");
        menu.add(0, 2, 0, "green");
        menu.add(0, 3, 0, "blue");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Checking menu's ID and change button's text color.
        switch (item.getItemId()) {
            case 1:
                mBtn.setTextColor(Color.RED);
                break;
            case 2:
                mBtn.setTextColor(Color.GREEN);
                break;
            case 3:
                mBtn.setTextColor(Color.BLUE);
                break;
        }

        return super.onContextItemSelected(item);
    }
}
