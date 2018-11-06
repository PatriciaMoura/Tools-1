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


import course.example.tools.R;
import model.DateUtil;
import model.Ficha_Medica;

import course.example.tools.Ficha_Medica_Controller;


import java.util.ArrayList;
import java.util.List;

public class FichaMedicaCadastro implements DialogInterface.OnShowListener, View.OnClickListener, DialogInterface.OnDismissListener {

    private Ficha_Medica_Controller fichaMedicaController;

    private AlertDialog dialog;
    private EditText editTextNome, editTextRG, editTextCPF, editTextAltura, editTextPeso, editTextContatoEmergencia, editTextTipoSangue, editTextAlergia;
    private EditText editTextData, editTextTelefone;
    private Ficha_Medica fichaMedica; //Ficha_Medica model

    private List<String> listaFichaMedica = new ArrayList<String>();

    Context context;

    boolean criadoComSucesso;

    public FichaMedicaCadastro(Context context){
    this.context = context; //cria o context

   fichaMedicaController = new Ficha_Medica_Controller(context);

        //CRIA O LAYOUT COMO ALERTDIALOG
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.content_ficha__medica, null);
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

    public void loadFichaMedica (Ficha_Medica fichaMedica){

        this.fichaMedica = fichaMedica;

        editTextNome.setText(fichaMedica.getNome());
        editTextRG.setText(String.valueOf(fichaMedica.getRg()));
        editTextCPF.setText(fichaMedica.getCpf());
        editTextAltura.setText(String.valueOf(fichaMedica.getAltura()));
        editTextPeso.setText(String.valueOf(fichaMedica.getPeso()));
        editTextData.setText((DateUtil.dateToString(fichaMedica.getDatanasc())));
        editTextTelefone.setText(String.valueOf(fichaMedica.gettelefone()));
        editTextContatoEmergencia.setText(fichaMedica.getContatoemergencia());
        editTextTipoSangue.setText(fichaMedica.getTiposangue());
        editTextAlergia.setText(fichaMedica.getAlergia());
    }

    @Override
    public void onShow(DialogInterface d){
        Button b = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        b.setId(DialogInterface.BUTTON_POSITIVE);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        insertFichaMedica ();

        if (criadoComSucesso) {
            Toast.makeText(context, "Cadastro efetuado com Sucesso.", Toast.LENGTH_SHORT).show();
            ((View.FichaMedica_View) context).atualizarRegistros();
        }
        else
            Toast.makeText(context, "Não foi possível efetuar o cadastro.", Toast.LENGTH_SHORT).show();

        dialog.dismiss();

    }

    public void insertFichaMedica () {

        //ATRIBUIÇÃO DAS VARIAVEIS PARA STRINGS PARA FACILITAR NA ESTRUTURA DE CONDIÇÃO IF
        String fichaMedicaNome = editTextNome.getText().toString();
        String fichaMedicaRg = editTextData.getText().toString();
        String fichaMedicaCpf = editTextCPF.getText().toString();
        String fichaMedicaAltura = editTextAltura.getText().toString();
        String fichaMedicaPeso = editTextPeso.getText().toString();
        String fichaMedicaData = editTextData.getText().toString();
        String fichaMedicaTelefone = editTextTelefone.getText().toString();
        String fichaMedicaContatoEmergencia = editTextContatoEmergencia.getText().toString();
        String fichaMedicaTipoSangue = editTextTipoSangue.getText().toString();
        String fichaMedicaAlergia = editTextAlergia.getText().toString();

        //APRESENTA OS ERROS AO DEIXAR ALGUM ATRIBUTO EM BRANCO
        if (fichaMedicaNome.length() == 0)
            editTextNome.setError("Digite o Nome!");
        if (fichaMedicaRg.length() == 0)
            editTextRG.setError("Digite o Seu RG!");
        if (fichaMedicaCpf.length() == 0)
            editTextCPF.setError("Digite o Seu CPF!");
        if (fichaMedicaAltura.length() == 0)
            editTextAltura.setError("Digite a Altura!");
        if (fichaMedicaPeso.length() == 0)
            editTextPeso.setError("Digite o Seu Peso!");
        if (fichaMedicaData.length() == 0)
            editTextData.setError("Digite a Sua Data de Nascimento!");
        if (fichaMedicaTelefone.length() == 0)
            editTextTelefone.setError("Digite o Seu Telefone!");
        if (fichaMedicaContatoEmergencia.length() == 0)
            editTextContatoEmergencia.setError("Digite o Contato de Emergência!");
        if (fichaMedicaTipoSangue.length() == 0)
            editTextTipoSangue.setError("Digite o Seu Tipo de Sangue!");
        if (fichaMedicaAlergia.length() == 0)
            editTextAlergia.setError("Digite ao que você tem alergia !");


        //SE TODOS OS CAMPOS FOREM PREENCHIDOS SERÁ EXECUTADA ESTÁ AÇÃO
        if (fichaMedicaNome.length() != 0 && fichaMedicaRg.length() != 0 && fichaMedicaCpf.length() != 0
                && fichaMedicaAltura.length() != 0 && fichaMedicaPeso.length() != 0 && fichaMedicaTelefone.length() != 0
                && fichaMedicaContatoEmergencia.length() != 0 && fichaMedicaTelefone.length() != 0 && fichaMedicaAlergia.length() != 0) {

            if (fichaMedica == null) {

                //CONVERTER PARA O TIPO DE DADOS QUE SERÁ ARMAZENADOS NO BANCO DE DADOS
                int Rg = Integer.parseInt(editTextRG.getText().toString());
                double altura = Double.parseDouble(editTextAltura.getText().toString());
                double peso = Double.parseDouble(editTextPeso.getText().toString());

                Ficha_Medica fichaMedica = new Ficha_Medica(); //model
                fichaMedica.setNome(fichaMedicaNome);
                fichaMedica.setRg(Rg);
                fichaMedica.setCpf(fichaMedicaCpf);
                fichaMedica.setAltura(altura);
                fichaMedica.setPeso(peso);
                fichaMedica.setDatanasc(DateUtil.stringToDate(fichaMedicaData));
                fichaMedica.setTelefone(fichaMedicaTelefone);
                fichaMedica.setTiposangue(fichaMedicaTipoSangue);

                criadoComSucesso = fichaMedicaController.insert(fichaMedica);
            } else {
                //CONVERTER PARA O TIPO DE DADOS QUE SERÁ ARMAZENADOS NO BANCO DE DADOS
                int Rg = Integer.parseInt(editTextRG.getText().toString());
                double altura = Double.parseDouble(editTextAltura.getText().toString());
                double peso = Double.parseDouble(editTextPeso.getText().toString());

                fichaMedica.setNome(fichaMedicaNome);
                fichaMedica.setRg(Rg);
                fichaMedica.setCpf(fichaMedicaCpf);
                fichaMedica.setAltura(altura);
                fichaMedica.setPeso(peso);
                fichaMedica.setDatanasc(DateUtil.stringToDate(fichaMedicaData));
                fichaMedica.setTelefone(fichaMedicaTelefone);
                fichaMedica.setContatoemergencia(fichaMedicaContatoEmergencia);
                fichaMedica.setTiposangue(fichaMedicaTipoSangue);
                fichaMedica.setAlergia(fichaMedicaAlergia);

                fichaMedicaController.edit(fichaMedica, fichaMedica.getId());
                criadoComSucesso = true;
            }

        }
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        fichaMedicaController.closeDb();
    }

}
