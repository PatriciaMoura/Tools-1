package model;

import java.util.Date;

public class Pessoa {

// Nome das colunas
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOME = "nome";
    public static final String COLUMN_RG = "RG";
    public static final String COLUMN_CPF ="CPF";
    public static final String COLUMN_DATANASC = "datanasc";
    public static final String COLUMN_TIPOSANGUE = "TipoSangue";
    public static final String COLUMN_TELEFONE = "telefone";
    public static final String COLUMN_CONTATOEMERGENCIA = "contatoemergencia";
    public static final String COLUMN_ALERGIA = "alergia";

    // Criando tabela

    public static final String SQL_PESSOA = COLUMN_ID    + " INTEGER PRIMEARY KEY AUTOINVREMENT, "
            + COLUMN_NOME                + " TEXT,"
            + COLUMN_RG                  + " INTEGER,"
            + COLUMN_CPF                 + " TEXT, "
            + COLUMN_DATANASC            + " TEXT,"
            + COLUMN_TIPOSANGUE          + " TEXT, "
            + COLUMN_TELEFONE            + " INTEGER, "
            + COLUMN_CONTATOEMERGENCIA   + " INTEGER,"
            + COLUMN_ALERGIA             + " TEXT,";

    private int id;
    private int rg;
    private String telefone;
    private String contatoemergencia;
    private String nome, cpf, tiposangue, alergia;
    private Date datanasc;


    public int getId () { return id; }
    public void setId (int id) { this.id = id; }

    public int getRg () { return rg;}
    public void setRg (int rg) { this.rg = rg;}

    public String gettelefone () { return telefone; }
    public void setTelefone (String telefone) { this.telefone = telefone;}

    public String getContatoemergencia () { return contatoemergencia; }
    public void setContatoemergencia (String contatoemergencia) { this.contatoemergencia = contatoemergencia; }

    public String getNome () { return nome; }
    public void setNome (String nome) { this.nome = nome; }

    public String getCpf () { return cpf; }
    public void setCpf (String cpf) {this.cpf = cpf; }

    public String getTiposangue () { return tiposangue; }
    public void setTiposangue (String tiposangue) { this.tiposangue = tiposangue; }

    public String getAlergia () { return alergia;}
    public void  setAlergia (String alergia) { this.alergia = alergia;}

    public Date getDatanasc () { return datanasc; }
    public void setDatanasc (Date datanasc) {this.datanasc = datanasc}









}
