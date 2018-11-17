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

import View.Cadastro.GamesCadastro;
import course.example.tools.Games_Controller;
import model.Games_model;
import model.Livros_model;


public class Games_View extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener{

    private ListView listView;
    private EditText editText;
    ArrayAdapter<String> adapter;
    List<Games_model> gamesList;
    private List<String> gamesListNome = new ArrayList<String>();
    private Games_Controller gamesController;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_layout);

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editTextPesquisar);
        imageView = (ImageView) findViewById(R.id.imgViewAdd);

        gamesController = new Games_Controller(this);
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
                Games_View.this.adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }


    @Override
    public void onClick(View view) {

        GamesCadastro gamesCadastro  = new GamesCadastro(this);
    }

    public void atualizarRegistros() {

        gamesListNome.clear();

        gamesList = gamesController.getAll();

        for (Games_model games_model : gamesList)
            gamesListNome.add(games_model.getNomegames() + " " + games_model.getAbreviacao());

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, gamesListNome);
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

                            GamesCadastro gamesCadastro = new GamesCadastro(Games_View.this);
                            gamesCadastro.loadGames(games_model);

                        }else if (item == 1) {
                            //DELETAR
                            boolean isDeletouComSucesso = gamesController.delete(games_model.getId());

                            if (isDeletouComSucesso){
                                Toast.makeText(Games_View.this, "Deletado.", Toast.LENGTH_SHORT).show();
                                atualizarRegistros();

                            }else{
                                Toast.makeText(Games_View.this, "Erro ao deletar.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        dialogInterface.dismiss();
                    }
                }).show();

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Games_model games_model = gamesList.get(i);
        alertDialog(games_model);

    }


}
