package view;

/**
 * Created by Patricia on 01/12/2018.
 */

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

import com.example.patricia.cad.TipoSangue_Controller;
import com.example.patricia.cad.R;

import java.util.ArrayList;
import java.util.List;

import model.TipoSangue_model;
import view.cadastro.TipoSangueCadastro;

public class TipoSangue_View extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ListView listView;
    private EditText editText;
    ArrayAdapter<String> adapter;
    List<TipoSangue_model> tiposanguineoList;
    private List<String> tiposanguineoListNome = new ArrayList<String>();
    private TipoSangue_Controller tiposanguineoController;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_layout);

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editTextPesquisar);
        imageView = (ImageView) findViewById(R.id.imgViewAdd);

        tiposanguineoController = new TipoSangue_Controller(this);
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
                TipoSangue_View.this.adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }


    @Override
    public void onClick(View view) {

        TipoSangueCadastro tipoSangueCadastro = new TipoSangueCadastro(this);
    }

    public void atualizarRegistros() {

        tiposanguineoListNome.clear();

        tiposanguineoList = tiposanguineoController.getAll();

        for (TipoSangue_model dadosPessoaisModel : tiposanguineoList)
            tiposanguineoListNome.add(dadosPessoaisModel.getTiposanguineo() + " " );

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tiposanguineoListNome);
        listView.setAdapter(adapter);

    }

    public void alertDialog(final TipoSangue_model tipoSangue_model) {

        final CharSequence[] itens = {"editar", "deletar"};

        new AlertDialog.Builder(this).setTitle("Detalhes")
                .setItems(itens, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int item) {

                        if (item == 0) {
                            //EDITAR

                            TipoSangueCadastro tipoSangueCadastro = new TipoSangueCadastro(TipoSangue_View.this);
                            tipoSangueCadastro.loadTipoSangue(tipoSangue_model);

                        } else if (item == 1) {
                            //DELETAR
                            boolean isDeletouComSucesso = tiposanguineoController.delete(tipoSangue_model.getId());

                            if (isDeletouComSucesso) {
                                Toast.makeText(TipoSangue_View.this, "Deletado.", Toast.LENGTH_SHORT).show();
                                atualizarRegistros();

                            } else {
                                Toast.makeText(TipoSangue_View.this, "Erro ao deletato.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        dialogInterface.dismiss();
                    }
                }).show();

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        TipoSangue_model tipoSangue_model = tiposanguineoList.get(i);
        alertDialog(tipoSangue_model);

    }
}

