package org.techtown.roomdatabaseprac;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateDataActivity extends AppCompatActivity {
    private EditText etid,etName,etEmail,etCity;
    private Button update_btn;

    protected  void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_update_data);

        etid = (EditText)findViewById(R.id.uet_id);
        etName=(EditText)findViewById(R.id.uet_name);
        etEmail = (EditText)findViewById(R.id.uet_email);
        etCity = (EditText)findViewById(R.id.uet_city);
        update_btn = findViewById(R.id.button_update);

        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(etid.getText().toString());
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String city = etCity.getText().toString();

                MyDataList md = new MyDataList();
                md.setId(id);
                md.setName(name);
                md.setEmail(email);
                md.setCity(city);
                MainActivity.myDatabase.myDao().update(md);
                Toast.makeText(getApplicationContext(),"Data Update!",Toast.LENGTH_LONG).show();
                etid.setText("");
                etName.setText("");
                etEmail.setText("");
                etCity.setText("");
            }
        });
    }
}
