package View.Cadastro;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import model.DateUtil;
import model.Filmes_model;
import course.example.tools.Filmes_Controller;
import View.FilmesView;

import java.util.ArrayList;
import java.util.List;

public class FilmesCadastro implements DialogInterface.OnShowListener, View.OnClickListener, DialogInterface.OnDismissListener{

    private Filmes_Controller filmesController;

    private Filmes_model filmes_model;

    private AlertDialog dialog;
    private EditText editTextNomeFilme, editTextDiretorFilme, editTextDataLancamentoFilme, editTextAtrizPrincipalFilme, editTextAtorPrincipalFilme;
    private EditText editTextClassificacaoFilme, editTextProdutoraFilme, editTextMusicaTema, editTextDuracao, editTextedtGeneroFilme;


    private List<String> listaNomeFilmes = new ArrayList<String>();
    List<FilmesView> listFilmes;


    Context context;

    boolean criadoComSucesso;

    public FilmesCadastro(Context context) {

        //CRIA O CONTEXT
        this.context = context;

        filmesController = new Filmes_Controller(context);

        //CRIA O LAYOUT COMO ALERTDIALOG
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.activity_filme, null);
        builder.setView(view);

        //ATRIBUI AS VARIVEIS AOS ITENS DO LAYOUT
        editTextNomeFilme = (EditText)view.findViewById(R.id.edtNomeFilme);
        editTextDiretorFilme = (EditText) view.findViewById(R.id.edtDiretorFilme);
        editTextDataLancamentoFilme = (EditText) view.findViewById(R.id.edtDataLancamentoFilme);
        editTextAtrizPrincipalFilme = (EditText) view.findViewById(R.id.edtAtrizPrincipalFilme);
        editTextAtorPrincipalFilme = (EditText) view.findViewById(R.id.edtAtorPrincipalFilme);
        editTextClassificacaoFilme = (EditText) view.findViewById(R.id.edtClassificacaoFilme);
        editTextProdutoraFilme = (EditText) view.findViewById(R.id.edtProdutoraFilme);
        editTextedtGeneroFilme = (EditText) view.findViewById(R.id.edtGeneroFilme);
        editTextMusicaTema = (EditText) view.findViewById(R.id.edtMusicaTema);
        editTextDuracao = (EditText) view.findViewById(R.id.edtDuracao);




        //CRIA OS BUTTONS DO ALERTDIALOG
        builder.setPositiveButton("Salvar", null);
        builder.setNegativeButton("Voltar", null);

