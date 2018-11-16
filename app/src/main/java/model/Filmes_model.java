package model;

import java.util.Date;

public class Filmes_model {

    //Nome tabela

    public static final String TABLE = "Filmes";

    //Nome colunas

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOMEFILME = "nomefilme";
    public static final String COLUMN_DIRETORFILME = "diretorfilme";
    public static final String COLUMN_DATALANCAMENTOFILME = "datalancamentofilme";
    public static final String COLUMN_ATORPRINCIPALFILME = "atorprincipalfilme";
    public static final String COLUMN_ATRIZPRINCIPALFILME = "atrizprincipalfilme";
    public static final String COLUMN_CLASSIFICACAOFILME = "classificacaofilme";
    public static final String COLUMN_PRODUTORAFILME = "produtorafilme";
    public static final String COLUMN_GENEROFILME = "generofilme";
    public static final String COLUMN_MUSICATEMA = "musicatema";
    public static final String COLUMN_DURACAO = "duracao";

    //Criando tabela

    public static final String SQL_CREATE = "CREATE TABLE" + TABLE + "( "
            + COLUMN_ID                     + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NOMEFILME              + "TEXT,"
            + COLUMN_DIRETORFILME           + "TEXT,"
            + COLUMN_DATALANCAMENTOFILME    + "TEXT,"
            + COLUMN_ATORPRINCIPALFILME     + "TEXT,"
            + COLUMN_ATRIZPRINCIPALFILME    + "TEXT"
            + COLUMN_CLASSIFICACAOFILME     + "INTEGER"
            + COLUMN_PRODUTORAFILME         + "TEXT"
            + COLUMN_GENEROFILME            + "TEXT"
            + COLUMN_MUSICATEMA             + "TEXT"
            + COLUMN_DURACAO                + "INTEGER)";

    private int id;
    private String nomefilme, diretorfilme, atorprincipalfilme, atrizprincipalfilme, classificacaofilme, produtorafilme, generofilme, musicatema;
    private Date datalancamentofilme;
    private String duracao;

    public int getId () { return id; }
    public void setId (int id) { this.id = id; }

    public String getNomefilme () { return nomefilme;}
    public void setNomefilme (String nomefilme) {this.nomefilme = nomefilme;}

    public String getDiretorfilme () {return diretorfilme;}
    public void setDiretorfilme (String diretorfilme) {this.diretorfilme = diretorfilme;}

    public String getAtorprincipalfilme () {return atorprincipalfilme;}
    public void setAtorprincipalfilme (String atorprincipalfilme) {this.atorprincipalfilme = atorprincipalfilme;}

    public String getAtrizprincipalfilme () {return atrizprincipalfilme;}
    public void setAtrizprincipalfilme (String atrizprincipalfilme) {this.atrizprincipalfilme = atrizprincipalfilme;}

    public String getClassificacaofilme () {return classificacaofilme;}
    public void setClassificacaofilme (String classificacaofilme) {this.classificacaofilme = classificacaofilme;}

    public String getProdutorafilme () {return produtorafilme;}
    public void setProdutorafilme (String produtorafilme) {this.produtorafilme = produtorafilme;}

    public String getGenerofilme () {return generofilme;}
    public void setGenerofilme (String generofilme) {this.generofilme = generofilme;}

    public Date getDatalancamentofilme () {return datalancamentofilme;}
    public void setDatalancamentofilme (Date datalancamentofilme) {this.datalancamentofilme = datalancamentofilme;}

    public String getDuracao () {return duracao;}
    public void setDuracao (String duracao) {this.duracao = duracao;}


}

