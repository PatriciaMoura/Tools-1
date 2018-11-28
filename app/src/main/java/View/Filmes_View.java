package view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import view.cadastro.FilmesCadastro;
import com.example.patricia.cad.Filmes_Controller;
import com.example.patricia.cad.R;

import model.Filmes_model;


import java.util.ArrayList;
import java.util.List;

public class Filmes_View extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ListView listView;
    private EditText editText;
    ArrayAdapter<String> adapter;
    List<Filmes_model> filmesList;
    private List<String> filmesListNome = new ArrayList<String>();
    private Filmes_Controller filmesController;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_layout);

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editTextPesquisar);
        imageView = (ImageView) findViewById(R.id.imgViewAdd);

        filmesController = new Filmes_Controller(this);
        listView.setOnItemClickListener(this);

        imageView.setOnClickListener(this);
        atualizarRegistros();

        //Filtrar a busca no banco
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Filmes_View.this.adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }


    @Override
    public void onClick(View view) {

        FilmesCadastro filmesCadastro = new FilmesCadastro(this);
    }

    public void atualizarRegistros() {

        filmesListNome.clear();

        filmesList = filmesController.getAll();

        for (Filmes_model filmes_model : filmesList)
            filmesListNome.add(filmes_model.getNomefilme() + " " + filmes_model.getDiretorfilme());

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, filmesListNome);
        listView.setAdapter(adapter);

    }

    public void alertDialog(final Filmes_model filmes_model) {

        final CharSequence[] itens = {"editar", "deletar"};

        new AlertDialog.Builder(this).setTitle("Detalhes")
                .setItems(itens, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int item) {

                        if (item == 0) {
                            //EDITAR

                            FilmesCadastro filmesCadastro = new FilmesCadastro(Filmes_View.this);
                            filmesCadastro.loadFilmes(filmes_model);

                        } else if (item == 1) {
                            //DELETAR
                            boolean isDeletouComSucesso = filmesController.delete(filmes_model.getId());

                            if (isDeletouComSucesso) {
                                Toast.makeText(Filmes_View.this, "Deletado.", Toast.LENGTH_SHORT).show();
                                atualizarRegistros();

                            } else {
                                Toast.makeText(Filmes_View.this, "Erro ao deletato.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        dialogInterface.dismiss();
                    }
                }).show();

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Filmes_model filmes_model = filmesList.get(i);
        alertDialog(filmes_model);

    }

}
