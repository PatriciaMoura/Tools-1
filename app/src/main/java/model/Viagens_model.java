package model;

import java.util.Date;

/**
 * Created by Patricia on 23/11/2018.
 */

public class Viagens_model {

    public static final String TABLE = "viagens";

    //Nome colunas

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_LOCAL = "local";
    public static final String COLUMN_DATAIDA = "dataida";
    public static final String COLUMN_DATAVOLTA = "datavolta";
    public static final String COLUMN_CIAAEREA = "ciaaerea";
    public static final String COLUMN_VALOR = "valor";
    public static final String COLUMN_HOTEL = "hotel";
    public static final String COLUMN_TRANSLADO = "translado";
    public static final String COLUMN_GUIA = "guia";
    public static final String COLUMN_VISTO = "visto";

    //Criando tabela

    public static final String SQL_CREATE = "CREATE TABLE " + TABLE + "( "
            + COLUMN_ID               + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_LOCAL            + " TEXT,"
            + COLUMN_DATAIDA          + " TEXT,"
            + COLUMN_DATAVOLTA        + " TEXT,"
            + COLUMN_CIAAEREA         + " TEXT,"
            + COLUMN_VALOR            + " TEXT,"
            + COLUMN_HOTEL            + " TEXT,"
            + COLUMN_TRANSLADO        + " TEXT,"
            + COLUMN_GUIA             + " TEXT,"
            + COLUMN_VISTO            + " TEXT)";

    private int id;
    private String local, ciaaerea, valor, hotel, translado, guia, visto;
    private Date dataida, datavolta;

    public int getId () { return id; }
    public void setId (int id) { this.id = id; }

    public String getLocal () { return local ;}
    public void setLocal (String local) {this.local = local;}

    public Date getDataida () { return dataida ;}
    public void setDataida (Date dataida) {this.dataida = dataida;}

    public Date getDatavolta () { return datavolta ;}
    public void setDatavolta (Date datavolta) {this.datavolta = datavolta;}

    public String getCiaaerea () { return ciaaerea ;}
    public void setCiaaerea (String ciaaerea ) {this.ciaaerea = ciaaerea;}

    public String getValor () { return valor ;}
    public void setValor (String valor) {this.valor = valor;}

    public String getHotel () { return hotel;}
    public void setHotel (String hotel) {this.hotel = hotel;}

    public String getTranslado () { return translado ;}
    public void setTranslado (String translado) {this.translado = translado;}

    public String getGuia () { return guia ;}
    public void setGuia (String guia) {this.guia = guia;}

    public String getVisto () { return visto ;}
    public void setVisto (String visto) {this.visto = visto;}


}
