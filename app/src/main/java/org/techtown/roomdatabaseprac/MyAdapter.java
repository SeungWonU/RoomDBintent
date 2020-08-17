package org.techtown.roomdatabaseprac;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    List<MyDataList>myDataLists;

    public MyAdapter(List<MyDataList>myDataLists)
    {
        this.myDataLists = myDataLists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_data,viewGroup,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i){
        MyDataList md = myDataLists.get(i);

        viewHolder.txtId.setText(String.valueOf(md.getId()));
        viewHolder.txtName.setText(md.getName());
        viewHolder.txtEmail.setText(md.getEmail());
        viewHolder.txtCity.setText(md.getCity());

    }

    public int getItemCount()
    {
        return myDataLists.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtId,txtName,txtEmail,txtCity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtId=(TextView)itemView.findViewById(R.id.txt_idd);
            txtName = (TextView)itemView.findViewById(R.id.txtname);
            txtEmail =(TextView)itemView.findViewById(R.id.txtemail);
            txtCity=(TextView)itemView.findViewById(R.id.txtcity);
        }
    }
}
