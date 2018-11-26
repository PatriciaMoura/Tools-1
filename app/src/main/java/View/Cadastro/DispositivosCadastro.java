package view.cadastro;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import model.DateUtil;
import model.Dispositivos_model;
import course.example.tools.Dispositivos_Controller;
import view.Disposistivos_View;

import java.util.ArrayList;
import java.util.List;

public class DispositivosCadastro implements DialogInterface.OnShowListener, View.OnClickListener, DialogInterface.OnDismissListener{

    private Dispositivos_Controller dispositivosController;

    private Dispositivos_model dispositivos_model;

    private AlertDialog dialog;
    private EditText editTextDispositivo, editTextMarca, editTextDataLancamentoDisp, editTextCor, editTextMemoria;
    private EditText editTextPixels, editTextLoja, editTextGarantia, editTextDivide, editTextSoftware;


    private List<String> listaNomeDispositivos = new ArrayList<String>();
    List<Disposistivos_View> listDispositivos;


    Context context;

    boolean criadoComSucesso;

    public DispositivosCadastro(Context context) {

        //CRIA O CONTEXT
        this.context = context;

        dispositivosController = new Dispositivos_Controller(context);

        //CRIA O LAYOUT COMO ALERTDIALOG
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.activity_dispositivos, null);
        builder.setView(view);

        //ATRIBUI AS VARIVEIS AOS ITENS DO LAYOUT
        editTextDispositivo = (EditText)view.findViewById(R.id.edtTipoDispositivo);
        editTextMarca = (EditText) view.findViewById(R.id.edtMarca);
        editTextDataLancamentoDisp = (EditText) view.findViewById(R.id.edtDataLancamentoDisp);
        editTextCor = (EditText) view.findViewById(R.id.edtCor);
        editTextMemoria = (EditText) view.findViewById(R.id.edtMemoria);
        editTextPixels = (EditText) view.findViewById(R.id.edtPixels);
        editTextLoja = (EditText) view.findViewById(R.id.edtLojaCompra);
        editTextGarantia = (EditText) view.findViewById(R.id.edtGarantia);
        editTextDivide = (EditText) view.findViewById(R.id.edtDivide);
        editTextSoftware = (EditText) view.findViewById(R.id.edtSoftware);


        //CRIA OS BUTTONS DO ALERTDIALOG
        builder.setPositiveButton("Salvar", null);
        builder.setNegativeButton("Voltar", null);

