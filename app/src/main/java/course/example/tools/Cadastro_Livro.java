package course.example.tools;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import model.Livros_model;

public class Cadastro_Livro extends BaseController <Livros_model> {

    public Cadastro_Livro(Context context) {
        super(context);

    } //integração com o banco

    public boolean insert(model.Livros_model livros_model) {
        boolean isCreate = db.insert(model.Livros_model.TABLE, null, convertToContentValue(livros_model)) > 0;
        return isCreate;
    }


    @Override

    protected model.Livros_model convertToObject(Cursor c) {
        model.Livros_model livros_model = new model.Livros_model();

        int columnId = c.getColumnIndex(livros_model.COLUMN_ID);
        livros_model.setId(c.getInt(columnId));

        columnId = c.getColumnIndex(Livros_model.COLUMN_TITULO);
        livros_model.setTitulo(c.getString(columnId));

        columnId = c.getColumnIndex(Livros_model.COLUMN_AUTOR);
        livros_model.setAutor(c.getString(columnId));

        columnId = c.getColumnIndex(Livros_model.COLUMN_EDITORA);
        livros_model.setEditora(c.getString(columnId));

        return livros_model;
    }

    @Override
    protected String[] getColumns(){
        return new String[]{Livros_model.COLUMN_ID, Livros_model.COLUMN_TITULO, Livros_model.COLUMN_AUTOR,
                Livros_model.COLUMN_EDITORA};
    }

    protected ContentValues convertToContentValue(Livros_model livros_model) {
        ContentValues values = new ContentValues();

        values.put(Livros_model.COLUMN_TITULO, livros_model.getTitulo());
        values.put(Livros_model.COLUMN_AUTOR, livros_model.getAutor());
        values.put(Livros_model.COLUMN_EDITORA, livros_model.getEditora());

        return values;
    }

    @Override
    protected String getTable() {
        return Livros_model.TABLE; }

    @Override
    protected String getColumnId(){
        return Livros_model.COLUMN_ID;
    }

}
