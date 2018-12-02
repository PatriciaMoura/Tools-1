package model;


public class TipoSangue_model {

    public static final String TABLE = "tiposanguineo";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TIPOSANGUINEO = "tiposanguineo";

    public static final String SQL_CREATE = "CREATE TABLE " + TABLE + "( "
            + COLUMN_ID                     + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_TIPOSANGUINEO          + " TEXT)";

    private int id;
    private String tiposanguineo;

    public int getId () { return id; }
    public void setId (int id) { this.id = id; }

    public String getTiposanguineo () { return tiposanguineo;}
    public void setTiposanguineo (String tiposanguineo) {this.tiposanguineo = tiposanguineo;}

}

