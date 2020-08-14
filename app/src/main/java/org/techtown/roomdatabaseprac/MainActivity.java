package org.techtown.roomdatabaseprac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener
{
    public static MyDatabase myDatabase;
    private Button adddata,readdata,deletedata,updatedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabase = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "infodb").allowMainThreadQueries().build();

        adddata = (Button) findViewById(R.id.button_add);
        readdata = (Button) findViewById(R.id.button_read);
        deletedata = (Button) findViewById(R.id.button_delete);
        updatedata = (Button) findViewById(R.id.button_update);

        adddata.setOnClickListener(this);
        readdata.setOnClickListener(this);
        deletedata.setOnClickListener(this);
        updatedata.setOnClickListener(this);

    }
    public void onClick(View v){
        int id = v.getId();

        switch (id){
            case R.id.button_add:{
                Intent intent =new Intent(MainActivity.this,ADDdataAct.class);
                startActivityForResult(intent,101);
                //startActivity(intent);
                break;
            }
            case R.id.button_read:{
                Intent intent2= new Intent(MainActivity.this,ReaddataAct.class);
                startActivityForResult(intent2,102);
                //startActivity(intent2);
                break;
            }
            case R.id.button_delete:{
                Intent intent3= new Intent(MainActivity.this,DeletedataAct.class);
               startActivityForResult(intent3,103);
              //  startActivity(intent3);
                break;
            }
            case R.id.button_update:{
                Intent intent4  = new Intent(MainActivity.this,UpdatedataAct.class);
                startActivityForResult(intent4,104);
               // startActivity(intent4);
                break;
            }
        }
    }
}



