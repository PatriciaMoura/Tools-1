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

import java.util.ArrayList;
import java.util.List;

import view.cadastro.LivrosCadastro;
import course.example.tools.Livro_Controller;
import model.Livros_model;

public class Livros_View extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener{

    private ListView listView;
    private EditText editText;
    ArrayAdapter<String> adapter;
    List<Livros_model> livrosList;
    private List<String> livrosListNome = new ArrayList<String>();
    private Livro_Controller livroController;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_layout);

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editTextPesquisar);
        imageView = (ImageView) findViewById(R.id.imgViewAdd);

        livroController = new Livro_Controller(this);
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
                Livros_View.this.adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }


    @Override
    public void onClick(View view) {

        LivrosCadastro livrosCadastro  = new LivrosCadastro(this);
    }

    public void atualizarRegistros() {

        livrosListNome.clear();

        livrosList = livroController.getAll();

        for (Livros_model livros_model : livrosList)
            livrosListNome.add(livros_model.getTitulo() + " " + livros_model.getAutor());

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, livrosListNome);
        listView.setAdapter(adapter);

    }

    public void alertDialog(final Livros_model livros_model){

        final CharSequence[] itens = {"editar","deletar"};

        new AlertDialog.Builder(this).setTitle("Detalhes")
                .setItems(itens, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int item) {

                        if (item == 0){
                            //EDITAR

                            LivrosCadastro livrosCadastro = new LivrosCadastro(Livros_View.this);
                            livrosCadastro.loadLivros(livros_model);

                        }else if (item == 1) {
                            //DELETAR
                            boolean isDeletouComSucesso = livroController.delete(livros_model.getId());

                            if (isDeletouComSucesso){
                                Toast.makeText(Livros_View.this, "Deletado.", Toast.LENGTH_SHORT).show();
                                atualizarRegistros();

                            }else{
                                Toast.makeText(Livros_View.this, "Erro ao deletar.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        dialogInterface.dismiss();
                    }
                }).show();

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Livros_model livros_model = livrosList.get(i);
        alertDialog(livros_model);

    }


}
