package model;

import java.util.Date;

public class Livros_model {

    //Nome tabela

    public static final String TABLE = "Livros";

    //Nome colunas
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITULO = "titulo";
    public static final String COLUMN_AUTOR = "autor";
    public static final String COLUMN_DATALANCAMENTOLIVRO = "datalancamentolivro";
    public static final String COLUMN_EDITORA = "editora";
    public static final String COLUMN_EDICAO = "edicao";
    public static final String COLUMN_PAISORIGEM = "paisorigem";
    public static final String COLUMN_QUANTCAPITULOLIVRO = "quantcapitulolivro";
    public static final String COLUMN_QUANTPAGINA = "quantpagina";
    public static final String COLUMN_GENEROLIVRO = "generolivro";

    //Criando tabela

    public static final String SQL_CREATE = "CREATE TABLE" + TABLE + "( "
            + COLUMN_ID                     + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_TITULO                 + "TEXT,"
            + COLUMN_AUTOR                  + "TEXT,"
            + COLUMN_DATALANCAMENTOLIVRO    + "TEXT,"
            + COLUMN_EDITORA                + "TEXT,"
            + COLUMN_EDICAO                 + "TEXT,"
            + COLUMN_PAISORIGEM             + "TEXT,"
            + COLUMN_QUANTCAPITULOLIVRO     + "INTEGER,"
            + COLUMN_QUANTPAGINA            + "INTEGER,"
            + COLUMN_GENEROLIVRO            + "TEXT, )";

    private int id;
    private String titulo, autor, editora, edicao, paisorigem, generolivro;
    private String quantcapitulolivro, quantpagina;
    private Date datalancamentolivro;

    public int getId () { return id; }
    public void setId (int id) { this.id = id; }

    public String getTitulo () { return titulo;}
    public void setTitulo (String titulo) {this.titulo = titulo;}

    public String getAutor () {return autor;}
    public void setAutor (String autor) {this.autor = autor;}

    public Date getDatalancamentolivro () { return datalancamentolivro;}
    public void setDatalancamentolivro (Date datalancamentolivro) {this.datalancamentolivro = datalancamentolivro;}

    public String getEditora () {return editora;}
    public void setEditora (String editora) {this.editora = editora;}

    public String getEdicao () {return edicao;}
    public void setEdicao (String edicao) {this.edicao = edicao;}

    public String getPaisorigem () {return paisorigem;}
    public void setPaisorigem (String paisorigem) {this.paisorigem = paisorigem;}

    public String getQuantcapitulolivro () {return quantcapitulolivro;}
    public void setQuantcapitulolivro (String quantcapitulolivro) {this.quantcapitulolivro = quantcapitulolivro;}

    public String getQuantpagina () {return quantpagina;}
    public void setQuantpagina (String quantpagina) {this.quantpagina = quantpagina;}

    public String getGenerolivro () {return generolivro;}
    public void setGenerolivro (String generolivro) {this.generolivro = generolivro;}


}
