package com.example.app_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class lista_menu extends AppCompatActivity {
    android.widget.SearchView searchView_;
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

        arrayList.add("seleção de musicas");
        arrayList.add("conversor de moedas");
        for (int num = 2; num <= 6; num++){
            arrayList.add("Item "+ num);
        };

        arrayListCopia = new ArrayList<>(arrayList);

        arrayAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                arrayList
        );

        listView.setAdapter(arrayAdapter);

        searchView_.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                fazerBusca(s);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "clicou" + i, Toast.LENGTH_SHORT).show();
                itemSelecionado(i);
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

    public void itemSelecionado(int itemClicado) {
        switch (itemClicado) {
            case 0:
                Intent i = new Intent(lista_menu.this, menuDeGeneros.class);
                startActivity(i);
                break;
            case 1:
                Intent ii = new Intent(lista_menu.this, converterMoedas.class);
                startActivity(ii);
                break;
            default:
                break;
        }
    }
}
