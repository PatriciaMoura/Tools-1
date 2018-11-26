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

import view.cadastro.ViagensCadastro;
import course.example.tools.Viagens_Controller;
import model.Viagens_model;

public class Viagens_View extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener{

        private ListView listView;
        private EditText editText;
        ArrayAdapter<String> adapter;
        List<Viagens_model> viagensList;
        private List<String> viagensListNome = new ArrayList<String>();
        private Viagens_Controller viagensController;
        private ImageView imageView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_consulta_layout);

            listView = (ListView) findViewById(R.id.listView);
            editText = (EditText) findViewById(R.id.editTextPesquisar);
            imageView = (ImageView) findViewById(R.id.imgViewAdd);

            viagensController = new Viagens_Controller(this);
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
                    Viagens_View.this.adapter.getFilter().filter(charSequence);
                }

                @Override
                public void afterTextChanged(Editable editable) {
                }
            });
        }


        @Override
        public void onClick(View view) {

            ViagensCadastro viagensCadastro  = new ViagensCadastro(this);
        }

        public void atualizarRegistros() {

            viagensListNome.clear();

            viagensList = viagensController.getAll();

            for (Viagens_model viagens_model : viagensList)
                viagensListNome.add(viagens_model.getLocal() + " " + viagens_model.getDataida());

            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, viagensListNome);
            listView.setAdapter(adapter);

        }

        public void alertDialog(final Viagens_model viagens_model){

            final CharSequence[] itens = {"editar","deletar"};

            new AlertDialog.Builder(this).setTitle("Detalhes")
                    .setItems(itens, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int item) {

                            if (item == 0){
                                //EDITAR

                                ViagensCadastro viagensCadastro = new ViagensCadastro(Viagens_View.this);
                                viagensCadastro.loadViagens(viagens_model);

                            }else if (item == 1) {
                                //DELETAR
                                boolean isDeletouComSucesso = viagensController.delete(viagens_model.getId());

                                if (isDeletouComSucesso){
                                    Toast.makeText(Viagens_View.this, "Deletado.", Toast.LENGTH_SHORT).show();
                                    atualizarRegistros();

                                }else{
                                    Toast.makeText(Viagens_View.this, "Erro ao deletar.", Toast.LENGTH_SHORT).show();
                                }
                            }
                            dialogInterface.dismiss();
                        }
                    }).show();

        }


        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            Viagens_model viagens_model = viagensList.get(i);
            alertDialog(viagens_model);

        }


    }
