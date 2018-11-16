package model;

import java.sql.Date;
import java.util.Date;

public class Filmes_model {

    //Nome tabela

    public static final String TABLE = "Filmes";

    //Nome colunas
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOME = "nome";
    public static final String COLUMN_DIRETOR = "diretor";
    public static final String COLUMN_DATALANCAMENTO = "datalancamento";
    public static final String COLUMN_ATORPRINCIPAL = "atorprincipal";
    public static final String COLUMN_ATRIZPRINCIPAL = "atrizprincipal";
    public static final String COLUMN_CLASSIFICACAOIDADE = "classificacaoidade";

    //Criando tabela

    public static final String SQL_CREATE = "CREATE TABLE" + TABLE + "( "
            + COLUMN_ID                     + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NOME                   + "TEXT,"
            + COLUMN_DIRETOR                + "TEXT,"
            + COLUMN_DATALANCAMENTO         + "TEXT,"
            + COLUMN_ATORPRINCIPAL          + "TEXT,"
            + COLUMN_ATRIZPRINCIPAL         + "TEXT"
            + COLUMN_CLASSIFICACAOIDADE     + "INTEGER)";

    private int id, classificacaoidade;
    private String nome, diretor, atorprincipal, atrizprincipal;
    private Date datalancamento;

    public int getId () { return id; }
    public void setId (int id) { this.id = id; }

    public String getNome () { return nome;}
    public void setNome (String nome) {this.nome = nome;}

    public String getDiretor () {return diretor;}
    public void setDiretor (String diretor) {this.diretor = diretor;}

    public String getAtorprincipal () {return atorprincipal;}
    public void setAtorprincipal (String atorprincipal) {this.atorprincipal = atorprincipal;}

    public String getAtrizprincipal () {return atorprincipal;}
    public void setAtrizprincipal (String atrizprincipal) {this.atorprincipal = atrizprincipal;}

    public int getClassificacaoidade () {return classificacaoidade;}
    public void setColumnClassificacaoidade (String classificacaoidade) {this.atorprincipal = classificacaoidade;}


}

