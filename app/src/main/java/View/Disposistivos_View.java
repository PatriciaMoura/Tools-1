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

import view.cadastro.DispositivosCadastro;
import course.example.tools.Dispositivos_Controller;
import model.Dispositivos_model;


public class Disposistivos_View extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener{

    private ListView listView;
    private EditText editText;
    ArrayAdapter<String> adapter;
    List<Dispositivos_model> dispositivosList;
    private List<String> dispositvosListNome = new ArrayList<String>();
    private Dispositivos_Controller dispositivosController;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_layout);

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editTextPesquisar);
        imageView = (ImageView) findViewById(R.id.imgViewAdd);

        dispositivosController = new Dispositivos_Controller(this);
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
                Disposistivos_View.this.adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }


    @Override
    public void onClick(View view) {

        DispositivosCadastro dispositivosCadastro  = new DispositivosCadastro(this);
    }

    public void atualizarRegistros() {

        dispositvosListNome.clear();

        dispositivosList = dispositivosController.getAll();

        for (Dispositivos_model dispositivos_model : dispositivosList)
            dispositvosListNome.add(dispositivos_model.getDispositivo() + " " + dispositivos_model.getMarca());

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dispositvosListNome);
        listView.setAdapter(adapter);

    }

    public void alertDialog(final Dispositivos_model dispositivos_model){

        final CharSequence[] itens = {"editar","deletar"};

        new AlertDialog.Builder(this).setTitle("Detalhes")
                .setItems(itens, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int item) {

                        if (item == 0){
                            //EDITAR

                            DispositivosCadastro dispositivosCadastro = new DispositivosCadastro(Disposistivos_View.this);
                            dispositivosCadastro.loadDispositivos(dispositivos_model);

                        }else if (item == 1) {
                            //DELETAR
                            boolean isDeletouComSucesso = dispositivosController.delete(dispositivos_model.getId());

                            if (isDeletouComSucesso){
                                Toast.makeText(Disposistivos_View.this, "Deletado.", Toast.LENGTH_SHORT).show();
                                atualizarRegistros();

                            }else{
                                Toast.makeText(Disposistivos_View.this, "Erro ao deletar.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        dialogInterface.dismiss();
                    }
                }).show();

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Dispositivos_model dispositivos_model = dispositivosList.get(i);
        alertDialog(dispositivos_model);

    }



}
