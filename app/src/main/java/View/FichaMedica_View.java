package View;

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

import course.example.tools.R;

import View.Cadastro.FichaMedicaCadastro;
import course.example.tools.Ficha_Medica_Controller;

import model.Ficha_Medica;

public class FichaMedica_View extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener{

    private ListView listView;
    private EditText editText;
    ArrayAdapter<String> adapter;
    List<Ficha_Medica> fichaMedicaList; // é a classe model
    private List<String> fichaMedicaListNome = new ArrayList<String>();
    private Ficha_Medica_Controller fichaMedicaController;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_layout);

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editTextPesquisar);
        imageView = (ImageView) findViewById(R.id.imgViewAdd);

        fichaMedicaController = new Ficha_Medica_Controller(this);
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
                FichaMedica_View.this.adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }


    @Override
    public void onClick(View view) {

        FichaMedicaCadastro fichaMedica  = new FichaMedicaCadastro(this);
    }

    public void atualizarRegistros() {

        fichaMedicaListNome.clear();

        fichaMedicaList = fichaMedicaController.getAll();

        for (Ficha_Medica fichaMedica : fichaMedicaList)
            fichaMedicaListNome.add(fichaMedica.getNome() + " " + fichaMedica.getRg() + " - CPF: " + fichaMedica.getCpf());

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fichaMedicaListNome);
        listView.setAdapter(adapter);

    }

    public void alertDialog(final Ficha_Medica fichaMedica){

        final CharSequence[] itens = {"editar","deletar"};

        new AlertDialog.Builder(this).setTitle("Detalhes do contato")
                .setItems(itens, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int item) {

                        if (item == 0){
                            //EDITAR

                            FichaMedicaCadastro fichaMedicaCadastro = new FichaMedicaCadastro(FichaMedica_View.this);
                            fichaMedicaCadastro.loadFichaMedica(fichaMedica);

                        }else if (item == 1) {
                            //DELETAR
                            boolean isDeletouComSucesso = fichaMedicaController.delete(fichaMedica.getId());

                            if (isDeletouComSucesso){
                                Toast.makeText(FichaMedica_View.this, "Deletado.", Toast.LENGTH_SHORT).show();
                                atualizarRegistros();

                            }else{
                                Toast.makeText(FichaMedica_View.this, "Erro ao deletar.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        dialogInterface.dismiss();
                    }
                }).show();

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Ficha_Medica fichaMedica = fichaMedicaList.get(i);
        alertDialog(fichaMedica);

    }

}
