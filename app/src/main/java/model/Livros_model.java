package model;

public class Livros_model {

    //Nome tabela

    public static final String TABLE = "Livros";

    //Nome colunas
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITULO = "titulo";
    public static final String COLUMN_AUTOR = "autor";
    public static final String COLUMN_EDITORA = "editora";

    //Criando tabela

    public static final String SQL_CREATE = "CREATE TABLE" + TABLE + "( "
            + COLUMN_ID        + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_TITULO    + "TEXT,"
            + COLUMN_AUTOR     + "TEXT,"
            + COLUMN_EDITORA   + "TEXT )";

    private int id;
    private String titulo, autor, editora;

    public int getId () { return id; }
    public void setId (int id) { this.id = id; }

    public String getTitulo () { return titulo;}
    public void setTitulo (String titulo) {this.titulo = titulo;}

    public String getAutor () {return autor;}
    public void setAutor (String autor) {this.autor = autor;}

    public String getEditora () {return editora;}
    public void setEditora (String editora) {this.editora = editora;}


}
