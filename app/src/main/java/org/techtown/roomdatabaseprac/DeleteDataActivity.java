package org.techtown.roomdatabaseprac;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteDataActivity extends AppCompatActivity {
EditText etText;
Button deleteBtn;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_delete_data);

        etText = findViewById(R.id.etText);
        deleteBtn = findViewById(R.id.button_delete);

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = etText.getText().toString();
                int id = Integer.parseInt(data);
                MainActivity.myDatabase.myDao().deleteitem(id);
            }
        });
    }

}
