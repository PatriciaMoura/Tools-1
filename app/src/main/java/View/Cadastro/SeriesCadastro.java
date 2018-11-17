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
import View.FilmesView;

import java.util.ArrayList;
import java.util.List;

import model.Series_model;
import course.example.tools.Series_Controller;

public class SeriesCadastro implements DialogInterface.OnShowListener, View.OnClickListener, DialogInterface.OnDismissListener{

    private Series_Controller seriesController;

    private Series_model series_model;

    private AlertDialog dialog;
    private EditText editTextNomeSerie, editTextDiretorSerie, editTextDataLancamentoSerie, editTextAtrizPrincipalSerie, editTextAtorPrincipalserie;
    private EditText editTextClassificacaoSerie, editTextProdutoraSerie, editTextQuantTemp, editTextQuantCapit, editTextedtGeneroSerie;


    private List<String> listaNomeSeries = new ArrayList<String>();
    List<FilmesView> listSeries;


    Context context;

    boolean criadoComSucesso;

    public SeriesCadastro(Context context) {

        //CRIA O CONTEXT
        this.context = context;

        seriesController = new Series_Controller(context);

        //CRIA O LAYOUT COMO ALERTDIALOG
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.activity_series, null);
        builder.setView(view);

        //ATRIBUI AS VARIVEIS AOS ITENS DO LAYOUT
        editTextNomeSerie = (EditText)view.findViewById(R.id.edtNomeSerie);
        editTextDiretorSerie = (EditText) view.findViewById(R.id.edtDiretorSerie);
        editTextDataLancamentoSerie = (EditText) view.findViewById(R.id.edtDataLancamentoSerie);
        editTextAtrizPrincipalSerie = (EditText) view.findViewById(R.id.edtAtrizPrincipalSerie);
        editTextAtorPrincipalserie = (EditText) view.findViewById(R.id.edtAtorPrincipalserie);
        editTextClassificacaoSerie = (EditText) view.findViewById(R.id.edtClassificacaoSerie);
        editTextProdutoraSerie = (EditText) view.findViewById(R.id.edtProdutoraserie);
        editTextedtGeneroSerie = (EditText) view.findViewById(R.id.edtGeneroserie);
        editTextQuantTemp = (EditText) view.findViewById(R.id.edtQuantTemporadas);
        editTextQuantCapit = (EditText) view.findViewById(R.id.edtQuantCapitulosSeries);




        //CRIA OS BUTTONS DO ALERTDIALOG
        builder.setPositiveButton("Salvar", null);
        builder.setNegativeButton("Voltar", null);

