package com.example.pc.roomlivedata;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pc on 8/22/2018.
 */

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.MyViewHolder> {

    public Context context;
    public List<UserDetail> userDetails;


    public MainActivityAdapter(MainActivity mainActivity) {

        this.context=mainActivity;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.text1.setText(userDetails.get(position).getUserName());
    }

    @Override
    public int getItemCount() {

        if(userDetails.size()>0)
        {
            return userDetails.size();
        }else {
            return 0;
        }
    }

    public void setUser(List<UserDetail> userDetails) {

        this.userDetails=userDetails;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        public TextView text1;
        public MyViewHolder(View itemView) {
            super(itemView);

            text1=itemView.findViewById(R.id.text1);
        }
    }
}
