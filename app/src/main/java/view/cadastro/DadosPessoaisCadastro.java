package view.cadastro;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import model.DadosPessoais_model;
import model.DateUtil;
import view.DadosPessoais_View;
import com.example.patricia.cad.DadosPessoais_Controller;
import com.example.patricia.cad.R;

public class DadosPessoaisCadastro implements DialogInterface.OnShowListener, View.OnClickListener, DialogInterface.OnDismissListener {

    private DadosPessoais_Controller dadosPessoaisController;

    private AlertDialog dialog;
    private EditText editTextNome, editTextRG, editTextCPF, editTextAltura, editTextPeso, editTextContatoEmergencia, editTextTipoSangue, editTextAlergia;
    private EditText editTextData, editTextTelefone;
    private DadosPessoais_model dadosPessoais_model;

    private List<String> listaDadosPessoais = new ArrayList<String>();

    Context context;

    boolean criadoComSucesso;

    public DadosPessoaisCadastro(Context context){
        this.context = context; //cria o context

        dadosPessoaisController = new DadosPessoais_Controller(context);

        //CRIA O LAYOUT COMO ALERTDIALOG
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.activity_dadospessoais, null);
        builder.setView(view);

        //ATRIBUI AS VARIVEIS AOS ITENS DO LAYOUT
        editTextNome = (EditText)view.findViewById(R.id.edtNome);
        editTextRG = (EditText) view.findViewById(R.id.edtRG);
        editTextCPF = (EditText) view.findViewById(R.id.edt_CPF);
        editTextAltura = (EditText) view.findViewById(R.id.edtAltura);
        editTextPeso = (EditText) view.findViewById(R.id.edtPeso);
        editTextData = (EditText) view.findViewById(R.id.edtDatanasc);
        editTextTelefone = (EditText) view.findViewById(R.id.edtTelefone);
        editTextContatoEmergencia = (EditText) view.findViewById(R.id.edtContatoEmergencia);
        editTextTipoSangue = (EditText) view.findViewById(R.id.edtTipoSangue);
        editTextAlergia = (EditText) view.findViewById(R.id.edtAlergia);

        //CRIA OS BUTTONS DO ALERTDIALOG
        builder.setPositiveButton("Salvar", null);
        builder.setNegativeButton("Voltar", null);

