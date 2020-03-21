package com.example.daggerexample.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daggerexample.R;
import com.example.daggerexample.data.Person;

import java.util.ArrayList;
import java.util.List;

public class TitleViewAdapter extends RecyclerView.Adapter< TitleViewAdapter.TitleRecyclerViewHolder> {

    private Context context;
    private List<Person> list = new ArrayList<>();
    private OnItemTouchedListener listener;

    public  TitleViewAdapter(Context context,  List<Person> list, OnItemTouchedListener listener){
        this.context = context;
        this.list = list;
        this.listener = listener;
    }


    @Override
    public TitleRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler_view, parent, false);
        return new TitleRecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TitleRecyclerViewHolder holder, final int position) {

        Person person = list.get(position);

        holder.nameTextView.setText(person.getName());
        holder.descriptionTextView.setText(person.getDescription());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onitemClicked(position);
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class TitleRecyclerViewHolder extends RecyclerView.ViewHolder{

        private TextView nameTextView;
        private TextView descriptionTextView;
        private CardView cardView;



        public TitleRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.titleTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }

    public interface OnItemTouchedListener{
        void onitemClicked(int position);
    }
}
