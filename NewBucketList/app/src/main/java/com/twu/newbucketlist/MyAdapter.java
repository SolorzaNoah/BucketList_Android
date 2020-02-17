package com.twu.newbucketlist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String data2[];
    LinkedList<String> data1;
    LinkedList<Boolean> images;
    Context context;

//    private static ClickListener clickListener;

    public MyAdapter(Context ct, LinkedList<String> s1, String[] s2, LinkedList<Boolean> images){
        context = ct;
        data1 = s1;
        data2 = s2;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.myText1.setText(data1.get(position));
        holder.myText2.setText(data2[position]);
        //holder.myImage.setChecked(images.get(position));

        holder.mainLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,SecondActivity.class);
                intent.putExtra("data1", data1.get(position));
                intent.putExtra("data2", data2[position]);
                intent.putExtra("myImage", images.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myText1, myText2;
        CheckBox myImage;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.myText1);
            myText2 = itemView.findViewById(R.id.myText2);
            myImage = itemView.findViewById(R.id.checkBox);
            mainLayout =  itemView.findViewById(R.id.mainLayout);
        }
    }

}