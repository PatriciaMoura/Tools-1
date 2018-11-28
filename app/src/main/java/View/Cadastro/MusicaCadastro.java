package view.cadastro;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import view.Musica_View;
import model.DateUtil;

import java.util.ArrayList;
import java.util.List;

import model.Musica_model;
import com.example.patricia.cad.Musica_Controller;
import com.example.patricia.cad.R;

public class MusicaCadastro implements DialogInterface.OnShowListener, View.OnClickListener, DialogInterface.OnDismissListener{

    private Musica_Controller musicaController;

    private Musica_model musica_model;

    private AlertDialog dialog;
    private EditText editTextArtista, editTextAlbum, editTextGeneroMusical, editTextDataLancamentoMusica, editTextQuantFaixas;
    private EditText editTextGravadora, editTextEstudio, editTextProdutor, editTextFaixaFavorita, editTextPremios;


    private List<String> listaMusica = new ArrayList<String>();
    List<Musica_View> listMusica;

    Context context;

    boolean criadoComSucesso;

    public MusicaCadastro(Context context) {

        //CRIA O CONTEXT
        this.context = context;

        musicaController = new Musica_Controller(context);

        //CRIA O LAYOUT COMO ALERTDIALOG
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.activity_musica, null);
        builder.setView(view);

        //ATRIBUI AS VARIVEIS AOS ITENS DO LAYOUT
        editTextArtista = (EditText)view.findViewById(R.id.edtArtista);
        editTextAlbum = (EditText) view.findViewById(R.id.edtAlbum);
        editTextGeneroMusical = (EditText) view.findViewById(R.id.edtGeneroMusical);
        editTextDataLancamentoMusica = (EditText) view.findViewById(R.id.edtDataLancamentoMusica);
        editTextQuantFaixas = (EditText) view.findViewById(R.id.edtQuantFaixas);
        editTextGravadora = (EditText) view.findViewById(R.id.edtGravadoraMusica);
        editTextProdutor = (EditText) view.findViewById(R.id.edtProdutorMusica);
        editTextEstudio = (EditText) view.findViewById(R.id.edtEstudio);
        editTextFaixaFavorita = (EditText) view.findViewById(R.id.edtFaixaFavorita);
        editTextPremios = (EditText) view.findViewById(R.id.edtEstudio);


        //CRIA OS BUTTONS DO ALERTDIALOG
        builder.setPositiveButton("Salvar", null);
        builder.setNegativeButton("Voltar", null);

