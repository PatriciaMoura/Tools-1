package model;

import java.util.Date;

public class Games_model {

    public static final String TABLE = "Games";

    //Nome colunas
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOMEGAMES = "nomegames";
    public static final String COLUMN_ABREVIACAO = "abreviacao";
    public static final String COLUMN_GENEROGAMES = "generogames";
    public static final String COLUMN_DATALANCAMENTOGAMES = "datalancamentogames";
    public static final String COLUMN_MODOJOGO = "modojogo";
    public static final String COLUMN_PUBLICADORA = "publicadora";
    public static final String COLUMN_DESENVOLVEDORA = "desenvolvedora";
    public static final String COLUMN_QUANTLANCADAGAMES = "quantlancadagames";
    public static final String COLUMN_PLATAFORMAS = "plataformas";
    public static final String COLUMN_MELHORFRANQUIA = "melhorfranquia";

    //Criando tabela

    public static final String SQL_CREATE = "CREATE TABLE" + TABLE + "( "
            + COLUMN_ID                      + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NOMEGAMES               + "TEXT,"
            + COLUMN_ABREVIACAO              + "TEXT,"
            + COLUMN_DATALANCAMENTOGAMES     + "TEXT,"
            + COLUMN_GENEROGAMES             + "TEXT,"
            + COLUMN_MODOJOGO                + "TEXT,"
            + COLUMN_PUBLICADORA             + "TEXT,"
            + COLUMN_DESENVOLVEDORA          + "TEXT,"
            + COLUMN_QUANTLANCADAGAMES       + "INTEGER,"
            + COLUMN_PLATAFORMAS             + "TEXT,"
            + COLUMN_MELHORFRANQUIA          + "TEXT,)";

    private int id;
    private String nomegames, abreviacao, generogames, modojogo, publicadora, desenvolvedora, plataformas, melhorfranquia;
    private Date datalancamentogames;
    private Integer quantlancadagames;

    public int getId () { return id; }
    public void setId (int id) { this.id = id; }

    public String getNomegames () { return nomegames;}
    public void setNomegames (String nomegames) {this.nomegames = nomegames;}

    public String getAbreviacao () {return abreviacao;}
    public void setAbreviacao (String abreviacao) {this.abreviacao = abreviacao;}

    public Date getDatalancamentogames () {return datalancamentogames;}
    public void setDatalancamentogames (Date datalancamentogames) {this.datalancamentogames = datalancamentogames;}

    public String getGenerogames () {return generogames;}
    public void setGenerogames (String generogames) {this.generogames = generogames;}

    public String getModojogo () {return modojogo;}
    public void setModojogo (String modojogo) {this.modojogo = modojogo;}

    public String getPublicadora () {return publicadora;}
    public void setPublicadora (String publicadora) {this.publicadora = publicadora;}

    public String getDesenvolvedora () {return desenvolvedora;}
    public void setDesenvolvedora (String desenvolvedora) {this.desenvolvedora = desenvolvedora;}

    public String getPlataformas () {return plataformas;}
    public void setPlataformas (String plataformas) {this.plataformas = plataformas;}

    public String getMelhorfranquia () {return melhorfranquia;}
    public void setMelhorfranquia (String melhorfranquia) {this.melhorfranquia = melhorfranquia;}

    public Integer getQuantlancadaGames () {return quantlancadagames;}
    public void setQuantlancadagames (Integer quantlancadagames) {this.quantlancadagames = quantlancadagames;}


}
