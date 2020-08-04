package org.techtown.roomdatabaseprac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddDataActivity  extends AppCompatActivity {
EditText etID,etName,etEmail,etCity;
private Button btn_save;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_add_data);

        etID =(EditText)findViewById(R.id.editID);
        etName=(EditText)findViewById(R.id.editName);
        etEmail=(EditText)findViewById(R.id.editEmail);
        etCity=(EditText)findViewById(R.id.editCity);
        btn_save=(Button)findViewById(R.id.btn_add);

        Intent intent = getIntent();
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int uid = Integer.parseInt(etID.getText().toString());
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String city  = etCity.getText().toString();

                MyDataList myDataList = new MyDataList();
                myDataList.setId(uid);
                myDataList.setName(name);
                myDataList.setEmail(email);
                myDataList.setCity(city);

                MainActivity.myDatabase.myDao().addData(myDataList);
                Toast.makeText(getApplicationContext(),"Data Save",Toast.LENGTH_LONG).show();
                etID.setText("");
                etName.setText("");
                etEmail.setText("");
                etCity.setText("");
            }
        });

    }
}
