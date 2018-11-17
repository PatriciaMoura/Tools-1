package View.Cadastro;

import course.example.tools.Livro_Controller;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import View.Livros_View;
import model.DateUtil;

import java.util.ArrayList;
import java.util.List;

import model.Livros_model;
import course.example.tools.Livro_Controller;

public class LivrosCadastro implements DialogInterface.OnShowListener, View.OnClickListener, DialogInterface.OnDismissListener{

    private Livro_Controller livroController;

    private Livros_model livros_model;

    private AlertDialog dialog;
    private EditText editTextTitulo, editTextAutor, editTextDataLivro, editTextEditora, editTextEdicao;
    private EditText editTextPaisOrigem, editTextQuantCapitulos, editTextQuantPaginas, editTextGeneroLivro, editTextDataCompra;


    private List<String> listaViagens = new ArrayList<String>();
    List<View.Viagens_View> listViagens;


    Context context;

    boolean criadoComSucesso;

    public LivrosCadastro(Context context) {

        //CRIA O CONTEXT
        this.context = context;

        livroController = new Livro_Controller(context);

        //CRIA O LAYOUT COMO ALERTDIALOG
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.activity_cadastro_livro, null);
        builder.setView(view);

        //ATRIBUI AS VARIVEIS AOS ITENS DO LAYOUT
        editTextTitulo = (EditText)view.findViewById(R.id.edtTitulo);
        editTextAutor = (EditText) view.findViewById(R.id.edtAutor);
        editTextDataLivro = (EditText) view.findViewById(R.id.edtDataLancamentoLivro);
        editTextEditora = (EditText) view.findViewById(R.id.edtEditora);
        editTextEdicao = (EditText) view.findViewById(R.id.edtEdicao);
        editTextPaisOrigem = (EditText) view.findViewById(R.id.edtPaisOrigem);
        editTextQuantCapitulos = (EditText) view.findViewById(R.id.edtQuantCapitulosLivro);
        editTextQuantPaginas = (EditText) view.findViewById(R.id.edtQuantPaginas);
        editTextGeneroLivro = (EditText) view.findViewById(R.id.edtGeneroLivro);
        editTextDataCompra = (EditText) view.findViewById(R.id.edtDataCompra);


        //CRIA OS BUTTONS DO ALERTDIALOG
        builder.setPositiveButton("Salvar", null);
        builder.setNegativeButton("Voltar", null);

