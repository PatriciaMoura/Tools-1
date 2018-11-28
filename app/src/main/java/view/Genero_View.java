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

import com.example.patricia.cad.Genero_Controller;
import com.example.patricia.cad.R;

import java.util.ArrayList;
import java.util.List;

import model.Genero_model;
import view.cadastro.GeneroCadastro;

public class Genero_View extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ListView listView;
    private EditText editText;
    ArrayAdapter<String> adapter;
    List<Genero_model> generoList;
    private List<String> generoListNome = new ArrayList<String>();
    private Genero_Controller generoController;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_layout);

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editTextPesquisar);
        imageView = (ImageView) findViewById(R.id.imgViewAdd);

        generoController = new Genero_Controller(this);
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
                Genero_View.this.adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }


    @Override
    public void onClick(View view) {

        GeneroCadastro generoCadastro = new GeneroCadastro(this);
    }

    public void atualizarRegistros() {

        generoListNome.clear();

        generoList = generoController.getAll();

        for (Genero_model filmes_model : generoList)
            generoListNome.add(filmes_model.getNomegenero() + " " );

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, generoListNome);
        listView.setAdapter(adapter);

    }

    public void alertDialog(final Genero_model genero_model) {

        final CharSequence[] itens = {"editar", "deletar"};

        new AlertDialog.Builder(this).setTitle("Detalhes")
                .setItems(itens, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int item) {

                        if (item == 0) {
                            //EDITAR

                            GeneroCadastro generoCadastro = new GeneroCadastro(Genero_View.this);
                            generoCadastro.loadGenero(genero_model);

                        } else if (item == 1) {
                            //DELETAR
                            boolean isDeletouComSucesso = generoController.delete(genero_model.getId());

                            if (isDeletouComSucesso) {
                                Toast.makeText(Genero_View.this, "Deletado.", Toast.LENGTH_SHORT).show();
                                atualizarRegistros();

                            } else {
                                Toast.makeText(Genero_View.this, "Erro ao deletato.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        dialogInterface.dismiss();
                    }
                }).show();

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Genero_model genero_model = generoList.get(i);
        alertDialog(genero_model);

    }
}
