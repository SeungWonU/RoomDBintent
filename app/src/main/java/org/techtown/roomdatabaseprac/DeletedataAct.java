package org.techtown.roomdatabaseprac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeletedataAct extends AppCompatActivity {


    EditText etText2;
    Button deleteBtn2;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_deletedata);

        etText2 = findViewById(R.id.etText2);
        deleteBtn2 = findViewById(R.id.deleteButton2);

        deleteBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = etText2.getText().toString();

                int id = Integer.parseInt(data);
                MainActivity.myDatabase.myDao().deleteitem(id);
                Toast.makeText(getApplicationContext(),"Data Delete!!",Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                setResult(103,intent);
                finish();
            }
        });
    }

}