package course.example.tools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import model.DateUtil;
import model.Dispositivos_model;


public class Dispositivos_Controller extends BaseController<Dispositivos_model> {

    public Dispositivos_Controller (Context context) {
        super(context);
    }

    //INSERT
    public boolean insert(Dispositivos_model dispositivos) {
        boolean IsCreate = db.insert(Dispositivos_model.TABLE, null, convertToContentValue(dispositivos)) > 0;
        return IsCreate;
    }


    @Override
    protected Dispositivos_model convertToObject(Cursor c) {
        Dispositivos_model dispositivos_model = new Dispositivos_model();

        int columnId = c.getColumnIndex(Dispositivos_model.COLUMN_ID);
        dispositivos_model.setId(c.getInt(columnId));

        columnId = c.getColumnIndex(Dispositivos_model.COLUMN_DIPOSITIVO);
        dispositivos_model.setDispositivo(c.getString(columnId));

        columnId = c.getColumnIndex(Dispositivos_model.COLUMN_MARCA);
        dispositivos_model.setMarca(c.getString(columnId));

        columnId = c.getColumnIndex(Dispositivos_model.COLUMN_DATALANCAMENTODISP);
        dispositivos_model.setDatalancamentodisp(DateUtil.stringToDate(c.getString(columnId)));

        columnId = c.getColumnIndex(Dispositivos_model.COLUMN_COR);
        dispositivos_model.setCor(c.getString(columnId));

        columnId = c.getColumnIndex(Dispositivos_model.COLUMN_MEMORIA);
        dispositivos_model.setMemoria(c.getInt(columnId));

        columnId = c.getColumnIndex(Dispositivos_model.COLUMN_PIXELS);
        dispositivos_model.setPixels(c.getInt(columnId));

        columnId = c.getColumnIndex(Dispositivos_model.COLUMN_LOJA);
        dispositivos_model.setLojacompra(c.getString(columnId));

        columnId = c.getColumnIndex(Dispositivos_model.COLUMN_GARANTIA);
        dispositivos_model.setGarantia(c.getString(columnId));

        columnId = c.getColumnIndex(Dispositivos_model.COLUMN_DIVIDE);
        dispositivos_model.setDivide(c.getInt(columnId));

        columnId = c.getColumnIndex(Dispositivos_model.COLUMN_SOFTWARE);
        dispositivos_model.setSoftware(c.getString(columnId));


        return dispositivos_model;
    }

    @Override
    protected String[] getColumns() {
        return new String[]{Dispositivos_model.COLUMN_ID, Dispositivos_model.COLUMN_DIPOSITIVO, Dispositivos_model.COLUMN_MARCA,
                Dispositivos_model.COLUMN_DATALANCAMENTODISP, Dispositivos_model.COLUMN_COR,Dispositivos_model.COLUMN_MEMORIA,
                Dispositivos_model.COLUMN_PIXELS, Dispositivos_model.COLUMN_LOJA, Dispositivos_model.COLUMN_GARANTIA,
                Dispositivos_model.COLUMN_DIVIDE, Dispositivos_model.COLUMN_SOFTWARE};
    }

    protected ContentValues convertToContentValue(Dispositivos_model dispositivos_model) {
        ContentValues values = new ContentValues();

        values.put(Dispositivos_model.COLUMN_DIPOSITIVO, dispositivos_model.getDispositivo());
        values.put(Dispositivos_model.COLUMN_MARCA, dispositivos_model.getMarca());
        values.put(Dispositivos_model.COLUMN_DATALANCAMENTODISP, DateUtil.dateToString(dispositivos_model.getColumnDatalancamentodisp()));
        values.put(Dispositivos_model.COLUMN_COR, dispositivos_model.getCor());
        values.put(Dispositivos_model.COLUMN_MEMORIA, dispositivos_model.getMemoria());
        values.put(Dispositivos_model.COLUMN_PIXELS, dispositivos_model.getPixels());
        values.put(Dispositivos_model.COLUMN_LOJA, dispositivos_model.getLojacompra());
        values.put(Dispositivos_model.COLUMN_GARANTIA, dispositivos_model.getGarantia());
        values.put(Dispositivos_model.COLUMN_DIVIDE, dispositivos_model.getDivide());
        values.put(Dispositivos_model.COLUMN_SOFTWARE, dispositivos_model.getSoftware());

        return values;
    }

    @Override
    protected String getTable() {
        return Dispositivos_model.TABLE;
    }

    @Override
    protected String getColumnId() {
        return Dispositivos_model.COLUMN_ID;
    }

}