        dialog = builder.create();
        dialog.setOnShowListener(this);
        dialog.show();
    }



    public void loadLivros (Livros_model livros_model){

        this.livros_model = livros_model;

        editTextTitulo.setText(livros_model.getTitulo());
        editTextAutor.setText(livros_model.getAutor());
        editTextDataLivro.setText(DateUtil.dateToString(livros_model.getDatalancamentolivro()));
        editTextEditora.setText(livros_model.getEditora());
        editTextEdicao.setText(livros_model.getEdicao());
        editTextPaisOrigem.setText(livros_model.getPaisorigem());
        editTextQuantCapitulos.setText(livros_model.getQuantcapitulolivro());
        editTextQuantPaginas.setText(livros_model.getQuantpagina());
        editTextGeneroLivro.setText(livros_model.getGenerolivro());
        editTextDataCompra.setText(DateUtil.dateToString(livros_model.getDatacompra()));

    }

    @Override
    public void onShow(DialogInterface d){
        Button b = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        b.setId(DialogInterface.BUTTON_POSITIVE);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        insertLivros();

        if (criadoComSucesso) {
            Toast.makeText(context, "Livro Armazenado Com Sucesso.", Toast.LENGTH_SHORT).show();
            ((Livros_View) context).atualizarRegistros();
        }
        else
            Toast.makeText(context, "Não Foi Possivel Armazenar o Livro.", Toast.LENGTH_SHORT).show();

        dialog.dismiss();

    }

    public void insertLivros() {

        //ATRIBUIÇÃO DAS VARIAVEIS PARA STRINGS PARA FACILITAR NA ESTRUTURA DE CONDIÇÃO IF
        String livrosTitulo = editTextTitulo.getText().toString();
        String livrosAutor = editTextAutor.getText().toString();
        String livrosDataLancamento = editTextDataLivro.getText().toString();
        String livrosEditora = editTextEditora.getText().toString();
        String livrosEdicao = editTextEdicao.getText().toString();
        String livrosPaisOrigem = editTextPaisOrigem.getText().toString();
        String livrosQuantCapitulos = editTextQuantCapitulos.getText().toString();
        String livrosQuantPaginas = editTextQuantPaginas.getText().toString();
        String livrosGenero = editTextGeneroLivro.getText().toString();
        String livrosDataCompra = editTextDataCompra.getText().toString();

        //APRESENTA OS ERROS AO DEIXAR ALGUM ATRIBUTO EM BRANCO
        if (livrosTitulo.length() == 0)
            editTextTitulo.setError("Digite o Título!");
        if (livrosAutor.length() == 0)
            editTextAutor.setError("Digite o Autor!");
        if (livrosDataLancamento.length() == 0)
            editTextDataLivro.setError("Digite a Data de Lançamento!");
        if (livrosEditora.length() == 0)
            editTextEditora.setError("Digite a Editora!");
        if (livrosEdicao.length() == 0)
            editTextEdicao.setError("Digite a Edição!");
        if (livrosPaisOrigem.length() == 0)
            editTextPaisOrigem.setError("Digite o País de Origem!");
        if (livrosQuantCapitulos.length() == 0)
            editTextQuantCapitulos.setError("Digite a Quant. de Cap.!");
        if (livrosQuantPaginas.length() == 0)
            editTextQuantPaginas.setError("Digite a Quant. de Pág.!");
        if (livrosGenero.length() == 0)
            editTextGeneroLivro.setError("Digite o Gênero!");
        if (livrosDataCompra.length() == 0)
            editTextDataCompra.setError("Digite a Data de Compra!");

        //SE TODOS OS CAMPOS FOREM PREENCHIDOS SERÁ EXECUTADA ESTÁ AÇÃO
        if (livrosTitulo.length() != 0 && livrosAutor.length() != 0 && livrosDataLancamento.length() != 0
                && livrosEditora.length() != 0 && livrosEdicao.length() != 0
                && livrosPaisOrigem.length() != 0 && livrosQuantCapitulos.length() != 0
                && livrosQuantPaginas.length() != 0 && livrosGenero.length() != 0
                && livrosDataCompra.length() != 0) {

            if (livros_model == null){

                //CONVERTER PARA O TIPO DE DADOS QUE SERÁ ARMAZENADOS NO BANCO DE DADOS
                int QuantCapitulos = Integer.parseInt(editTextQuantCapitulos.getText().toString());
                int QuantPaginas = Integer.parseInt(editTextQuantPaginas.getText().toString());

                Livros_model viagens_model = new Livros_model();
                livros_model.setTitulo(livrosTitulo);
                livros_model.setAutor(livrosAutor);
                livros_model.setDatalancamentolivro(DateUtil.stringToDate(livrosDataLancamento));
                livros_model.setEditora(livrosEditora);
                livros_model.setEdicao(livrosEdicao);
                livros_model.setPaisorigem(livrosPaisOrigem);
                livros_model.setQuantpagina(livrosQuantCapitulos);
                livros_model.setQuantpagina(livrosQuantPaginas);
                livros_model.setGenerolivro(livrosGenero);
                livros_model.setDatacompra(DateUtil.stringToDate(livrosDataCompra));

                criadoComSucesso = livroController.insert(viagens_model);
            }else{
                //CONVERTER PARA O TIPO DE DADOS QUE SERÁ ARMAZENADOS NO BANCO DE DADOS
                int QuantCapitulos = Integer.parseInt(editTextQuantCapitulos.getText().toString());
                int QuantPaginas = Integer.parseInt(editTextQuantPaginas.getText().toString());

                livros_model.setTitulo(livrosTitulo);
                livros_model.setAutor(livrosAutor);
                livros_model.setDatalancamentolivro(DateUtil.stringToDate(livrosDataLancamento));
                livros_model.setEditora(livrosEditora);
                livros_model.setEdicao(livrosEdicao);
                livros_model.setPaisorigem(livrosPaisOrigem);
                livros_model.setQuantpagina(livrosQuantCapitulos);
                livros_model.setQuantpagina(livrosQuantPaginas);
                livros_model.setGenerolivro(livrosGenero);
                livros_model.setDatacompra(DateUtil.stringToDate(livrosDataCompra));


                livroController.edit(livros_model, livros_model.getId());
                criadoComSucesso = true;
            }
        }
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        livros_model.closeDb();
    }


}
