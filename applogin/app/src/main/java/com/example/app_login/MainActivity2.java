package com.example.app_login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    SearchView searchView_;
    ListView listView;

    ArrayList<String> arrayList = new ArrayList<>();

    ArrayList<String> arrayListCopia;

    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        searchView_ = findViewById(R.id.searchView);
        listView = findViewById(R.id.listView1);
        searchView_.setIconified(false);

        for (int num = 0; num <= 5; num++){
            arrayList.add("Item "+ num);
        }

        arrayListCopia = new ArrayList<>(arrayList);

        arrayAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                arrayList
        );
        listView.setAdapter(arrayAdapter);

        searchView_.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                //forma 1
                //MainActivity3.this.arrayAdapter.getFilter().filter(s);

                //forma 2
                fazerBusca(s);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    private void fazerBusca(String s) {

        arrayList.clear();

        s = s.toLowerCase();

        for(String item: arrayListCopia){
            if(item.toLowerCase().contains(s)){
                arrayList.add(item);
            }
        }
    }
}