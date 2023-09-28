package com.example.app_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText emailT, senhaT;
    Button enviar;
    TextView criaU, esqueciS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enviar = findViewById(R.id.enviarL);
        criaU = findViewById(R.id.criaUL);
        esqueciS = findViewById(R.id.esqueciSL);
        emailT = findViewById(R.id.emialL);
        senhaT = findViewById(R.id.senhaL);

        enviar.setOnClickListener(this);
        criaU.setOnClickListener(this);
        esqueciS.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String email = emailT.getText().toString();
        String senha = senhaT.getText().toString();

        if(email.equals("") && senha.equals("")) {
            emailT.setError("Campo vazio");
            senhaT.setError("Campo vazio");
        } else if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailT.setError("Email não valido");
        } else if(senha.equals("")){
            senhaT.setError("Campo vazio");
        }else if(email.equals("")){
            emailT.setError("Campo vazio");
        }else{
            Log.e("Email: ", email);
            Log.e("senha: ", senha);

            Toast.makeText(getApplicationContext(), "Usuário Logado", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            i.putExtra("email_user", email);
            startActivity(i);
        }
    }
}