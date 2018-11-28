package view.cadastro;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.patricia.cad.Genero_Controller;
import com.example.patricia.cad.R;

import java.util.ArrayList;
import java.util.List;

import model.Genero_model;
import view.Genero_View;

public class GeneroCadastro implements DialogInterface.OnShowListener, View.OnClickListener, DialogInterface.OnDismissListener {

    private Genero_Controller generoController;

    private Genero_model genero_model;

    private AlertDialog dialog;
    private EditText editTextNomeGenero;

    private List<String> listaNomeFilmes = new ArrayList<String>();
    List<Genero_View> listFilmes;


    Context context;

    boolean criadoComSucesso;

    public GeneroCadastro(Context context) {

        //CRIA O CONTEXT
        this.context = context;

        generoController = new Genero_Controller(context);

        //CRIA O LAYOUT COMO ALERTDIALOG
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.activity_genero, null);
        builder.setView(view);

        //ATRIBUI AS VARIVEIS AOS ITENS DO LAYOUT
        editTextNomeGenero = (EditText)view.findViewById(R.id.edtNomeGenero);





        //CRIA OS BUTTONS DO ALERTDIALOG
        builder.setPositiveButton("Salvar", null);
        builder.setNegativeButton("Voltar", null);

        dialog = builder.create();
        dialog.setOnShowListener(this);
        dialog.show();
    }



    public void loadGenero (Genero_model genero_model){

        this.genero_model = genero_model;

        editTextNomeGenero.setText(genero_model.getNomegenero());


    }

    @Override
    public void onShow(DialogInterface d){
        Button b = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        b.setId(DialogInterface.BUTTON_POSITIVE);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        insertFilme();

        if (criadoComSucesso) {
            Toast.makeText(context, "Genero Armazenado Com Sucesso.", Toast.LENGTH_SHORT).show();
            ((Genero_View) context).atualizarRegistros();
        }
        else
            Toast.makeText(context, "Não Foi Possivel Armazenar o Genero.", Toast.LENGTH_SHORT).show();

        dialog.dismiss();

    }

    public void insertFilme() {

        //ATRIBUIÇÃO DAS VARIAVEIS PARA STRINGS PARA FACILITAR NA ESTRUTURA DE CONDIÇÃO IF
        String generoNome = editTextNomeGenero.getText().toString();


        //APRESENTA OS ERROS AO DEIXAR ALGUM ATRIBUTO EM BRANCO
        if (generoNome.length() == 0)
            editTextNomeGenero.setError("Digite o Nome do Filme!");


        //SE TODOS OS CAMPOS FOREM PREENCHIDOS SERÁ EXECUTADA ESTA AÇÃO
        if (generoNome.length() != 0 ) {

            if (genero_model == null){

                //CONVERTER PARA O TIPO DE DADOS QUE SERÁ ARMAZENADOS NO BANCO DE DADOS


                Genero_model filmes_model = new Genero_model();
                filmes_model.setNomegenero(generoNome);

                criadoComSucesso = generoController.insert(filmes_model);
            }else{
                //CONVERTER PARA O TIPO DE DADOS QUE SERÁ ARMAZENADOS NO BANCO DE DADOS

                genero_model.setNomegenero(generoNome);

                generoController.edit(genero_model, genero_model.getId());
                criadoComSucesso = true;
            }
        }
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        generoController.closeDb();
    }
}
