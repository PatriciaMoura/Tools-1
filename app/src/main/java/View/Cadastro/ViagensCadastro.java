package view.cadastro;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import view.Viagens_View;
import model.DateUtil;

import java.util.ArrayList;
import java.util.List;

import model.Viagens_model;
import course.example.tools.Viagens_Controller;

public class ViagensCadastro implements DialogInterface.OnShowListener, View.OnClickListener, DialogInterface.OnDismissListener{

    private Viagens_Controller viagensController;

    private Viagens_model viagens_model;

    private AlertDialog dialog;
    private EditText editTextLocal, editTextDataIda, editTextDataVolta, editTextCIAAerea, editTextValor;
    private EditText editTextParcelado, editTextHotel, editTextTranslado, editTextGuia, editTextVisto;


    private List<String> listaViagens = new ArrayList<String>();
    List<View.Viagens_View> listViagens;


    Context context;

    boolean criadoComSucesso;

    public ViagensCadastro(Context context) {

        //CRIA O CONTEXT
        this.context = context;

        viagensController = new Viagens_Controller(context);

        //CRIA O LAYOUT COMO ALERTDIALOG
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.activity_viagens, null);
        builder.setView(view);

        //ATRIBUI AS VARIVEIS AOS ITENS DO LAYOUT
        editTextLocal = (EditText)view.findViewById(R.id.edtLocal);
        editTextDataIda = (EditText) view.findViewById(R.id.edtDataIda);
        editTextDataVolta = (EditText) view.findViewById(R.id.edtDataVolta);
        editTextCIAAerea = (EditText) view.findViewById(R.id.edtCIAAerea);
        editTextValor = (EditText) view.findViewById(R.id.edtValor);
        editTextParcelado = (EditText) view.findViewById(R.id.edtParcelado);
        editTextHotel = (EditText) view.findViewById(R.id.edtHotel);
        editTextTranslado = (EditText) view.findViewById(R.id.edtTranslado);
        editTextGuia = (EditText) view.findViewById(R.id.edtGuia);
        editTextVisto = (EditText) view.findViewById(R.id.edtQuantVisto);


        //CRIA OS BUTTONS DO ALERTDIALOG
        builder.setPositiveButton("Salvar", null);
        builder.setNegativeButton("Voltar", null);

