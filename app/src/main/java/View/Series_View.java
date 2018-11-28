package view;

/**
 * Created by Patricia on 23/11/2018.
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

import java.util.ArrayList;
import java.util.List;

import view.cadastro.SeriesCadastro;

import com.example.patricia.cad.R;
import com.example.patricia.cad.Series_Controller;
import model.Series_model;

public class Series_View extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener{

    private ListView listView;
    private EditText editText;
    ArrayAdapter<String> adapter;
    List<Series_model> seriesList;
    private List<String> seriesListNome = new ArrayList<String>();
    private Series_Controller seriesController;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_layout);

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editTextPesquisar);
        imageView = (ImageView) findViewById(R.id.imgViewAdd);

        seriesController = new Series_Controller(this);
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
                Series_View.this.adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }


    @Override
    public void onClick(View view) {

        SeriesCadastro seriesCadastro  = new SeriesCadastro(this);
    }

    public void atualizarRegistros() {

        seriesListNome.clear();

        seriesList = seriesController.getAll();

        for (Series_model series_model : seriesList)
            seriesListNome.add(series_model.getNomeserie() + " " + series_model.getProdutoraserie());

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, seriesListNome);
        listView.setAdapter(adapter);

    }

    public void alertDialog(final Series_model series_model){

        final CharSequence[] itens = {"editar","deletar"};

        new AlertDialog.Builder(this).setTitle("Detalhes do contato")
                .setItems(itens, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int item) {

                        if (item == 0){
                            //EDITAR

                            SeriesCadastro seriesCadastro = new SeriesCadastro(Series_View.this);
                            seriesCadastro.loadSeries(series_model);

                        }else if (item == 1) {
                            //DELETAR
                            boolean isDeletouComSucesso = seriesController.delete(series_model.getId());

                            if (isDeletouComSucesso){
                                Toast.makeText(Series_View.this, "Deletado.", Toast.LENGTH_SHORT).show();
                                atualizarRegistros();

                            }else{
                                Toast.makeText(Series_View.this, "Erro ao deletar.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        dialogInterface.dismiss();
                    }
                }).show();

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Series_model series_model = seriesList.get(i);
        alertDialog(series_model);

    }


}

