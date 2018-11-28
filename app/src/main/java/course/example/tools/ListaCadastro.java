package com.example.patricia.cad;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import view.Genero_View;
import view.Series_View;
import view.Musica_View;
import view.Viagens_View;
import view.Filmes_View;
import view.DadosPessoais_View;
import view.Dispositivos_View;
import view.Games_View;
import view.Livros_View;

public class ListaCadastro extends ListActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, getResources().getStringArray(R.array.cadastro));
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent;

        switch (position) {
            case 0:
                intent = new Intent(ListaCadastro.this, DadosPessoais_View.class);
                startActivity(intent);
                break;

            case 1:
                intent = new Intent(ListaCadastro.this, Series_View.class);
                startActivity(intent);

                break;

            case 2:
                intent = new Intent(ListaCadastro.this, Viagens_View.class);
                startActivity(intent);

                break;

            case 3:
                intent = new Intent(ListaCadastro.this, Dispositivos_View.class);
                startActivity(intent);

                break;

            case 4:
                intent = new Intent(ListaCadastro.this, Musica_View.class);
                startActivity(intent);

                break;

            case 5:
                intent = new Intent(ListaCadastro.this, Filmes_View.class);
                startActivity(intent);

                break;

            case 6:
                intent = new Intent(ListaCadastro.this, Livros_View.class);
                startActivity(intent);

                break;

            case 7:
                intent = new Intent(ListaCadastro.this, Games_View.class);
                startActivity(intent);

                break;

            default:
                finish();
        }
    }

    private void dispararIntent(Intent intent){
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.erro_intent, Toast.LENGTH_SHORT).show();
        }
    }

}