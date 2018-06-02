package org.mind.lab6_3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, num;
    Button add, delete;
    ListView listView;
    SQLiteDatabase db;
    MySQLiteOpenHelper helper;
    public String[] Student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Find activity_main's widgets by id, and get it
        name = (EditText)findViewById(R.id.name);
        num = (EditText)findViewById(R.id.num);
        add = (Button)findViewById(R.id.add);
        delete = (Button)findViewById(R.id.delete);
        listView = (ListView)findViewById(R.id.listView);

        //add To SQLite database
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!name.getText().toString().equals("") || !num.getText().toString().equals("")) {
                    helper = new MySQLiteOpenHelper(MainActivity.this, "person.db", null, 1);
                    insert(name.getText().toString(), num.getText().toString());
                    try {
                        invalidate();
                    }catch (NullPointerException n){};
                }
                else{
                    Toast.makeText(getApplicationContext(), "모든 항목을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //delete from SQLite database
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!name.getText().toString().equals("")){
                    delete(name.getText().toString());
                }
                else{
                    Toast.makeText(getApplicationContext(),"이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //insert data with column name to database
    public void insert(String name, String num){
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("_id", num);
        db.insert("student",null,values);
    }
    //Cursor represents a single table row
    //Store all table rows to String[] by cursor
    public void select(){
        db = helper.getReadableDatabase();
        Cursor c = db.query("student",null,null,null,null,null,null);
        Student = new String[c.getCount()];
        int count = 0;
        while(c.moveToNext()) {
            Student[count] = c.getString(c.getColumnIndex("name"))
                    + " " + c.getString(c.getColumnIndex("_id"));
            count++;
        }
        c.close();
    }
    //Set adapter to listView
    private void invalidate(){
        select();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,Student);
        listView.setAdapter(adapter);
    }
    //delete data with column from database
    public void delete(String name){
        db = helper.getWritableDatabase();
        db.delete("student","name=?", new String[]{name});
        try {
            invalidate();
        }catch (NullPointerException n){};
    }
}
