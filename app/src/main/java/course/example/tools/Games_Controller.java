package com.example.patricia.cad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import model.DateUtil;
import model.Games_model;



public class Games_Controller extends BaseController<Games_model> {

    public Games_Controller (Context context) {
        super(context);
    }

    //INSERT
    public boolean insert(Games_model games) {
        boolean IsCreate = db.insert(Games_model.TABLE, null, convertToContentValue(games)) > 0;
        return IsCreate;
    }


    @Override
    protected Games_model convertToObject(Cursor c) {
        Games_model games_model = new Games_model();

        int columnId = c.getColumnIndex(Games_model.COLUMN_ID);
        games_model.setId(c.getInt(columnId));

        columnId = c.getColumnIndex(Games_model.COLUMN_NOMEGAMES);
        games_model.setNomegames(c.getString(columnId));

        columnId = c.getColumnIndex(Games_model.COLUMN_ABREVIACAO);
        games_model.setAbreviacao(c.getString(columnId));

        columnId = c.getColumnIndex(Games_model.COLUMN_GENEROGAMES);
        games_model.setGenerogames(c.getString(columnId));

        columnId = c.getColumnIndex(Games_model.COLUMN_DATALANCAMENTOGAMES);
        games_model.setDatalancamentogames(DateUtil.stringToDate(c.getString(columnId)));

        columnId = c.getColumnIndex(Games_model.COLUMN_MODOJOGO);
        games_model.setModojogo(c.getString(columnId));

        columnId = c.getColumnIndex(Games_model.COLUMN_PUBLICADORA);
        games_model.setPublicadora(c.getString(columnId));

        columnId = c.getColumnIndex(Games_model.COLUMN_DESENVOLVEDORA);
        games_model.setDesenvolvedora(c.getString(columnId));

        columnId = c.getColumnIndex(Games_model.COLUMN_QUANTLANCADAGAMES);
        games_model.setQuantlancadagames(c.getInt(columnId));

        columnId = c.getColumnIndex(Games_model.COLUMN_PLATAFORMAS);
        games_model.setPlataformas(c.getString(columnId));

        columnId = c.getColumnIndex(Games_model.COLUMN_MELHORFRANQUIA);
        games_model.setMelhorfranquia(c.getString(columnId));


        return games_model;
    }

    @Override
    protected String[] getColumns() {
        return new String[]{Games_model.COLUMN_ID, Games_model.COLUMN_NOMEGAMES, Games_model.COLUMN_ABREVIACAO, Games_model.COLUMN_GENEROGAMES,
                Games_model.COLUMN_DATALANCAMENTOGAMES, Games_model.COLUMN_MODOJOGO, Games_model.COLUMN_PUBLICADORA, Games_model.COLUMN_DESENVOLVEDORA,
                Games_model.COLUMN_QUANTLANCADAGAMES, Games_model.COLUMN_PLATAFORMAS, Games_model.COLUMN_MELHORFRANQUIA};
    }

    protected ContentValues convertToContentValue(Games_model games_model) {
        ContentValues values = new ContentValues();

        values.put(Games_model.COLUMN_NOMEGAMES, games_model.getNomegames());
        values.put(Games_model.COLUMN_ABREVIACAO, games_model.getAbreviacao());
        values.put(Games_model.COLUMN_GENEROGAMES, games_model.getGenerogames());
        values.put(Games_model.COLUMN_DATALANCAMENTOGAMES, DateUtil.dateToString(games_model.getDatalancamentogames()));
        values.put(Games_model.COLUMN_MODOJOGO, games_model.getModojogo());
        values.put(Games_model.COLUMN_PUBLICADORA, games_model.getPublicadora());
        values.put(Games_model.COLUMN_DESENVOLVEDORA, games_model.getDesenvolvedora());
        values.put(Games_model.COLUMN_QUANTLANCADAGAMES, games_model.getQuantlancadaGames());
        values.put(Games_model.COLUMN_PLATAFORMAS, games_model.getPlataformas());
        values.put(Games_model.COLUMN_MELHORFRANQUIA, games_model.getMelhorfranquia());

        return values;
    }

    @Override
    protected String getTable() {
        return Games_model.TABLE;
    }

    @Override
    protected String getColumnId() {
        return Games_model.COLUMN_ID;
    }

}