        dialog = builder.create();
        dialog.setOnShowListener(this);
        dialog.show();
    }



    public void loadDispositivos (Dispositivos_model dispositivos_model){

        this.dispositivos_model = dispositivos_model;

        editTextDispositivo.setText(dispositivos_model.getDispositivo());
        editTextMarca.setText(dispositivos_model.getMarca());
        editTextDataLancamentoDisp.setText(DateUtil.dateToString(dispositivos_model.getColumnDatalancamentodisp()));
        editTextCor.setText(dispositivos_model.getCor());
        editTextMemoria.setText(dispositivos_model.getMemoria());
        editTextPixels.setText(dispositivos_model.getPixels());
        editTextLoja.setText(dispositivos_model.getLojacompra());
        editTextGarantia.setText(dispositivos_model.getGarantia());
        editTextDivide.setText(dispositivos_model.getDivide());
        editTextSoftware.setText(dispositivos_model.getSoftware());

    }

    @Override
    public void onShow(DialogInterface d){
        Button b = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        b.setId(DialogInterface.BUTTON_POSITIVE);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        insertDispositivo();

        if (criadoComSucesso) {
            Toast.makeText(context, "Armazenado Com Sucesso.", Toast.LENGTH_SHORT).show();
            ((Disposistivos_View) context).atualizarRegistros();
        }
        else
            Toast.makeText(context, "Não Foi Possivel Armazenar.", Toast.LENGTH_SHORT).show();

        dialog.dismiss();

    }

    public void insertDispositivo() {

        //ATRIBUIÇÃO DAS VARIAVEIS PARA STRINGS PARA FACILITAR NA ESTRUTURA DE CONDIÇÃO IF
        String dispositivoDisp = editTextDispositivo.getText().toString();
        String dispositivoMarca = editTextMarca.getText().toString();
        String dispositivoDataLanc = editTextDataLancamentoDisp.getText().toString();
        String dispositivoCor = editTextCor.getText().toString();
        String dispositivoMemoria = editTextMemoria.getText().toString();
        String dispositivoPixels = editTextPixels.getText().toString();
        String dispositivoLoja = editTextLoja.getText().toString();
        String dispositivoGarantia = editTextGarantia.getText().toString();
        String dispositivoDivide = editTextDivide.getText().toString();
        String dispositivoSoftware = editTextSoftware.getText().toString();

        //APRESENTA OS ERROS AO DEIXAR ALGUM ATRIBUTO EM BRANCO
        if (dispositivoDisp.length() == 0)
            editTextDispositivo.setError("Digite o Tipo do Dispositivo!");
        if (dispositivoMarca.length() == 0)
            editTextMarca.setError("Digite a Marca!");
        if (dispositivoDataLanc.length() == 0)
            editTextDataLancamentoDisp.setError("Digite a Data!");
        if (dispositivoCor.length() == 0)
            editTextCor.setError("Digite a Cor!");
        if (dispositivoMemoria.length() == 0)
            editTextMemoria.setError("Digite a Memória!");
        if (dispositivoPixels.length() == 0)
            editTextPixels.setError("Digite os Pixels da Câmera!");
        if (dispositivoLoja.length() == 0)
            editTextLoja.setError("Digite a Loja de Compra!");
        if (dispositivoGarantia.length() == 0)
            editTextGarantia.setError("Digite a se há Garantia Estendida!");
        if (dispositivoDivide.length() == 0)
            editTextDivide.setError("Digite as Parcelas!");
        if (dispositivoSoftware.length() == 0)
            editTextSoftware.setError("Digite o Software!");

        //SE TODOS OS CAMPOS FOREM PREENCHIDOS SERÁ EXECUTADA ESTÁ AÇÃO
        if (dispositivoDisp.length() != 0 && dispositivoMarca.length() != 0 && dispositivoDataLanc.length() != 0
                && dispositivoCor.length() != 0 && dispositivoMemoria.length() != 0
                && dispositivoPixels.length() != 0 && dispositivoLoja.length() != 0
                && dispositivoGarantia.length() != 0 && dispositivoDivide.length() != 0
                && dispositivoSoftware.length() != 0) {

            if (dispositivos_model == null){

                //CONVERTER PARA O TIPO DE DADOS QUE SERÁ ARMAZENADOS NO BANCO DE DADOS
                int dispMemoria = Integer.parseInt(editTextMemoria.getText().toString());
                int dispPixels = Integer.parseInt(editTextPixels.getText().toString());
                int dispDivide = Integer.parseInt(editTextDivide.getText().toString());

                Dispositivos_model dispositivos_model = new Dispositivos_model();

                dispositivos_model.setDispositivo(dispositivoDisp);
                dispositivos_model.setMarca(dispositivoMarca);
                dispositivos_model.setDatalancamentodisp(DateUtil.stringToDate(dispositivoDataLanc));
                dispositivos_model.setCor(dispositivoCor);
                dispositivos_model.setMemoria(dispositivoMemoria);
                dispositivos_model.setPixels(dispositivoPixels);
                dispositivos_model.setLojacompra(dispositivoLoja);
                dispositivos_model.setGarantia(dispositivoGarantia);
                dispositivos_model.setDivide(dispositivoDivide);
                dispositivos_model.setSoftware(dispositivoSoftware);

                criadoComSucesso = dispositivosController.insert(dispositivos_model);
            }else{
                //CONVERTER PARA O TIPO DE DADOS QUE SERÁ ARMAZENADOS NO BANCO DE DADOS
                int dispMemoria = Integer.parseInt(editTextMemoria.getText().toString());
                int dispPixels = Integer.parseInt(editTextPixels.getText().toString());
                int dispDivide = Integer.parseInt(editTextDivide.getText().toString());

                dispositivos_model.setDispositivo(dispositivoDisp);
                dispositivos_model.setMarca(dispositivoMarca);
                dispositivos_model.setDatalancamentodisp(DateUtil.stringToDate(dispositivoDataLanc));
                dispositivos_model.setCor(dispositivoCor);
                dispositivos_model.setMemoria(dispositivoMemoria);
                dispositivos_model.setPixels(dispositivoPixels);
                dispositivos_model.setLojacompra(dispositivoLoja);
                dispositivos_model.setGarantia(dispositivoGarantia);
                dispositivos_model.setDivide(dispositivoDivide);
                dispositivos_model.setSoftware(dispositivoSoftware);

                dispositivosController.edit(dispositivos_model, dispositivos_model.getId());
                criadoComSucesso = true;
            }
        }
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        dispositivosController.closeDb();
    }

}
