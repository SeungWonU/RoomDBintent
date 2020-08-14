package org.techtown.roomdatabaseprac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class ReaddataAct extends AppCompatActivity {
    private RecyclerView rv;
    private Button button;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_readdata);

        rv=(RecyclerView)findViewById(R.id.rec);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        getData();
        button = (Button)findViewById(R.id.goMenu);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent();
                setResult(102,intent2);
                finish();
            }
        });
    }
    private void getData(){
        class GetData extends AsyncTask<Void,Void, List<MyDataList>> {

            @Override
            protected List<MyDataList> doInBackground(Void... voids) {
                List<MyDataList>myDataLists = MainActivity.myDatabase.myDao().getMyData();
                return myDataLists;
            }

            @Override
            protected void onPostExecute(List<MyDataList>myDataList){
                MyAdapter adapter = new MyAdapter(myDataList);
                rv.setAdapter(adapter);
                super.onPostExecute(myDataList);

            }
        }
        GetData gd = new GetData();
        gd.execute();
    }
}
