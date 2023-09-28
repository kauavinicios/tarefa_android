package com.example.app_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    SearchView searchView_;
    ListView listView;

    ArrayList<Banda> arrayList = new ArrayList<Banda>();
    ArrayList<Banda> arrayListCopia;
    ArrayList<String> estiloArray;
    ArrayAdapter<Banda> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent intent = getIntent();
        estiloArray = (ArrayList<String>) intent.getSerializableExtra("selecionados");

        searchView_ = findViewById(R.id.searchView);
        listView = findViewById(R.id.listView1);

        searchView_.setIconified(false);

        arrayList.add(new Banda("The Thrill Is Gone", "Blues"));
        arrayList.add(new Banda("Me And The Devil Blues", "Blues"));
        arrayList.add(new Banda("Boogie Chillen", "Blues"));
        arrayList.add(new Banda("Stone Crazy", "Blues"));
        arrayList.add(new Banda("I'd Rather Go Blind", "Blues"));
        arrayList.add(new Banda("I Love Rock 'N Roll", "Rock"));
        arrayList.add(new Banda("Born to Run", "Rock"));
        arrayList.add(new Banda("Purple Haze", "Rock"));
        arrayList.add(new Banda("Freebird", "Rock"));
        arrayList.add(new Banda("Stairway to Heaven", "Rock"));
        arrayList.add(new Banda("Slime You Out", "Pop"));
        arrayList.add(new Banda("Paint The Town Red", "Pop"));
        arrayList.add(new Banda("Snooze", "Pop"));
        arrayList.add(new Banda("Fukumean", "Pop"));
        arrayList.add(new Banda("Barbie World", "Pop"));
        arrayList.add(new Banda("The Kind Of Love We Make", "Country"));
        arrayList.add(new Banda("Something In The Orange", "Country"));
        arrayList.add(new Banda("The Four Seasons", "Clássica"));
        arrayList.add(new Banda("Requiem", "Clássica"));
        arrayList.add(new Banda("Für Elise", "Clássica"));
        arrayList.add(new Banda("Carmen", "Clássica"));
        arrayList.add(new Banda("Symphony No. 5", "Clássica"));
        arrayList.add(new Banda("Paint The Town Red", "Hip Hop"));
        arrayList.add(new Banda("Snooze", "Hip Hop"));
        arrayList.add(new Banda("Fukumean", "Hip Hop"));
        arrayList.add(new Banda("Bongos", "Hip Hop"));
        arrayList.add(new Banda("Barbie World", "Hip Hop"));


        arrayListCopia = new ArrayList<>(arrayList);

        arrayAdapter = new ArrayAdapter<Banda>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                arrayList
        );
        listView.setAdapter(arrayAdapter);

        //filtrando a lista conforme estilo informado na tela 1.
        fazerBuscaDeBandas();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

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

        for(Banda item: arrayListCopia){
            if(item.toString().toLowerCase().contains(s)){
                arrayList.add(item);
            }
        }
    }

    private void fazerBuscaDeBandas() {

        arrayList.clear();

        for(String estilo: estiloArray){
            for(Banda item: arrayListCopia){
                if(item.getEstilo().equalsIgnoreCase(estilo)){
                    arrayList.add(item);
                }
            }
        }
        arrayAdapter.notifyDataSetChanged();
    }
}