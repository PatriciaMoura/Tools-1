package view.cadastro;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import view.Games_View;
import model.DateUtil;

import java.util.ArrayList;
import java.util.List;

import model.Games_model;
import course.example.tools.Games_Controller;

public class GamesCadastro implements DialogInterface.OnShowListener, View.OnClickListener, DialogInterface.OnDismissListener{

    private Games_Controller gamesController;

    private Games_model games_model;

    private AlertDialog dialog;
    private EditText editTextNomeGame, editTextAbreviacao, editTextGeneroGames, editTextDataGame, editTextModoJogo;
    private EditText editTextPublicadora, editTextDesenvolvedora, editTextQuantLancada, editTextPlataforma, editTextMelhorFranquia;


    private List<String> listaGames = new ArrayList<String>();
    List<View.Viagens_View> listGames;


    Context context;

    boolean criadoComSucesso;

    public GamesCadastro(Context context) {

        //CRIA O CONTEXT
        this.context = context;

        gamesController = new Games_Controller(context);

        //CRIA O LAYOUT COMO ALERTDIALOG
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.activity_games, null);
        builder.setView(view);

        //ATRIBUI AS VARIVEIS AOS ITENS DO LAYOUT
        editTextNomeGame = (EditText)view.findViewById(R.id.edtNomeGame);
        editTextAbreviacao = (EditText) view.findViewById(R.id.edtAbreviacao);
        editTextGeneroGames = (EditText) view.findViewById(R.id.edtGeneroGames);
        editTextDataGame = (EditText) view.findViewById(R.id.edtDataLancamentoGames);
        editTextModoJogo = (EditText) view.findViewById(R.id.edtModoJogo);
        editTextPublicadora = (EditText) view.findViewById(R.id.edtPublicadora);
        editTextDesenvolvedora = (EditText) view.findViewById(R.id.edtDesenvolvedora);
        editTextQuantLancada = (EditText) view.findViewById(R.id.edtQuantLancadaGames);
        editTextPlataforma = (EditText) view.findViewById(R.id.edtPlataformas);
        editTextMelhorFranquia = (EditText) view.findViewById(R.id.edtMelhorFranquia);


        //CRIA OS BUTTONS DO ALERTDIALOG
        builder.setPositiveButton("Salvar", null);
        builder.setNegativeButton("Voltar", null);

