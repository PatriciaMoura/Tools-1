package view.cadastro;

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

import java.util.ArrayList;
import java.util.List;

import model.DateUtil;
import model.Genero_model;
import model.Series_model;
import view.Series_View;

import com.example.patricia.cad.Genero_Controller;
import com.example.patricia.cad.R;
import com.example.patricia.cad.Series_Controller;

public class SeriesCadastro implements DialogInterface.OnShowListener, View.OnClickListener, DialogInterface.OnDismissListener{

    private Series_Controller seriesController;
    private Genero_Controller generoController;
    private Series_model series_model;

    private AlertDialog dialog;
    private EditText editTextNomeSerie, editTextDiretorSerie, editTextDataLancamentoSerie, editTextAtrizPrincipalSerie, editTextAtorPrincipalserie;
    private EditText editTextClassificacaoSerie, editTextProdutoraSerie, editTextQuantTemp, editTextQuantCapit, editTextedtGeneroSerie;


    private Spinner spnIdGenero;
    private int generoid;
    private List<String> listaNomeGenero = new ArrayList<String>();
    List<Genero_model> listObjGenero;


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
        editTextAtorPrincipalserie = (EditText) view.findViewById(R.id.edtAtorPrincipalSerie);
        editTextClassificacaoSerie = (EditText) view.findViewById(R.id.edtClassificacaoSerie);
        editTextProdutoraSerie = (EditText) view.findViewById(R.id.edtProdutoraSerie);
        editTextQuantTemp = (EditText) view.findViewById(R.id.edtQuantTemporadas);
        editTextQuantCapit = (EditText) view.findViewById(R.id.edtQuantCapitulosSeries);

        spnIdGenero = (Spinner) view.findViewById(R.id.spnGeneroId);

        generoController = new Genero_Controller(context);
        arrayIdGenero();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, listaNomeGenero);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnIdGenero.setAdapter(adapter);
        spnIdGeneroItemSelected(adapter);


        //CRIA OS BUTTONS DO ALERTDIALOG
        builder.setPositiveButton("Salvar", null);
        builder.setNegativeButton("Voltar", null);

        dialog = builder.create();
        dialog.setOnShowListener(this);
        dialog.show();
    }

    private void arrayIdGenero() {

        listObjGenero = generoController.getAll();
        for (Genero_model genero : listObjGenero)
            listaNomeGenero.add(genero.getNomegenero() );

    }

    public void loadSeries (Series_model series_model){

        this.series_model = series_model;

        editTextNomeSerie.setText(series_model.getNomeserie());
        editTextDiretorSerie.setText(series_model.getDiretorserie());
        editTextDataLancamentoSerie.setText(DateUtil.dateToString(series_model.getDatalancamentoserie()));
        editTextAtrizPrincipalSerie.setText(series_model.getAtrizprincipalserie());
        editTextAtorPrincipalserie.setText(series_model.getAtorprincipalserie());
        editTextClassificacaoSerie.setText(String.valueOf(series_model.getClassificacaoserie()));
        editTextProdutoraSerie.setText(series_model.getProdutoraserie());
        spnIdGenero.setSelection(getIndexGeneroId(series_model.getIdGenero()));
        editTextQuantTemp.setText(String.valueOf(series_model.getQuanttemporadas()));
        editTextQuantCapit.setText(String.valueOf(series_model.getQuantcapitulosserie()));

    }

    private int getIndexGeneroId(int idSerie) {
        for (int index = 0; index < listObjGenero.size(); index++){
            Genero_model serie = listObjGenero.get(index);
            if (idSerie == serie.getId())
                return index;
        }
        return 0;
    }

    @Override
    public void onShow(DialogInterface d){
        Button b = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        b.setId(DialogInterface.BUTTON_POSITIVE);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        insertSerie ();

        if (criadoComSucesso) {
            Toast.makeText(context, "Série Armazenado Com Sucesso.", Toast.LENGTH_SHORT).show();
            ((Series_View) context).atualizarRegistros();
        }
        else
            Toast.makeText(context, "Não Foi Possivel Armazenar a Série.", Toast.LENGTH_SHORT).show();
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
        if (serieQuantTemp.length() == 0)
            editTextQuantTemp.setError("Digite a Quant. de Temporadas!");
        if (serieQuantCapit.length() == 0)
            editTextQuantCapit.setError("Digite a Duração de Capítulos!");

        //SE TODOS OS CAMPOS FOREM PREENCHIDOS SERÁ EXECUTADA ESTÁ AÇÃO
        if (serieNome.length() != 0 && serieDiretor.length() != 0 && serieDataLancamento.length() != 0
                && serieAtrizPrincipal.length() != 0 && serieAtorPrincipal.length() != 0
                && serieClassificacao.length() != 0 && serieProdutora.length() != 0
                && serieQuantTemp.length() != 0
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
                series_model.setAtrizprincipalserie(serieAtrizPrincipal);
                series_model.setAtorprincipalserie(serieAtorPrincipal);
                series_model.setClassificacaoserie(classificacao);
                series_model.setProdutoraserie(serieProdutora);
                series_model.setIdGenero(generoid);
                series_model.setQuanttemporadas(quantTemp);
                series_model.setQuantcapitulosserie(quantCapit);

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
                series_model.setClassificacaoserie(classificacao);
                series_model.setProdutoraserie(serieProdutora);
                series_model.setIdGenero(generoid);
                series_model.setQuanttemporadas(quantTemp);
                series_model.setQuantcapitulosserie(quantCapit);

                seriesController.edit(series_model, series_model.getId());
                criadoComSucesso = true;
            }
        }
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        seriesController.closeDb();
    }

    private void spnIdGeneroItemSelected(ArrayAdapter<String> adapter) {

        spnIdGenero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Genero_model genero = listObjGenero.get(i);
                generoid = genero.getId();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

}


