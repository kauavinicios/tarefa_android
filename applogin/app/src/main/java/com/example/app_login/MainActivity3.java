package com.example.app_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    Button enviar;
    ChipGroup genGrup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        enviar  = findViewById(R.id.enviarL);
        genGrup  = findViewById(R.id.genGrupL);

        enviar.setOnClickListener(view -> {
            //recuperando itens selecionados em um grupo
            List<Integer> ids = genGrup.getCheckedChipIds();
            ArrayList<String> arrayList = new ArrayList<>();

            for (Integer id:ids){
                Log.e("id:", ""+id);
                Chip chip = genGrup.findViewById(id);
                String estilo = chip.getText().toString();
                arrayList.add(estilo);
            }
            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
            intent.putExtra("selecionados", arrayList);
            startActivity(intent);
        });
    }
}