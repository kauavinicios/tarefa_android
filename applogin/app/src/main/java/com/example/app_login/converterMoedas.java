package com.example.app_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

public class converterMoedas extends AppCompatActivity {

    ArrayList<EditText> moedas = new ArrayList<>();
    ArrayList<Double> taxaReal = new ArrayList<>();
    ArrayList<Double> taxaEuro = new ArrayList<>();
    ArrayList<Double> taxaDolar = new ArrayList<>();
    ArrayList<Double> taxaIene = new ArrayList<>();
    ArrayList<Double> taxaParaguaio = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_moedas);
        taxaReal.add( 0, 5.06);// dolar
        taxaReal.add(1, 5.31);// euro
        taxaReal.add(2, 0.04);// iene
        taxaReal.add(3, 0.00);// paraguaio

        taxaEuro.add( 0, 1.04);// dolar
        taxaEuro.add(1, 134.45);// iene
        taxaEuro.add(2, 6868.20);// paraguaio
        taxaEuro.add(3, 5.3109);// real

        taxaDolar.add( 0, 0.95);// euro
        taxaDolar.add(1, 123.11);// iene
        taxaDolar.add(2, 6815.90);// paraguaio
        taxaDolar.add(3, 5.06);// real

        taxaIene.add( 0, 0.0095);// dolar
        taxaIene.add(1, 0.0075);// euro
        taxaIene.add(2, 0.0014);// paraguaio
        taxaIene.add(3, 0.0007);// real

        taxaParaguaio.add( 0, 0.00014);// dolar
        taxaParaguaio.add(1, 0.00008);// euro
        taxaParaguaio.add(2, 0.00001);// iene
        taxaParaguaio.add(3, 0.00007);// real

        moedas.add(0 ,findViewById(R.id.dolarL));
        moedas.add(1, findViewById(R.id.euroL));
        moedas.add(2, findViewById(R.id.ieneL));
        moedas.add(3, findViewById(R.id.paraguaioL));
        moedas.add(4, findViewById(R.id.realL));

        for (int i = 0; i < moedas.size(); i++) {
            final EditText moeda = moedas.get(i);
            final int posicaoMoeda = i;

            moeda.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

                @Override
                public void afterTextChanged(Editable editable) {
                    if (!editable.toString().isEmpty()) {
                        double valor = Double.parseDouble(String.valueOf(moeda.getText()));
                        switch (posicaoMoeda) {
                            case 0:
                                converterMoedas(posicaoMoeda, taxaDolar);
                                Log.e("Moeda", "dolarL " + editable);
                                break;
                            case 1:
                                converterMoedas(posicaoMoeda, taxaEuro);
                                Log.e("Moeda", "euroL " + valor);
                                break;
                            case 2:
                                converterMoedas(posicaoMoeda, taxaIene);
                                Log.e("Moeda", "ieneL " + valor);
                                break;
                            case 3:
                                converterMoedas(posicaoMoeda, taxaParaguaio);
                                Log.e("Moeda", "paraguaioL " + valor);
                                break;
                            case 4:
                                Log.e("Switch", ""+posicaoMoeda);
                                converterMoedas(posicaoMoeda, taxaReal);
                                Log.e("Moeda", "realL " + valor);
                                break;
                        }
                    }else {
                        // Se o campo estiver vazio, limpe os outros campos
                        // Implemente a lógica para limpar os campos EditText
                        Log.e("Moeda", "não foi dessa vez");
                    }
                }
            });
        }


        Button btnLimpar = findViewById(R.id.btnLimpar);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Limpar todos os campos
                for (EditText campo : moedas) {
                    campo.setText("");
                }
            }
        });
    }

    public void converterMoedas(int posicao, ArrayList<Double> taxa){
        double valor = Double.parseDouble(moedas.get(posicao).getText().toString());
        int cont = 0;
        EditText moeda;

        for (int i = 0; i < moedas.size(); i++) {
            moeda = moedas.get(i);
            if (i != posicao) {
                double taxaDeCambio = taxa.get(cont);
                double valorConvertido = valor * taxaDeCambio;

                Log.e("valor convertido: ", ""+valorConvertido);
                Log.e("teste", moedas.get(i).getText().toString());
                moeda.setText(String.valueOf(valorConvertido));
                cont++;
            }
        }
    }

}
