package com.example.patricia.cad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.Date;

import model.DateUtil;

import model.Livros_model;

public class Livro_Controller extends BaseController <Livros_model> {

    public Livro_Controller(Context context) {
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

        columnId = c.getColumnIndex(Livros_model.COLUMN_DATALANCAMENTOLIVRO);
        livros_model.setDatalancamentolivro(DateUtil.stringToDate(c.getString(columnId)));

        columnId = c.getColumnIndex(Livros_model.COLUMN_EDITORA);
        livros_model.setEditora(c.getString(columnId));

        columnId = c.getColumnIndex(Livros_model.COLUMN_EDICAO);
        livros_model.setEdicao(c.getString(columnId));

        columnId = c.getColumnIndex(Livros_model.COLUMN_PAISORIGEM);
        livros_model.setPaisorigem(c.getString(columnId));

        columnId = c.getColumnIndex(Livros_model.COLUMN_QUANTCAPITULOLIVRO);
        livros_model.setQuantcapitulolivro(c.getString(columnId));

        columnId = c.getColumnIndex(Livros_model.COLUMN_QUANTPAGINA);
        livros_model.setQuantpagina(c.getString(columnId));

        columnId = c.getColumnIndex(Livros_model.COLUMN_GENEROLIVRO);
        livros_model.setGenerolivro(c.getString(columnId));

        columnId = c.getColumnIndex(Livros_model.COLUMN_DATACOMPRA);
        livros_model.setDatacompra(DateUtil.stringToDate(c.getString(columnId)));


        return livros_model;
    }

    @Override
    protected String[] getColumns(){
        return new String[]{Livros_model.COLUMN_ID, Livros_model.COLUMN_TITULO, Livros_model.COLUMN_AUTOR,
                Livros_model.COLUMN_DATALANCAMENTOLIVRO, Livros_model.COLUMN_EDITORA, Livros_model.COLUMN_EDICAO,
                Livros_model.COLUMN_PAISORIGEM, Livros_model.COLUMN_QUANTCAPITULOLIVRO, Livros_model.COLUMN_QUANTPAGINA,
                Livros_model.COLUMN_GENEROLIVRO, Livros_model.COLUMN_DATACOMPRA};
    }

    protected ContentValues convertToContentValue(Livros_model livros_model) {
        ContentValues values = new ContentValues();

        values.put(Livros_model.COLUMN_TITULO, livros_model.getTitulo());
        values.put(Livros_model.COLUMN_AUTOR, livros_model.getAutor());
        values.put(Livros_model.COLUMN_DATALANCAMENTOLIVRO, DateUtil.dateToString(livros_model.getDatalancamentolivro()));
        values.put(Livros_model.COLUMN_EDITORA, livros_model.getEditora());
        values.put(Livros_model.COLUMN_EDICAO, livros_model.getEdicao());
        values.put(Livros_model.COLUMN_PAISORIGEM, livros_model .getPaisorigem());
        values.put(Livros_model.COLUMN_QUANTCAPITULOLIVRO, livros_model.getQuantcapitulolivro());
        values.put(Livros_model.COLUMN_QUANTPAGINA, livros_model.getQuantpagina());
        values.put(Livros_model.COLUMN_GENEROLIVRO, livros_model.getGenerolivro());
        values.put(Livros_model.COLUMN_DATACOMPRA, DateUtil.dateToString(livros_model.getDatacompra()));


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