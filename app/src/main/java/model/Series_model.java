package model;

import java.util.Date;

public class Series_model {

    public static final String TABLE = "Series";

    //Nome colunas

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOMESERIE = "nomeserie";
    public static final String COLUMN_DIRETORSERIE = "diretorserie";
    public static final String COLUMN_DATALANCAMENTOSERIE = "datalancamentoserie";
    public static final String COLUMN_ATORPRINCIPALSERIE= "atorprincipalserie";
    public static final String COLUMN_ATRIZPRINCIPALSERIE = "atrizprincipalserie";
    public static final String COLUMN_CLASSIFICACAOSERIE = "classificacaoserie";
    public static final String COLUMN_PRODUTORASERIE = "produtoraserie";
    public static final String COLUMN_GENEROSERIE = "generoserie";
    public static final String COLUMN_QUANTTEMPORADAS = "qaunttemporadas";
    public static final String COLUMN_QUANTCAPITULOSSERIE = "quantcapitulossesie";

    //Criando tabela

    public static final String SQL_CREATE = "CREATE TABLE" + TABLE + "( "
            + COLUMN_ID                     + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NOMESERIE              + "TEXT,"
            + COLUMN_DIRETORSERIE           + "TEXT,"
            + COLUMN_DATALANCAMENTOSERIE    + "TEXT,"
            + COLUMN_ATORPRINCIPALSERIE     + "TEXT,"
            + COLUMN_ATRIZPRINCIPALSERIE    + "TEXT"
            + COLUMN_CLASSIFICACAOSERIE     + "INTEGER"
            + COLUMN_PRODUTORASERIE         + "TEXT"
            + COLUMN_GENEROSERIE            + "TEXT"
            + COLUMN_QUANTTEMPORADAS        + "INTEGER"
            + COLUMN_QUANTCAPITULOSSERIE    + "INTEGER)";

    private int id;
    private String nomeserie, diretorserie, atorprincipalserie, atrizprincipalserie, produtoraserie, generoserie;
    private Date datalancamentoserie;
    private Integer classificacaoserie,quanttemporadas, quantcapitulosserie;

    public int getId () { return id; }
    public void setId (int id) { this.id = id; }

    public String getNomeserie () { return nomeserie ;}
    public void setNomeserie (String nomeserie) {this.nomeserie = nomeserie;}

    public String getDiretorserie () { return diretorserie ;}
    public void setDiretorserie (String diretorserie) {this.diretorserie = diretorserie;}

    public Date getDatalancamentoserie () { return datalancamentoserie ;}
    public void setDatalancamentoserie (Date datalancamentoserie) {this.datalancamentoserie = datalancamentoserie;}

    public String getAtorprincipalserie () { return atorprincipalserie ;}
    public void setAtorprincipalserie (String atorprincipalserie ) {this.atorprincipalserie = atorprincipalserie;}

    public String getAtrizprincipalserie () { return atrizprincipalserie ;}
    public void setAtrizprincipalserie (String atrizprincipalserie) {this.atrizprincipalserie = atrizprincipalserie;}

    public Integer getClassificacaoserie () { return classificacaoserie;}
    public void setClassificacaoserie (Integer classificacaoserie) {this.classificacaoserie = classificacaoserie;}

    public String getProdutoraserie () { return produtoraserie ;}
    public void setProdutoraserie (String produtoraserie) {this.produtoraserie = produtoraserie;}

    public String getGeneroserie () { return generoserie ;}
    public void setGeneroserie (String generoserie) {this.generoserie = generoserie;}

    public Integer getQuanttemporadas () { return quanttemporadas ;}
    public void set (Integer quanttemporadas) {this.quanttemporadas = quanttemporadas;}

    public Integer getQuantcapitulosserie () { return quantcapitulosserie;}
    public void setQuantcapitulosserie (Integer quantcapitulosserie) {this.quantcapitulosserie = quantcapitulosserie;}

}