        dialog = builder.create();
        dialog.setOnShowListener(this);
        dialog.show();
    }

    public void loadGames (Games_model games_model){

        this.games_model = games_model;

        editTextNomeGame.setText(games_model.getNomegames());
        editTextAbreviacao.setText(games_model.getAbreviacao());
        editTextGeneroGames.setText(games_model.getGenerogames());
        editTextDataGame.setText(DateUtil.dateToString(games_model.getDatalancamentogames()));
        editTextModoJogo.setText(games_model.getModojogo());
        editTextPublicadora.setText(games_model.getPublicadora());
        editTextDesenvolvedora.setText(games_model.getDesenvolvedora());
        editTextQuantLancada.setText(games_model.getQuantlancadaGames());
        editTextPlataforma.setText(games_model.getPlataformas());
        editTextMelhorFranquia.setText(games_model.getMelhorfranquia());

    }

    @Override
    public void onShow(DialogInterface d){
        Button b = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        b.setId(DialogInterface.BUTTON_POSITIVE);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        insertGames();

        if (criadoComSucesso) {
            Toast.makeText(context, "Game Armazenado Com Sucesso.", Toast.LENGTH_SHORT).show();
            ((Games_View) context).atualizarRegistros();
        }
        else
            Toast.makeText(context, "Não Foi Possivel Armazenar o Gaame.", Toast.LENGTH_SHORT).show();

        dialog.dismiss();

    }

    public void insertGames() {

        //ATRIBUIÇÃO DAS VARIAVEIS PARA STRINGS PARA FACILITAR NA ESTRUTURA DE CONDIÇÃO IF
        String gamesNomeGame = editTextNomeGame.getText().toString();
        String gamesAbreviacao = editTextAbreviacao.getText().toString();
        String gamesGeneroGames = editTextGeneroGames.getText().toString();
        String gamesDataGames = editTextDataGame.getText().toString();
        String gamesModoJogo = editTextModoJogo.getText().toString();
        String gamesPublicadora = editTextPublicadora.getText().toString();
        String gamesDesenvolvedora = editTextDesenvolvedora.getText().toString();
        String gamesQuantLancada = editTextQuantLancada.getText().toString();
        String gamesPlataforma = editTextPlataforma.getText().toString();
        String gamesMelhorFranquia = editTextMelhorFranquia.getText().toString();

        //APRESENTA OS ERROS AO DEIXAR ALGUM ATRIBUTO EM BRANCO
        if (gamesNomeGame.length() == 0)
            editTextNomeGame.setError("Digite o Nome!");
        if (gamesAbreviacao.length() == 0)
            editTextAbreviacao.setError("Digite a Abreviação!");
        if (gamesGeneroGames.length() == 0)
            editTextGeneroGames.setError("Digite o Gênero!");
        if (gamesDataGames.length() == 0)
            editTextDataGame.setError("Digite a Data de Lançamento!");
        if (gamesModoJogo.length() == 0)
            editTextModoJogo.setError("Digite o Modo de Jogo!");
        if (gamesPublicadora.length() == 0)
            editTextPublicadora.setError("Digite a Publicadora!");
        if (gamesDesenvolvedora.length() == 0)
            editTextDesenvolvedora.setError("Digite a Desenvolvedora!");
        if (gamesQuantLancada.length() == 0)
            editTextQuantLancada.setError("Digite a Quant. de Games Lançados!");
        if (gamesPlataforma.length() == 0)
            editTextPlataforma.setError("Digite a Plataforma!");
        if (gamesMelhorFranquia.length() == 0)
            editTextMelhorFranquia.setError("Digite a Franquia!");

        //SE TODOS OS CAMPOS FOREM PREENCHIDOS SERÁ EXECUTADA ESTÁ AÇÃO
        if (gamesNomeGame.length() != 0 && gamesAbreviacao.length() != 0 && gamesGeneroGames.length() != 0
                && gamesDataGames.length() != 0 && gamesModoJogo.length() != 0
                && gamesPublicadora.length() != 0 && gamesDesenvolvedora.length() != 0
                && gamesQuantLancada.length() != 0 && gamesPlataforma.length() != 0
                && gamesMelhorFranquia.length() != 0) {

            if (games_model == null){

                //CONVERTER PARA O TIPO DE DADOS QUE SERÁ ARMAZENADOS NO BANCO DE DADOS
                int QuantLancada = Integer.parseInt(editTextQuantLancada.getText().toString());

                Games_model games_model = new Games_model();

                games_model.setNomegames(gamesNomeGame);
                games_model.setAbreviacao(gamesAbreviacao);
                games_model.setGenerogames(gamesGeneroGames);
                games_model.setDatalancamentogames(DateUtil.stringToDate(gamesDataGames));
                games_model.setModojogo(gamesModoJogo);
                games_model.setPublicadora(gamesPublicadora);
                games_model.setDesenvolvedora(gamesDesenvolvedora);
                games_model.setQuantlancadagames(gamesQuantLancada);
                games_model.setPlataformas(gamesPlataforma);
                games_model.setMelhorfranquia(gamesMelhorFranquia);

                criadoComSucesso = gamesController.insert(games_model);
            }else{
                //CONVERTER PARA O TIPO DE DADOS QUE SERÁ ARMAZENADOS NO BANCO DE DADOS
                int QuantLancada = Integer.parseInt(editTextQuantLancada.getText().toString());

                games_model.setNomegames(gamesNomeGame);
                games_model.setAbreviacao(gamesAbreviacao);
                games_model.setGenerogames(gamesGeneroGames);
                games_model.setDatalancamentogames(DateUtil.stringToDate(gamesDataGames));
                games_model.setModojogo(gamesModoJogo);
                games_model.setPublicadora(gamesPublicadora);
                games_model.setDesenvolvedora(gamesDesenvolvedora);
                games_model.setQuantlancadagames(gamesQuantLancada);
                games_model.setPlataformas(gamesPlataforma);
                games_model.setMelhorfranquia(gamesMelhorFranquia);


                gamesController.edit(games_model, games_model.getId());
                criadoComSucesso = true;
            }
        }
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        gamesController.closeDb();
    }


}