        dialog = builder.create();
        dialog.setOnShowListener(this);
        dialog.show();
    }



    public void loadFilmes (Filmes_model filmes_model){

        this.filmes_model = filmes_model;

        editTextNomeFilme.setText(filmes_model.getNomefilme());
        editTextDiretorFilme.setText(filmes_model.getDiretorfilme());
        editTextDataLancamentoFilme.setText(DateUtil.dateToString(filmes_model.getDatalancamentofilme()));
        editTextAtrizPrincipalFilme.setText(filmes_model.getAtrizprincipalfilme());
        editTextAtorPrincipalFilme.setText(filmes_model.getAtorprincipalfilme());
        editTextClassificacaoFilme.setText(filmes_model.getClassificacaofilme());
        editTextProdutoraFilme.setText(filmes_model.getProdutorafilme());
        editTextedtGeneroFilme.setText(filmes_model.getGenerofilme());
        editTextMusicaTema.setText(filmes_model.getMusicatema());
        editTextDuracao.setText(filmes_model.getDuracao());

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
            Toast.makeText(context, "Filme Armazenado Com Sucesso.", Toast.LENGTH_SHORT).show();
            ((FilmesView) context).atualizarRegistros();
        }
        else
            Toast.makeText(context, "Não Foi Possivel Armazenar o Filme.", Toast.LENGTH_SHORT).show();

        dialog.dismiss();

    }

    public void insertFilme() {

        //ATRIBUIÇÃO DAS VARIAVEIS PARA STRINGS PARA FACILITAR NA ESTRUTURA DE CONDIÇÃO IF
        String filmeNome = editTextNomeFilme.getText().toString();
        String filmeDiretor = editTextDiretorFilme.getText().toString();
        String filmeDataLancamento= editTextDataLancamentoFilme.getText().toString();
        String filmeAtrizPrincipal = editTextAtrizPrincipalFilme.getText().toString();
        String filmeAtorPrincipal = editTextAtorPrincipalFilme.getText().toString();
        String filmeClassificacao = editTextClassificacaoFilme.getText().toString();
        String filmeProdutora = editTextProdutoraFilme.getText().toString();
        String filmeGenero = editTextedtGeneroFilme.getText().toString();
        String filmeMusicaTema = editTextMusicaTema.getText().toString();
        String filmeDuracao = editTextDuracao.getText().toString();

        //APRESENTA OS ERROS AO DEIXAR ALGUM ATRIBUTO EM BRANCO
        if (filmeNome.length() == 0)
            editTextNomeFilme.setError("Digite o Nome do Filme!");
        if (filmeDiretor.length() == 0)
            editTextDiretorFilme.setError("Digite o Diretor!");
        if (editTextDataLancamentoFilme.length() == 0)
            editTextDataLancamentoFilme.setError("Digite a Data!");
        if (editTextAtrizPrincipalFilme.length() == 0)
            editTextAtrizPrincipalFilme.setError("Digite o Nome da Atriz!");
        if (editTextAtorPrincipalFilme.length() == 0)
            editTextAtorPrincipalFilme.setError("Digite o Nome do Ator!");
        if (editTextClassificacaoFilme.length() == 0)
            editTextClassificacaoFilme.setError("Digite a Classificação do Filme!");
        if (editTextProdutoraFilme.length() == 0)
            editTextProdutoraFilme.setError("Digite a Produtora do Filme!");
        if (editTextedtGeneroFilme.length() == 0)
            editTextedtGeneroFilme.setError("Digite o Gênero!");
        if (editTextMusicaTema.length() == 0)
            editTextMusicaTema.setError("Digite a Música Tema!");
        if (editTextDuracao.length() == 0)
            editTextDuracao.setError("Digite a Duração do Filme!");

        //SE TODOS OS CAMPOS FOREM PREENCHIDOS SERÁ EXECUTADA ESTÁ AÇÃO
        if (filmeNome.length() != 0 && filmeDiretor.length() != 0 && filmeDataLancamento.length() != 0
                && filmeAtrizPrincipal.length() != 0 && filmeAtorPrincipal.length() != 0
                && filmeClassificacao.length() != 0 && filmeProdutora.length() != 0
                && filmeGenero.length() != 0 && filmeMusicaTema.length() != 0
                && filmeDuracao.length() != 0) {

            if (filmes_model == null){

                //CONVERTER PARA O TIPO DE DADOS QUE SERÁ ARMAZENADOS NO BANCO DE DADOS
                int filmeclassificacao = Integer.parseInt(editTextClassificacaoFilme.getText().toString());

                Filmes_model filmes_model = new Filmes_model();
                filmes_model.setNomefilme(filmeNome);
                filmes_model.setDiretorfilme(filmeDiretor);
                filmes_model.setDatalancamentofilme(DateUtil.stringToDate(filmeDataLancamento));
                filmes_model.setAtrizprincipalfilme(filmeAtrizPrincipal);
                filmes_model.setAtorprincipalfilme(filmeAtorPrincipal);
                filmes_model.setClassificacaofilme(filmeClassificacao);
                filmes_model.setProdutorafilme(filmeProdutora);
                filmes_model.setGenerofilme(filmeGenero);
                filmes_model.setMusicatema(filmeMusicaTema);
                filmes_model.setDuracao(filmeDuracao);

                criadoComSucesso = filmesController.insert(filmes_model);
            }else{
                //CONVERTER PARA O TIPO DE DADOS QUE SERÁ ARMAZENADOS NO BANCO DE DADOS
                int filmeclassificacao = Integer.parseInt(editTextClassificacaoFilme.getText().toString());

                filmes_model.setNomefilme(filmeNome);
                filmes_model.setDiretorfilme(filmeDiretor);
                filmes_model.setDatalancamentofilme(DateUtil.stringToDate(filmeDataLancamento));
                filmes_model.setAtrizprincipalfilme(filmeAtrizPrincipal);
                filmes_model.setAtorprincipalfilme(filmeAtorPrincipal);
                filmes_model.setClassificacaofilme(filmeClassificacao);
                filmes_model.setProdutorafilme(filmeProdutora);
                filmes_model.setGenerofilme(filmeGenero);
                filmes_model.setMusicatema(filmeMusicaTema);
                filmes_model.setDuracao(filmeDuracao);

                filmesController.edit(filmes_model, filmes_model.getId());
                criadoComSucesso = true;
            }
        }
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        filmesController.closeDb();
    }


}
