package org.techtown.roomdatabaseprac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static MyDatabase myDatabase;
    private Button adddata,readdata,deletedata,updatedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabase = Room.databaseBuilder(getApplicationContext(),MyDatabase.class,"infodb").allowMainThreadQueries().build();

        adddata =(Button)findViewById(R.id.button_add);
        readdata=(Button)findViewById(R.id.button_read);
        deletedata=(Button)findViewById(R.id.button_delete);
        updatedata=(Button)findViewById(R.id.button_update);

        adddata.setOnClickListener(this);
        readdata.setOnClickListener(this);
        deletedata.setOnClickListener(this);
        updatedata.setOnClickListener(this);
    }

    public void onClick(View v){
        int id = v.getId();
        switch (id){
            case R.id.button_add:{
                startActivity(new Intent(MainActivity.this,AddDataActivity.class));
                break;
            }
            case R.id.button_read:{
                startActivity(new Intent(MainActivity.this,ReadDataActivity.class));
                break;
            }
            case R.id.button_delete:{
                startActivity(new Intent(MainActivity.this,DeleteDataActivity.class));
                break;
            }
            case R.id.button_update:{
                startActivity(new Intent(MainActivity.this,UpdateDataActivity.class));
                break;
            }
        }
    }
}



