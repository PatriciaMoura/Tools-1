package model;



public class Genero_model {

    public static final String TABLE = "genero";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOMEGENERO = "nome";

    public static final String SQL_CREATE = "CREATE TABLE " + TABLE + "( "
            + COLUMN_ID                     + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NOMEGENERO              + " TEXT)";

    private int id;
    private String nomegenero;

    public int getId () { return id; }
    public void setId (int id) { this.id = id; }

    public String getNomegenero () { return nomegenero;}
    public void setNomegenero (String nomegenero) {this.nomegenero = nomegenero;}

}
