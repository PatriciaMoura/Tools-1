package com.example.patricia.cad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import model.Genero_model;

public class Genero_Controller extends BaseController<Genero_model>{

    public Genero_Controller (Context context) {
        super(context);
    }

    //INSERT
    public boolean insert(Genero_model filmes) {
        boolean IsCreate = db.insert(Genero_model.TABLE, null, convertToContentValue(filmes)) > 0;
        return IsCreate;
    }


    @Override
    protected Genero_model convertToObject(Cursor c) {
        Genero_model genero_model = new Genero_model();

        int columnId = c.getColumnIndex(Genero_model.COLUMN_ID);
        genero_model.setId(c.getInt(columnId));

        columnId = c.getColumnIndex(Genero_model.COLUMN_NOMEGENERO);
        genero_model.setNomegenero(c.getString(columnId));

        return genero_model;
    }

    @Override
    protected String[] getColumns() {
        return new String[]{Genero_model.COLUMN_ID, Genero_model.COLUMN_NOMEGENERO};
    }

    protected ContentValues convertToContentValue(Genero_model genero_model) {
        ContentValues values = new ContentValues();

        values.put(Genero_model.COLUMN_NOMEGENERO, genero_model.getNomegenero());

        return values;
    }

    @Override
    protected String getTable() {
        return Genero_model.TABLE;
    }

    @Override
    protected String getColumnId() {
        return Genero_model.COLUMN_ID;
    }

}
