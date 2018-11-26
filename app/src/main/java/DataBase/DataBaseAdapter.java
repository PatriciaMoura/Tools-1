package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import model.Filmes_model;
import model.Games_model;
import model.Livros_model;
import model.Musica_model;
import model.Series_model;
import model.Viagens_model;

public class DataBaseAdapter extends SQLiteOpenHelper {
    public DataBaseAdapter (Context context) {super(context, "tools.db", null, 1);}


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Ficha_Medica.SQL_CREATE);
        db.execSQL(Viagens_model.SQL_CREATE);
        db.execSQL(Series_model.SQL_CREATE);
        db.execSQL(Musica_model.SQL_CREATE);
        db.execSQL(Livros_model.SQL_CREATE);
        db.execSQL(Games_model.SQL_CREATE);
        db.execSQL(Filmes_model.SQL_CREATE);
    }

    @Override
    public void onUpgrade (SQLiteDatabase sqLiteDatabase, int i, int il){

    }

}