        dialog = builder.create();
        dialog.setOnShowListener(this);
        dialog.show();

    }

    public void loadDadosPessoais (DadosPessoais_model dadosPessoaisModel){

        this.dadosPessoais_model = dadosPessoaisModel;

        editTextNome.setText(dadosPessoaisModel.getNome());
        editTextRG.setText(String.valueOf(dadosPessoaisModel.getRg()));
        editTextCPF.setText(dadosPessoaisModel.getCpf());
        editTextAltura.setText(String.valueOf(dadosPessoaisModel.getAltura()));
        editTextPeso.setText(String.valueOf(dadosPessoaisModel.getPeso()));
        editTextData.setText((DateUtil.dateToString(dadosPessoaisModel.getDatanasc())));
        editTextTelefone.setText(String.valueOf(dadosPessoaisModel.gettelefone()));
        editTextContatoEmergencia.setText(dadosPessoaisModel.getContatoemergencia());
        editTextTipoSangue.setText(dadosPessoaisModel.getTiposangue());
        editTextAlergia.setText(dadosPessoaisModel.getAlergia());
    }

    @Override
    public void onShow(DialogInterface d){
        Button b = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        b.setId(DialogInterface.BUTTON_POSITIVE);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        insertDadosPessoais ();

        if (criadoComSucesso) {
            Toast.makeText(context, "Cadastro efetuado com Sucesso.", Toast.LENGTH_SHORT).show();
            ((DadosPessoais_View) context).atualizarRegistros();
        }
        else
            Toast.makeText(context, "Não foi possível efetuar o cadastro.", Toast.LENGTH_SHORT).show();

        dialog.dismiss();

    }

    public void insertDadosPessoais () {

        //ATRIBUIÇÃO DAS VARIAVEIS PARA STRINGS PARA FACILITAR NA ESTRUTURA DE CONDIÇÃO IF
        String dadospessoaisNome = editTextNome.getText().toString();
        String dadospessoaisRg = editTextData.getText().toString();
        String dadospessoaisCpf = editTextCPF.getText().toString();
        String dadospessoaisAltura = editTextAltura.getText().toString();
        String dadospessoaisPeso = editTextPeso.getText().toString();
        String dadospessoaisData = editTextData.getText().toString();
        String dadospessoaisTelefone = editTextTelefone.getText().toString();
        String dadospessoaisContatoEmergencia = editTextContatoEmergencia.getText().toString();
        String dadospessoaisTipoSangue = editTextTipoSangue.getText().toString();
        String dadospessoaisAlergia = editTextAlergia.getText().toString();

        //APRESENTA OS ERROS AO DEIXAR ALGUM ATRIBUTO EM BRANCO
        if (dadospessoaisNome.length() == 0)
            editTextNome.setError("Digite o Nome!");
        if (dadospessoaisRg.length() == 0)
            editTextRG.setError("Digite o Seu RG!");
        if (dadospessoaisCpf.length() == 0)
            editTextCPF.setError("Digite o Seu CPF!");
        if (dadospessoaisAltura.length() == 0)
            editTextAltura.setError("Digite a Altura!");
        if (dadospessoaisPeso.length() == 0)
            editTextPeso.setError("Digite o Seu Peso!");
        if (dadospessoaisData.length() == 0)
            editTextData.setError("Digite a Sua Data de Nascimento!");
        if (dadospessoaisTelefone.length() == 0)
            editTextTelefone.setError("Digite o Seu Telefone!");
        if (dadospessoaisContatoEmergencia.length() == 0)
            editTextContatoEmergencia.setError("Digite o Contato de Emergência!");
        if (dadospessoaisTipoSangue.length() == 0)
            editTextTipoSangue.setError("Digite o Seu Tipo de Sangue!");
        if (dadospessoaisAlergia.length() == 0)
            editTextAlergia.setError("Digite ao que você tem alergia !");


        //SE TODOS OS CAMPOS FOREM PREENCHIDOS SERÁ EXECUTADA ESTÁ AÇÃO
        if (dadospessoaisNome.length() != 0 && dadospessoaisRg.length() != 0 && dadospessoaisCpf.length() != 0
                && dadospessoaisAltura.length() != 0 && dadospessoaisPeso.length() != 0
                && dadospessoaisData.length() != 0 && dadospessoaisTelefone.length() != 0
                && dadospessoaisContatoEmergencia.length() != 0 && dadospessoaisTipoSangue.length() != 0 && dadospessoaisAlergia.length() != 0) {

            if (dadosPessoais_model == null) {

                //CONVERTER PARA O TIPO DE DADOS QUE SERÁ ARMAZENADOS NO BANCO DE DADOS
                int Rg = Integer.parseInt(editTextRG.getText().toString());
                double altura = Double.parseDouble(editTextAltura.getText().toString());
                double peso = Double.parseDouble(editTextPeso.getText().toString());

                DadosPessoais_model dadosPessoaisModel = new DadosPessoais_model();

                dadosPessoaisModel.setNome(dadospessoaisNome);
                dadosPessoaisModel.setRg(Rg);
                dadosPessoaisModel.setCpf(dadospessoaisCpf);
                dadosPessoaisModel.setAltura(altura);
                dadosPessoaisModel.setPeso(peso);
                dadosPessoaisModel.setDatanasc(DateUtil.stringToDate(dadospessoaisData));
                dadosPessoaisModel.setTelefone(dadospessoaisTelefone);
                dadosPessoaisModel.setContatoemergencia(dadospessoaisContatoEmergencia);
                dadosPessoaisModel.setTiposangue(dadospessoaisTipoSangue);
                dadosPessoaisModel.setAlergia(dadospessoaisAlergia);

                criadoComSucesso = dadosPessoaisController.insert(dadosPessoaisModel);
            } else {
                //CONVERTER PARA O TIPO DE DADOS QUE SERÁ ARMAZENADOS NO BANCO DE DADOS
                int Rg = Integer.parseInt(editTextRG.getText().toString());
                double altura = Double.parseDouble(editTextAltura.getText().toString());
                double peso = Double.parseDouble(editTextPeso.getText().toString());

                dadosPessoais_model.setNome(dadospessoaisNome);
                dadosPessoais_model.setRg(Rg);
                dadosPessoais_model.setCpf(dadospessoaisCpf);
                dadosPessoais_model.setAltura(altura);
                dadosPessoais_model.setPeso(peso);
                dadosPessoais_model.setDatanasc(DateUtil.stringToDate(dadospessoaisData));
                dadosPessoais_model.setTelefone(dadospessoaisTelefone);
                dadosPessoais_model.setContatoemergencia(dadospessoaisContatoEmergencia);
                dadosPessoais_model.setTiposangue(dadospessoaisTipoSangue);
                dadosPessoais_model.setAlergia(dadospessoaisAlergia);

                dadosPessoaisController.edit(dadosPessoais_model, dadosPessoais_model.getId());
                criadoComSucesso = true;
            }

        }
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        dadosPessoaisController.closeDb();
    }



}