        dialog = builder.create();
        dialog.setOnShowListener(this);
        dialog.show();
    }



    public void loadSeries (Series_model series_model){

        this.series_model = series_model;

        editTextNomeSerie.setText(series_model.getNomeserie());
        editTextDiretorSerie.setText(series_model.getDiretorserie());
        editTextDataLancamentoSerie.setText(DateUtil.dateToString(series_model.getDatalancamentoserie()));
        editTextAtrizPrincipalSerie.setText(series_model.getAtrizprincipalserie());
        editTextAtorPrincipalserie.setText(series_model.getAtorprincipalserie());
        editTextClassificacaoSerie.setText(series_model.getClassificacaoserie());
        editTextProdutoraSerie.setText(series_model.getProdutoraserie());
        editTextedtGeneroSerie.setText(series_model.getGeneroserie());
        editTextQuantTemp.setText(series_model.getQuanttemporadas());
        editTextQuantCapit.setText(series_model.getQuantcapitulosserie());

    }

    @Override
    public void onShow(DialogInterface d){
        Button b = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        b.setId(DialogInterface.BUTTON_POSITIVE);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        insertSerie();

        if (criadoComSucesso) {
            Toast.makeText(context, "Série Armazenado Com Sucesso.", Toast.LENGTH_SHORT).show();
            ((FilmesView) context).atualizarRegistros();
        }
        else
            Toast.makeText(context, "Não Foi Possivel Armazenar o Série.", Toast.LENGTH_SHORT).show();

        dialog.dismiss();

    }

    public void insertSerie() {

        //ATRIBUIÇÃO DAS VARIAVEIS PARA STRINGS PARA FACILITAR NA ESTRUTURA DE CONDIÇÃO IF
        String serieNome = editTextNomeSerie.getText().toString();
        String serieDiretor = editTextDiretorSerie.getText().toString();
        String serieDataLancamento= editTextDataLancamentoSerie.getText().toString();
        String serieAtrizPrincipal = editTextAtrizPrincipalSerie.getText().toString();
        String serieAtorPrincipal = editTextAtorPrincipalserie.getText().toString();
        String serieClassificacao = editTextClassificacaoSerie.getText().toString();
        String serieProdutora = editTextProdutoraSerie.getText().toString();
        String serieGenero = editTextedtGeneroSerie.getText().toString();
        String serieQuantTemp = editTextQuantTemp.getText().toString();
        String serieQuantCapit = editTextQuantCapit.getText().toString();

        //APRESENTA OS ERROS AO DEIXAR ALGUM ATRIBUTO EM BRANCO
        if (serieNome.length() == 0)
            editTextNomeSerie.setError("Digite o Nome da Série!");
        if (serieDiretor.length() == 0)
            editTextDiretorSerie.setError("Digite o Diretor!");
        if (serieDataLancamento.length() == 0)
            editTextDataLancamentoSerie.setError("Digite a Data!");
        if (serieAtrizPrincipal.length() == 0)
            editTextAtrizPrincipalSerie.setError("Digite o Nome da Atriz!");
        if (serieAtorPrincipal.length() == 0)
            editTextAtorPrincipalserie.setError("Digite o Nome do Ator!");
        if (serieClassificacao.length() == 0)
            editTextClassificacaoSerie.setError("Digite a Classificação da Série!");
        if (serieProdutora.length() == 0)
            editTextProdutoraSerie.setError("Digite a Produtora da Série!");
        if (serieGenero.length() == 0)
            editTextedtGeneroSerie.setError("Digite o Gênero!");
        if (serieQuantTemp.length() == 0)
            editTextQuantTemp.setError("Digite a Quant. de Temporadas!");
        if (serieQuantCapit.length() == 0)
            editTextQuantCapit.setError("Digite a Duração de Capítulos!");

        //SE TODOS OS CAMPOS FOREM PREENCHIDOS SERÁ EXECUTADA ESTÁ AÇÃO
        if (serieNome.length() != 0 && serieDiretor.length() != 0 && serieDataLancamento.length() != 0
                && serieAtrizPrincipal.length() != 0 && serieAtorPrincipal.length() != 0
                && serieClassificacao.length() != 0 && serieProdutora.length() != 0
                && serieGenero.length() != 0 && serieQuantTemp.length() != 0
                && serieQuantCapit.length() != 0) {

            if (series_model == null){

                //CONVERTER PARA O TIPO DE DADOS QUE SERÁ ARMAZENADOS NO BANCO DE DADOS
                int classificacao = Integer.parseInt(editTextClassificacaoSerie.getText().toString());
                int quantTemp = Integer.parseInt(editTextQuantTemp.getText().toString());
                int quantCapit = Integer.parseInt(editTextQuantCapit.getText().toString());

                Series_model series_model = new Series_model();
                series_model.setNomeserie(serieNome);
                series_model.setDiretorserie(serieDiretor);
                series_model.setDatalancamentoserie(DateUtil.stringToDate(serieDataLancamento));
                series_model.setAtrizprincipalserie(serieAtorPrincipal);
                series_model.setAtorprincipalserie(serieAtorPrincipal);
                series_model.setClassificacaoserie(serieClassificacao);
                series_model.setProdutoraserie(serieProdutora);
                series_model.setGeneroserie(serieGenero);
                series_model.setQuantTemporadas(serieQuantTemp);
                series_model.setQuantcapitulosserie(serieQuantCapit);

                criadoComSucesso = seriesController.insert(series_model);
            }else{
                //CONVERTER PARA O TIPO DE DADOS QUE SERÁ ARMAZENADOS NO BANCO DE DADOS
                int classificacao = Integer.parseInt(editTextClassificacaoSerie.getText().toString());
                int quantTemp = Integer.parseInt(editTextQuantTemp.getText().toString());
                int quantCapit = Integer.parseInt(editTextQuantCapit.getText().toString());

                series_model.setNomeserie(serieNome);
                series_model.setDiretorserie(serieDiretor);
                series_model.setDatalancamentoserie(DateUtil.stringToDate(serieDataLancamento));
                series_model.setAtrizprincipalserie(serieAtrizPrincipal);
                series_model.setAtorprincipalserie(serieAtorPrincipal);
                series_model.setClassificacaoserie(serieClassificacao);
                series_model.setProdutoraserie(serieProdutora);
                series_model.setGeneroserie(serieGenero);
                series_model.setQuantTemporadas(serieQuantTemp);
                series_model.setQuantcapitulosserie(serieQuantCapit);

                seriesController.edit(series_model, series_model.getId());
                criadoComSucesso = true;
            }
        }
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        seriesController.closeDb();
    }

}
