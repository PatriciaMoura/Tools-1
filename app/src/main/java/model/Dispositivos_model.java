package model;

import java.util.Date;

public class Dispositivos_model {

    //Nome tabela

    public static final String TABLE = "Dispositivos";

    //Nome colunas

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DIPOSITIVO = "dispositivo";
    public static final String COLUMN_MARCA = "marca";
    public static final String COLUMN_DATALANCAMENTODISP = "datalancamentodisp";
    public static final String COLUMN_COR = "cor";
    public static final String COLUMN_MEMORIA = "memoria";
    public static final String COLUMN_PIXELS = "pixels";
    public static final String COLUMN_LOJA = "lojacompra";
    public static final String COLUMN_GARANTIA = "garantia";
    public static final String COLUMN_DIVIDE = "divide";
    public static final String COLUMN_SOFTWARE = "software";

    //Criando tabela

    public static final String SQL_CREATE = "CREATE TABLE" + TABLE + "( "
            + COLUMN_ID                     + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_DIPOSITIVO             + "TEXT,"
            + COLUMN_MARCA                  + "TEXT,"
            + COLUMN_DATALANCAMENTODISP     + "TEXT,"
            + COLUMN_COR                    + "TEXT,"
            + COLUMN_MEMORIA                + "INTEGER,"
            + COLUMN_PIXELS                 + "INTEGER,"
            + COLUMN_LOJA                   + "TEXT,"
            + COLUMN_GARANTIA               + "TEXT,"
            + COLUMN_DIVIDE                 + "INTEGER,"
            + COLUMN_SOFTWARE               + "TEXT,)";

    private int id, divide, memoria, pixels;
    private String dispositivo, marca, cor, lojacompra, garantia, software;
    private Date datalancamentodisp;


    public int getId () { return id; }
    public void setId (int id) { this.id = id; }

    public String getDispositivo () { return dispositivo;}
    public void setDispositivo (String dispositivo) {this.dispositivo = dispositivo;}

    public String getMarca () {return marca;}
    public void setMarca (String marca) {this.marca = marca;}

    public Date getColumnDatalancamentodisp () {return datalancamentodisp;}
    public void setDatalancamentodisp (Date datalancamentodisp) {this.datalancamentodisp = datalancamentodisp;}

    public String getCor () {return cor;}
    public void setCor (String cor) {this.cor = cor;}

    public Integer getMemoria () {return memoria;}
    public void setMemoria (Integer memoria) {this.memoria = memoria;}

    public Integer getPixels () {return pixels;}
    public void setPixels (Integer pixels) {this.pixels = pixels;}

    public String getLojacompra () {return lojacompra;}
    public void setLojacompra (String lojacompra) {this.lojacompra = lojacompra;}

    public String getGarantia () {return garantia;}
    public void setGarantia (String garantia) {this.garantia = garantia;}

    public Integer getDivide () {return divide;}
    public void setDivide (Integer divide) {this.divide = divide;}

    public String getSoftware () {return software;}
    public void setSoftware (String software) {this.software = software;}


}
