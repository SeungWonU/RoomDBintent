package org.techtown.roomdatabaseprac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ADDdataAct extends AppCompatActivity {
    EditText etID2,etName2,etEmail2,etCity2;
    private Button btn_save2;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_a_d_ddata);

        etID2 =(EditText)findViewById(R.id.editID2);
        etName2=(EditText)findViewById(R.id.editName2);
        etEmail2=(EditText)findViewById(R.id.editEmail2);
        etCity2=(EditText)findViewById(R.id.editCity2);
        btn_save2=(Button)findViewById(R.id.btn_add2);

        btn_save2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int uid2 = Integer.parseInt(etID2.getText().toString());
                String name2 = etName2.getText().toString();
                String email2 = etEmail2.getText().toString();
                String city2 = etCity2.getText().toString();


                MyDataList myDataList = new MyDataList();
                myDataList.getId();
                myDataList.setId(uid2);
                myDataList.setName(name2);
                myDataList.setEmail(email2);
                myDataList.setCity(city2);

                MainActivity.myDatabase.myDao().addData(myDataList);
                Toast.makeText(getApplicationContext(),"Data Save",Toast.LENGTH_LONG).show();
                etID2.setText("");
                etName2.setText("");
                etEmail2.setText("");
                etCity2.setText("");
                Intent intent = new Intent();
                setResult(101,intent);
                finish();
            }
        });

    }

}