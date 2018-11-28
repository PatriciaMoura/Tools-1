package com.example.patricia.cad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import view.DadosPessoais_View;
import view.cadastro.DadosPessoaisCadastro;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

    Intent intent;
    Button btnEspecificacoes, btnCadastro, btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastro = (Button) findViewById(R.id.btnCadastro);
        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaCadastro.class);
                startActivity(intent);
            }
        });


        btnEspecificacoes = (Button) findViewById(R.id.btnEspecificacoes);
        btnEspecificacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaEspCadastro.class);
                startActivity(intent);
            }
        });
        /*btnCadastro.setOnClickListener(this);*/
/*        btnCalculos = (Button) findViewById(R.id.btnCalculos);
        btnCalculos.setOnClickListener(this);*/
    }

    /*@Override
    public void onClick(View view) {

        switch (view.getId()){

*//*            case R.id.btnCalculos:
                intent = new Intent(MainActivity.this, ListaCalculos.class);
                startActivity(intent);
                break;*//*

            case R.id.btnCadastro:
                Intent intent = new Intent(MainActivity.this, ListaCadastro.class);
                startActivity(intent);
                break;

            default:
                finish();
        }
    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
