package com.example.patricia.cad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.Date;

import model.DateUtil;
import model.Viagens_model;


public class Viagens_Controller extends BaseController<Viagens_model> {

    public Viagens_Controller(Context context){
        super(context);
    }

    //INSERT
    public boolean insert(Viagens_model viagens){
        boolean IsCreate = db.insert(Viagens_model.TABLE, null, convertToContentValue(viagens)) > 0;
        return IsCreate;
    }


    @Override
    protected Viagens_model convertToObject(Cursor c) {
        Viagens_model viagens_model = new Viagens_model ();

        int columnId = c.getColumnIndex(Viagens_model.COLUMN_ID);
        viagens_model.setId(c.getInt(columnId));

        columnId = c.getColumnIndex(Viagens_model.COLUMN_LOCAL);
        viagens_model.setLocal(c.getString(columnId));

        columnId = c.getColumnIndex(Viagens_model.COLUMN_DATAIDA);
        viagens_model.setDataida(DateUtil.stringToDate(c.getString(columnId)));

        columnId = c.getColumnIndex(Viagens_model.COLUMN_DATAVOLTA);
        viagens_model.setDatavolta(DateUtil.stringToDate(c.getString(columnId)));

        columnId = c.getColumnIndex(Viagens_model.COLUMN_CIAAEREA);
        viagens_model.setCiaaerea(c.getString(columnId));

        columnId = c.getColumnIndex(Viagens_model.COLUMN_VALOR);
        viagens_model.setValor(c.getString(columnId));

        columnId = c.getColumnIndex(Viagens_model.COLUMN_HOTEL);
        viagens_model.setHotel(c.getString(columnId));

        columnId = c.getColumnIndex(Viagens_model.COLUMN_TRANSLADO);
        viagens_model.setTranslado(c.getString(columnId));

        columnId = c.getColumnIndex(Viagens_model.COLUMN_GUIA);
        viagens_model.setGuia(c.getString(columnId));

        columnId = c.getColumnIndex(Viagens_model.COLUMN_VISTO);
        viagens_model.setVisto(c.getString(columnId));



        return viagens_model;
    }

    @Override
    protected String[] getColumns() {
        return new String[]{Viagens_model.COLUMN_ID, Viagens_model.COLUMN_LOCAL, Viagens_model.COLUMN_DATAIDA, Viagens_model.COLUMN_DATAVOLTA,
                Viagens_model.COLUMN_CIAAEREA, Viagens_model.COLUMN_VALOR, Viagens_model.COLUMN_HOTEL, Viagens_model.COLUMN_TRANSLADO,
                Viagens_model.COLUMN_GUIA, Viagens_model.COLUMN_VISTO};
    }

    protected ContentValues convertToContentValue(Viagens_model viagens_model) {
        ContentValues values = new ContentValues();

        values.put(Viagens_model.COLUMN_LOCAL, viagens_model.getLocal());
        values.put(Viagens_model.COLUMN_DATAIDA, DateUtil.dateToString(viagens_model.getDataida()));
        values.put(Viagens_model.COLUMN_DATAVOLTA, DateUtil.dateToString (viagens_model.getDatavolta()));
        values.put(Viagens_model.COLUMN_CIAAEREA, viagens_model.getCiaaerea());
        values.put(Viagens_model.COLUMN_VALOR, viagens_model.getValor());
        values.put(Viagens_model.COLUMN_HOTEL, viagens_model.getHotel());
        values.put(Viagens_model.COLUMN_TRANSLADO, viagens_model.getTranslado());
        values.put(Viagens_model.COLUMN_GUIA, viagens_model.getGuia());
        values.put(Viagens_model.COLUMN_VISTO, viagens_model.getVisto());


        return values;
    }

    @Override
    protected String getTable() {
        return Viagens_model.TABLE;
    }

    @Override
    protected String getColumnId(){
        return Viagens_model.COLUMN_ID;
    }
}

