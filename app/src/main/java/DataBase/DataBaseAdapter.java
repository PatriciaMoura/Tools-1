package DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import model.Ficha_Medica;

public class DataBaseAdapter extends SQLiteOpenHelper {
    public DataBaseAdapter (Context context) {super(context, "tools.db", null, 1);}


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Ficha_Medica.SQL_CREATE);
    }

    @Override
    public void onUpgrade (SQLiteDatabase sqLiteDatabase, int i, int il){

    }

}