        dialog = builder.create();
        dialog.setOnShowListener(this);
        dialog.show();
    }



    public void loadViagens (Viagens_model viagens_model){

        this.viagens_model = viagens_model;

        editTextLocal.setText(viagens_model.getLocal());
        editTextDataIda.setText(DateUtil.dateToString(viagens_model.getDataida()));
        editTextDataVolta.setText(DateUtil.dateToString(viagens_model.getDatavolta()));
        editTextCIAAerea.setText(viagens_model.getCiaaerea());
        editTextValor.setText(viagens_model.getValor());
        editTextParcelado.setText(viagens_model.getParcelado());
        editTextHotel.setText(viagens_model.getHotel());
        editTextTranslado.setText(viagens_model.getTranslado());
        editTextGuia.setText(viagens_model.getVisto());
        editTextVisto.setText(viagens_model.getVisto());

    }

    @Override
    public void onShow(DialogInterface d){
        Button b = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        b.setId(DialogInterface.BUTTON_POSITIVE);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        insertViagens();

        if (criadoComSucesso) {
            Toast.makeText(context, "Viagem Armazenado Com Sucesso.", Toast.LENGTH_SHORT).show();
            ((Viagens_View) context).atualizarRegistros();
        }
        else
            Toast.makeText(context, "Não Foi Possivel Armazenar a Viagem.", Toast.LENGTH_SHORT).show();

        dialog.dismiss();

    }

    public void insertViagens() {

        //ATRIBUIÇÃO DAS VARIAVEIS PARA STRINGS PARA FACILITAR NA ESTRUTURA DE CONDIÇÃO IF
        String viagensLocal = editTextLocal.getText().toString();
        String viagensDataIda = editTextDataIda.getText().toString();
        String viagensDatavolta= editTextDataVolta.getText().toString();
        String viagensCIAAerea = editTextCIAAerea.getText().toString();
        String viagensValor = editTextValor.getText().toString();
        String viagensParcelado = editTextParcelado.getText().toString();
        String viagensHotel = editTextHotel.getText().toString();
        String viagensTranslado = editTextTranslado.getText().toString();
        String viagensGuia = editTextGuia.getText().toString();
        String viagensVisto = editTextVisto.getText().toString();

        //APRESENTA OS ERROS AO DEIXAR ALGUM ATRIBUTO EM BRANCO
        if (viagensLocal.length() == 0)
            editTextLocal.setError("Digite o local da Viagem!");
        if (viagensDataIda.length() == 0)
            editTextDataIda.setError("Digite a Data de Ida!");
        if (viagensDatavolta.length() == 0)
            editTextDataVolta.setError("Digite a Data de Volta!");
        if (viagensCIAAerea.length() == 0)
            editTextCIAAerea.setError("Digite a CIA Aérea!");
        if (viagensValor.length() == 0)
            editTextValor.setError("Digite o Valor!");
        if (viagensParcelado.length() == 0)
            editTextParcelado.setError("Digite a Quant. de Parcelas!");
        if (viagensHotel.length() == 0)
            editTextHotel.setError("Digite o Hotel!");
        if (viagensTranslado.length() == 0)
            editTextTranslado.setError("Digite se contratou Translado!");
        if (viagensGuia.length() == 0)
            editTextGuia.setError("Digite se contratou guia!");
        if (editTextVisto.length() == 0)
            editTextVisto.setError("Digite se foi preciso Visto!");

        //SE TODOS OS CAMPOS FOREM PREENCHIDOS SERÁ EXECUTADA ESTÁ AÇÃO
        if (viagensLocal.length() != 0 && viagensDataIda.length() != 0 && viagensDatavolta.length() != 0
                && viagensCIAAerea.length() != 0 && viagensValor.length() != 0
                && viagensParcelado.length() != 0 && viagensHotel.length() != 0
                && viagensTranslado.length() != 0 && viagensGuia.length() != 0
                && viagensVisto.length() != 0) {

            if (viagens_model == null){

                //CONVERTER PARA O TIPO DE DADOS QUE SERÁ ARMAZENADOS NO BANCO DE DADOS
                int Parcela = Integer.parseInt(editTextParcelado.getText().toString());

                Viagens_model viagens_model = new Viagens_model();
                viagens_model.setLocal(viagensLocal);
                viagens_model.setDataida(DateUtil.stringToDate(viagensDataIda));
                viagens_model.setDatavolta(DateUtil.stringToDate(viagensDatavolta));
                viagens_model.setCiaaerea(viagensCIAAerea);
                viagens_model.setValor(viagensValor);
                viagens_model.setParcelado(viagensParcelado);
                viagens_model.setHotel(viagensHotel);
                viagens_model.setTranslado(viagensTranslado);
                viagens_model.setGuia(viagensGuia);
                viagens_model.setVisto(viagensVisto);

                criadoComSucesso = viagensController.insert(viagens_model);
            }else{
                //CONVERTER PARA O TIPO DE DADOS QUE SERÁ ARMAZENADOS NO BANCO DE DADOS
                int Parcela = Integer.parseInt(editTextParcelado.getText().toString());

                viagens_model.setLocal(viagensLocal);
                viagens_model.setDataida(DateUtil.stringToDate(viagensDataIda));
                viagens_model.setDatavolta(DateUtil.stringToDate(viagensDatavolta));
                viagens_model.setCiaaerea(viagensCIAAerea);
                viagens_model.setValor(viagensValor);
                viagens_model.setParcelado(viagensParcelado);
                viagens_model.setHotel(viagensHotel);
                viagens_model.setTranslado(viagensTranslado);
                viagens_model.setGuia(viagensGuia);
                viagens_model.setVisto(viagensVisto);

                viagensController.edit(viagens_model, viagens_model.getId());
                criadoComSucesso = true;
            }
        }
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        viagensController.closeDb();
    }


}
