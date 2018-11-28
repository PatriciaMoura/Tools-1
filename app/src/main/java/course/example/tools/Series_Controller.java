package com.example.patricia.cad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.Date;

import model.DateUtil;
import model.Series_model;

public class Series_Controller extends BaseController<Series_model> {

    public Series_Controller (Context context) {
        super(context);
    }

    //INSERT
    public boolean insert(Series_model series) {
        boolean IsCreate = db.insert(Series_model.TABLE, null, convertToContentValue(series)) > 0;
        return IsCreate;
    }


    @Override
    protected Series_model convertToObject(Cursor c) {
        Series_model series_model = new Series_model();

        int columnId = c.getColumnIndex(Series_model.COLUMN_ID);
        series_model.setId(c.getInt(columnId));

        columnId = c.getColumnIndex(Series_model.COLUMN_NOMESERIE);
        series_model.setNomeserie(c.getString(columnId));

        columnId = c.getColumnIndex(Series_model.COLUMN_DIRETORSERIE);
        series_model.setDiretorserie(c.getString(columnId));

        columnId = c.getColumnIndex(Series_model.COLUMN_DATALANCAMENTOSERIE);
        series_model.setDatalancamentoserie(DateUtil.stringToDate(c.getString(columnId)));

        columnId = c.getColumnIndex(Series_model.COLUMN_ATRIZPRINCIPALSERIE);
        series_model.setAtrizprincipalserie(c.getString(columnId));

        columnId = c.getColumnIndex(Series_model.COLUMN_ATORPRINCIPALSERIE);
        series_model.setAtorprincipalserie(c.getString(columnId));

        columnId = c.getColumnIndex(Series_model.COLUMN_CLASSIFICACAOSERIE);
        series_model.setClassificacaoserie(c.getInt(columnId));

        columnId = c.getColumnIndex(Series_model.COLUMN_PRODUTORASERIE);
        series_model.setProdutoraserie(c.getString(columnId));

        columnId = c.getColumnIndex(Series_model.COLUMN_IDGENERO);
        series_model.setIdGenero(c.getInt(columnId));

        columnId = c.getColumnIndex(Series_model.COLUMN_QUANTTEMPORADAS);
        series_model.setQuanttemporadas(c.getInt(columnId));

        columnId = c.getColumnIndex(Series_model.COLUMN_QUANTCAPITULOSSERIE);
        series_model.setQuantcapitulosserie(c.getInt(columnId));




        return series_model;
    }

    @Override
    protected String[] getColumns() {
        return new String[]{Series_model.COLUMN_ID, Series_model.COLUMN_NOMESERIE, Series_model.COLUMN_DIRETORSERIE, Series_model.COLUMN_DATALANCAMENTOSERIE,
                Series_model.COLUMN_ATRIZPRINCIPALSERIE, Series_model.COLUMN_ATORPRINCIPALSERIE, Series_model.COLUMN_CLASSIFICACAOSERIE, Series_model.COLUMN_PRODUTORASERIE,
                Series_model.COLUMN_IDGENERO, Series_model.COLUMN_QUANTTEMPORADAS, Series_model.COLUMN_QUANTCAPITULOSSERIE};
    }

    protected ContentValues convertToContentValue(Series_model series_model) {
        ContentValues values = new ContentValues();

        values.put(Series_model.COLUMN_NOMESERIE, series_model.getNomeserie());
        values.put(Series_model.COLUMN_DIRETORSERIE, series_model.getDiretorserie());
        values.put(Series_model.COLUMN_DATALANCAMENTOSERIE, DateUtil.dateToString(series_model.getDatalancamentoserie()));
        values.put(Series_model.COLUMN_ATRIZPRINCIPALSERIE, series_model.getAtorprincipalserie());
        values.put(Series_model.COLUMN_ATORPRINCIPALSERIE, series_model.getAtorprincipalserie());
        values.put(Series_model.COLUMN_CLASSIFICACAOSERIE, series_model.getClassificacaoserie());
        values.put(Series_model.COLUMN_PRODUTORASERIE, series_model.getProdutoraserie());
        values.put(Series_model.COLUMN_IDGENERO, series_model.getIdGenero());
        values.put(Series_model.COLUMN_QUANTTEMPORADAS, series_model.getQuanttemporadas());
        values.put(Series_model.COLUMN_QUANTCAPITULOSSERIE, series_model.getQuantcapitulosserie());


        return values;
    }

    @Override
    protected String getTable() {
        return Series_model.TABLE;
    }

    @Override
    protected String getColumnId() {
        return Series_model.COLUMN_ID;
    }

}

