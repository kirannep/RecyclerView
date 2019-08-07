package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private ArrayList<Person> personArrayList;
    private OnPersonClickedListener listener;

    public PersonAdapter(ArrayList<Person> personArrayList, OnPersonClickedListener listener) {
        this.personArrayList = personArrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_layout,parent,false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = personArrayList.get(position);
        holder.bind(person,listener);
        holder.tvFirstname.setText(person.getFirstName());
        holder.tvLastname.setText(person.getLastName());
        holder.tvAge.setText(String.valueOf(person.getAge()));
    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder{
        public TextView tvFirstname;
        public TextView tvLastname;
        public TextView tvAge;
        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFirstname = itemView.findViewById(R.id.tv_firstname);
            tvLastname = itemView.findViewById(R.id.tv_lastname);
            tvAge = itemView.findViewById(R.id.tv_age);
        }

        public void bind(final Person person, final OnPersonClickedListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClicked(person);
                }
            });
        }

    }

    public interface OnPersonClickedListener{
        void onItemClicked(Person person);
    }

}
