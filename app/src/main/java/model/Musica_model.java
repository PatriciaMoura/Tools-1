package model;

import java.util.Date;

/**
 * Created by Patricia on 23/11/2018.
 */

public class Musica_model {
    //Nome tabela

    public static final String TABLE = "musica";

    //Nome colunas
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ARTISTA = "artista";
    public static final String COLUMN_ALBUM = "album";
    public static final String COLUMN_GENEROMUSICAL = "generomusical";
    public static final String COLUMN_DATALANCAMENTOMUSICA = "datalancamentomusica";
    public static final String COLUMN_QUANTFAIXAS = "quantfaixas";
    public static final String COLUMN_GRAVADORAMUSICA = "gravadoramusica";
    public static final String COLUMN_PRODUTORAMUSICA = "produtoramusica";
    public static final String COLUMN_ESTUDIO = "estudio";
    public static final String COLUMN_FAIXAFAVORITA = "faixafavorita";
    public static final String COLUMN_PREMIO = "premio";

    //Criando tabela

    public static final String SQL_CREATE = "CREATE TABLE " + TABLE + "( "
            + COLUMN_ID                      + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_ARTISTA                 + " TEXT,"
            + COLUMN_ALBUM                   + " TEXT,"
            + COLUMN_GENEROMUSICAL           + " TEXT,"
            + COLUMN_DATALANCAMENTOMUSICA    + " TEXT,"
            + COLUMN_QUANTFAIXAS             + " INTEGER,"
            + COLUMN_GRAVADORAMUSICA         + " TEXT,"
            + COLUMN_PRODUTORAMUSICA         + " TEXT,"
            + COLUMN_ESTUDIO                 + " TEXT,"
            + COLUMN_FAIXAFAVORITA           + " TEXT,"
            + COLUMN_PREMIO                  + " TEXT)";

    private int id;
    private String artista, album, generomusical, gravadoramusica, produtoramusica, estudio, premio, faixafavorita;
    private int quantfaixas;
    private Date datalancamentomusica;

    public int getId () { return id; }
    public void setId (int id) { this.id = id; }

    public String getArtista () { return artista ;}
    public void setArtista (String artista ) {this.artista = artista;}

    public String getAlbum () { return album ;}
    public void setAlbum (String  album) {this.album = album;}

    public String getGeneromusical () { return generomusical ;}
    public void setGeneromusical (String generomusical) {this.generomusical = generomusical;}

    public Date getDatalancamentomusica () { return datalancamentomusica ;}
    public void setDatalancamentomusica (Date datalancamentomusica ) {this.datalancamentomusica = datalancamentomusica;}

    public Integer getQuatfaixas () { return quantfaixas ;}
    public void setQuantfaixas (Integer quantfaixas ) {this.quantfaixas = quantfaixas ;}

    public String getGravadoramusica () { return gravadoramusica ;}
    public void setGravadoramusica (String gravadoramusica) {this.gravadoramusica = gravadoramusica;}

    public String getProdutoramusica () { return produtoramusica ;}
    public void setProdutoramusica (String produtoramusica) {this.produtoramusica = produtoramusica;}

    public String getEstudio () { return estudio ;}
    public void setEstudio (String estudio ) {this.estudio = estudio;}

    public String getFaixafavorita () { return faixafavorita ;}
    public void setFaixafavorita (String faixafavorita) {this.faixafavorita = faixafavorita;}

    public String getPremio () { return premio;}
    public void setPremio (String premio ) {this.premio = premio ;}

}
