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
    private OnPersonClickedListener onPersonClickedListener;

    public PersonAdapter(ArrayList<Person> personArrayList, OnPersonClickedListener onPersonClickedListener) {
        this.personArrayList = personArrayList;
        this.onPersonClickedListener = onPersonClickedListener;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_layout,parent,false);
        return new PersonViewHolder(view,onPersonClickedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = personArrayList.get(position);
        holder.tvFirstname.setText(person.getFirstName());
        holder.tvLastname.setText(person.getLastName());
        holder.tvAge.setText(String.valueOf(person.getAge()));
    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView tvFirstname;
        public TextView tvLastname;
        public TextView tvAge;
        OnPersonClickedListener listener;
        public PersonViewHolder(@NonNull View itemView, OnPersonClickedListener onPersonClickedListener) {
            super(itemView);
            tvFirstname = itemView.findViewById(R.id.tv_firstname);
            tvLastname = itemView.findViewById(R.id.tv_lastname);
            tvAge = itemView.findViewById(R.id.tv_age);
            this.listener = onPersonClickedListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Person person = personArrayList.get(getAdapterPosition());
            listener.onItemClicked(person);
        }
    }

    public interface OnPersonClickedListener{
        void onItemClicked(Person person);
    }

}
