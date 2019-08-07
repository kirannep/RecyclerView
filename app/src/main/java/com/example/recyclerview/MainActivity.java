package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    private RecyclerView recyclerView_list;
    private ArrayList<Person> personList;
    private RecyclerView recyclerView;
    private PersonAdapter personAdapter;
    public static final String TAG = "MainActivity";

    private ArrayList<Person> generateData(){
        personList = new ArrayList<>();
        for(int i = 0;i<30;i++){
            Person person = new Person("firstname"+i,"lastname"+i,i);
            personList.add(person);
        }
        //Log.i(TAG, "firstname: "+personList.get(3).getFirstName());
        return personList;
    }

    //below method calls generateData and gets personList
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateData();
        recyclerView = findViewById(R.id.recyclerview_list);
        personAdapter = new PersonAdapter(personList, new PersonAdapter.OnPersonClickedListener() {
            @Override
            public void onItemClicked(Person person) {
                Toast.makeText(MainActivity.this,"firstname"+person.getFirstName(),Toast.LENGTH_SHORT).show();
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(personAdapter);
    }



}
