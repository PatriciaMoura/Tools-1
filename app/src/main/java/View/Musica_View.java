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

import view.cadastro.MusicaCadastro;
import course.example.tools.Musica_Controller;
import model.Musica_model;

public class Musica_View extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener{

    private ListView listView;
    private EditText editText;
    ArrayAdapter<String> adapter;
    List<Musica_model> musicaList;
    private List<String> musicaListNome = new ArrayList<String>();
    private Musica_Controller musicaController;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_layout);

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editTextPesquisar);
        imageView = (ImageView) findViewById(R.id.imgViewAdd);

        musicaController = new Musica_Controller(this);
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
                Musica_View.this.adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }


    @Override
    public void onClick(View view) {

        MusicaCadastro musicaCadastro  = new MusicaCadastro (this);
    }

    public void atualizarRegistros() {

        musicaListNome.clear();

        musicaList = musicaController.getAll();

        for (Musica_model musica_model : musicaList)
            musicaListNome.add(musica_model.getArtista() + " " + musica_model.getAlbum());

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, musicaListNome);
        listView.setAdapter(adapter);

    }

    public void alertDialog(final Musica_model musica_model){

        final CharSequence[] itens = {"editar","deletar"};

        new AlertDialog.Builder(this).setTitle("Detalhes")
                .setItems(itens, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int item) {

                        if (item == 0){
                            //EDITAR

                            MusicaCadastro musicaCadastro = new MusicaCadastro(Musica_View.this);
                            musicaCadastro.loadMusica(musica_model);

                        }else if (item == 1) {
                            //DELETAR
                            boolean isDeletouComSucesso = musicaController.delete(musica_model.getId());

                            if (isDeletouComSucesso){
                                Toast.makeText(Musica_View.this, "Deletado.", Toast.LENGTH_SHORT).show();
                                atualizarRegistros();

                            }else{
                                Toast.makeText(Musica_View.this, "Erro ao deletar.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        dialogInterface.dismiss();
                    }
                }).show();

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Musica_model musica_model = musicaList.get(i);
        alertDialog(musica_model);

    }


}
