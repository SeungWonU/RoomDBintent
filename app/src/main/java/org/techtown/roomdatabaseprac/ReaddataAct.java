package org.techtown.roomdatabaseprac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import java.util.List;

public class ReaddataAct extends AppCompatActivity {
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_readdata);

        rv=(RecyclerView)findViewById(R.id.rec);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        getData();
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
