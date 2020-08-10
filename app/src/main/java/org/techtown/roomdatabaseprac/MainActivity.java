package org.techtown.roomdatabaseprac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
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

        adddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,ADDdataAct.class);
                startActivityForResult(intent,101);
            }
        });
        readdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent(MainActivity.this,ReaddataAct.class);
               // startActivityForResult(intent2,102);
            startActivity(intent2);
            }
        });
    deletedata.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent3= new Intent(MainActivity.this,DeletedataAct.class);
            startActivityForResult(intent3,103);
        }
    });
        updatedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4  = new Intent(MainActivity.this,UpdatedataAct.class);
                startActivityForResult(intent4,104);


            }
        });
    }

}



