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

import com.example.patricia.cad.R;

import java.util.ArrayList;
import java.util.List;

import view.cadastro.DadosPessoaisCadastro;
import com.example.patricia.cad.DadosPessoais_Controller;
import model.DadosPessoais_model;

public class DadosPessoais_View extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener{

    private ListView listView;
    private EditText editText;
    ArrayAdapter<String> adapter;
    List<DadosPessoais_model> dadospessoaisList; // é a classe model
    private List<String> dadospessoaisListNome = new ArrayList<String>();
    private DadosPessoais_Controller dadosPessoaisController;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_layout);

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editTextPesquisar);
        imageView = (ImageView) findViewById(R.id.imgViewAdd);

        dadosPessoaisController = new DadosPessoais_Controller(this);
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
                DadosPessoais_View.this.adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }


    @Override
    public void onClick(View view) {

        DadosPessoaisCadastro dadosPessoaisCadastro  = new DadosPessoaisCadastro (this);
    }

    public void atualizarRegistros() {

        dadospessoaisListNome.clear();

        dadospessoaisList = dadosPessoaisController.getAll();

        for (DadosPessoais_model dadosPessoaisModel : dadospessoaisList)
            dadospessoaisListNome.add(dadosPessoaisModel.getNome() + " " + dadosPessoaisModel.getRg() + " - CPF: " + dadosPessoaisModel.getCpf());

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dadospessoaisListNome);
        listView.setAdapter(adapter);

    }

    public void alertDialog(final DadosPessoais_model dadosPessoaisModel){

        final CharSequence[] itens = {"editar","deletar"};

        new AlertDialog.Builder(this).setTitle("Detalhes do contato")
                .setItems(itens, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int item) {

                        if (item == 0){
                            //EDITAR

                            DadosPessoaisCadastro dadosPessoaisCadastro = new DadosPessoaisCadastro(DadosPessoais_View.this);
                            dadosPessoaisCadastro.loadDadosPessoais(dadosPessoaisModel);

                        }else if (item == 1) {
                            //DELETAR
                            boolean isDeletouComSucesso = dadosPessoaisController.delete(dadosPessoaisModel.getId());

                            if (isDeletouComSucesso){
                                Toast.makeText(DadosPessoais_View.this, "Deletado.", Toast.LENGTH_SHORT).show();
                                atualizarRegistros();

                            }else{
                                Toast.makeText(DadosPessoais_View.this, "Erro ao deletar.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        dialogInterface.dismiss();
                    }
                }).show();

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        DadosPessoais_model dadosPessoaisModel = dadospessoaisList.get(i);
        alertDialog(dadosPessoaisModel);

    }


}