        dialog = builder.create();
        dialog.setOnShowListener(this);
        dialog.show();
    }

    public void loadMusica (Musica_model musica_model){

        this.musica_model = musica_model;

        editTextArtista.setText(musica_model.getArtista());
        editTextAlbum.setText(musica_model.getAlbum());
        editTextGeneroMusical.setText(musica_model.getGeneromusical());
        editTextDataLancamentoMusica.setText(DateUtil.dateToString(musica_model.getDatalancamentomusica()));
        editTextQuantFaixas.setText(String.valueOf(musica_model.getQuatfaixas()));
        editTextGravadora.setText(musica_model.getGravadoramusica());
        editTextProdutor.setText(musica_model.getProdutoramusica());
        editTextEstudio.setText(musica_model.getEstudio());
        editTextFaixaFavorita.setText(musica_model.getFaixafavorita());
        editTextPremios.setText(musica_model.getPremio());

    }

    @Override
    public void onShow(DialogInterface d){
        Button b = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        b.setId(DialogInterface.BUTTON_POSITIVE);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        insertMusica();

        if (criadoComSucesso) {
            Toast.makeText(context, "Armazenado Com Sucesso.", Toast.LENGTH_SHORT).show();
            ((Musica_View) context).atualizarRegistros();
        }
        else
            Toast.makeText(context, "Não Foi Possivel Armazenar.", Toast.LENGTH_SHORT).show();

        dialog.dismiss();

    }

    public void insertMusica() {

        //ATRIBUIÇÃO DAS VARIAVEIS PARA STRINGS PARA FACILITAR NA ESTRUTURA DE CONDIÇÃO IF
        String musicaArtista = editTextArtista.getText().toString();
        String musicaAlbum = editTextAlbum.getText().toString();
        String musicaGeneroMusical = editTextGeneroMusical.getText().toString();
        String musicaDataLancamentoMusica = editTextDataLancamentoMusica.getText().toString();
        String musicaQuantFaixas = editTextQuantFaixas.getText().toString();
        String musicaGravadora = editTextGravadora.getText().toString();
        String musicaProdutor = editTextProdutor.getText().toString();
        String musicaEstudio = editTextEstudio.getText().toString();
        String musicaFaixaFavorita = editTextFaixaFavorita.getText().toString();
        String musicaPremios = editTextPremios.getText().toString();

        //APRESENTA OS ERROS AO DEIXAR ALGUM ATRIBUTO EM BRANCO
        if (musicaArtista.length() == 0)
            editTextArtista.setError("Digite o Artista!");
        if (musicaAlbum.length() == 0)
            editTextAlbum.setError("Digite a Álbum!");
        if (musicaGeneroMusical.length() == 0)
            editTextGeneroMusical.setError("Digite o Gênero!");
        if (musicaDataLancamentoMusica.length() == 0)
            editTextDataLancamentoMusica.setError("Digite a Data de Lançamento!");
        if (musicaQuantFaixas.length() == 0)
            editTextQuantFaixas.setError("Digite a Quant. de Faixas!");
        if (musicaGravadora.length() == 0)
            editTextGravadora.setError("Digite a Gravadora!");
        if (musicaProdutor.length() == 0)
            editTextProdutor.setError("Digite o Produtor!");
        if (musicaEstudio.length() == 0)
            editTextEstudio.setError("Digite o Estúdio!");
        if (musicaFaixaFavorita.length() == 0)
            editTextFaixaFavorita.setError("Digite a Faixa Favorita!");
        if (musicaPremios.length() == 0)
            editTextPremios.setError("Digite os Prêmios!");

        //SE TODOS OS CAMPOS FOREM PREENCHIDOS SERÁ EXECUTADA ESTÁ AÇÃO
        if (musicaArtista.length() != 0 && musicaAlbum.length() != 0 && musicaGeneroMusical.length() != 0
                && musicaDataLancamentoMusica.length() != 0 && musicaQuantFaixas.length() != 0
                && musicaGravadora.length() != 0 && musicaProdutor.length() != 0
                && musicaEstudio.length() != 0 && musicaFaixaFavorita.length() != 0
                && musicaPremios.length() != 0) {

            if (musica_model == null){

                //CONVERTER PARA O TIPO DE DADOS QUE SERÁ ARMAZENADOS NO BANCO DE DADOS
                int QuantLancada = Integer.parseInt(editTextDataLancamentoMusica.getText().toString());
                int QuantFaixas = Integer.parseInt(editTextQuantFaixas.getText().toString());

                Musica_model musica_model = new Musica_model();

                musica_model.setArtista(musicaArtista);
                musica_model.setAlbum(musicaAlbum);
                musica_model.setGeneromusical(musicaGeneroMusical);
                musica_model.setDatalancamentomusica(DateUtil.stringToDate(musicaDataLancamentoMusica));
                musica_model.setQuantfaixas(QuantFaixas);
                musica_model.setGravadoramusica(musicaGravadora);
                musica_model.setProdutoramusica(musicaProdutor);
                musica_model.setEstudio(musicaEstudio);
                musica_model.setFaixafavorita(musicaFaixaFavorita);
                musica_model.setPremio(musicaPremios);

                criadoComSucesso = musicaController.insert(musica_model);
            }else{
                //CONVERTER PARA O TIPO DE DADOS QUE SERÁ ARMAZENADOS NO BANCO DE DADOS
                int QuantFaixas = Integer.parseInt(editTextQuantFaixas.getText().toString());

                musica_model.setArtista(musicaArtista);
                musica_model.setAlbum(musicaAlbum);
                musica_model.setGeneromusical(musicaGeneroMusical);
                musica_model.setDatalancamentomusica(DateUtil.stringToDate(musicaDataLancamentoMusica));
                musica_model.setQuantfaixas(QuantFaixas);
                musica_model.setGravadoramusica(musicaGravadora);
                musica_model.setProdutoramusica(musicaProdutor);
                musica_model.setEstudio(musicaEstudio);
                musica_model.setFaixafavorita(musicaFaixaFavorita);
                musica_model.setPremio(musicaPremios);


                musicaController.edit(musica_model, musica_model.getId());
                criadoComSucesso = true;
            }
        }
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        musicaController.closeDb();
    }



}
