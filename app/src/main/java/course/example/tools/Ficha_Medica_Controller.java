package course.example.tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import model.DateUtil;
import model.Ficha_Medica;

//criado em 12/10/2018


public class Ficha_Medica_Controller extends BaseController<model.Ficha_Medica> {
    public Ficha_Medica_Controller(Context context) {
        super(context);
    } //integração com o banco


   public boolean insert (Ficha_Medica_Controller ficha_medica){
        boolean isCreate = db.insert(model.Ficha_Medica.TABLE, null, convertToContentValue(ficha_medica)) > 0;
        return isCreate;
   }

   @Override

    protected model.Ficha_Medica convertToObject (Cursor c){
       model.Ficha_Medica ficha_medica = new model.Ficha_Medica();

       int columnId = c.getColumnIndex(model.Ficha_Medica.COLUMN_ID);
       ficha_medica.setId(c.getInt(columnId));

       columnId = c.getColumnIndex(model.Ficha_Medica.COLUMN_NOME);
       ficha_medica.setNome(c.getString(columnId));

       columnId = c.getColumnIndex(model.Ficha_Medica.COLUMN_RG);
       ficha_medica.setRg(c.getInt(columnId));

       columnId = c.getColumnIndex(model.Ficha_Medica.COLUMN_CPF);
       ficha_medica.setCpf(c.getString(columnId));

       columnId = c.getColumnIndex(model.Ficha_Medica.COLUMN_PESO);
       ficha_medica.setPeso(c.getDouble(columnId));

       columnId = c.getColumnIndex(model.Ficha_Medica.COLUMN_ALTURA);
       ficha_medica.setAltura(c.getDouble(columnId));

       columnId = c.getColumnIndex(model.Ficha_Medica.COLUMN_DATANASC);
       ficha_medica.setDatanasc(DateUtil.stringToDate(c.getString(columnId)));

       columnId = c.getColumnIndex(model.Ficha_Medica.COLUMN_TELEFONE);
       ficha_medica.setTelefone(c.getString(columnId));

       columnId = c.getColumnIndex(model.Ficha_Medica.COLUMN_CONTATOEMERGENCIA);
       ficha_medica.setContatoemergencia(c.getString(columnId));

       columnId = c.getColumnIndex(model.Ficha_Medica.COLUMN_TIPOSANGUE);
       ficha_medica.setTiposangue(c.getString(columnId));

       columnId = c.getColumnIndex(model.Ficha_Medica.COLUMN_ALERGIA);
       ficha_medica.setAlergia(c.getString(columnId));

       return ficha_medica;
   }

    @Override
    protected String[] getColumns(){
        return new String[]{model.Ficha_Medica.COLUMN_ID, model.Ficha_Medica.COLUMN_NOME, model.Ficha_Medica.COLUMN_RG,
                model.Ficha_Medica.COLUMN_CPF, model.Ficha_Medica.COLUMN_PESO, model.Ficha_Medica.COLUMN_ALTURA,
                model.Ficha_Medica.COLUMN_DATANASC, model.Ficha_Medica.COLUMN_TELEFONE,
                model.Ficha_Medica.COLUMN_CONTATOEMERGENCIA, model.Ficha_Medica.COLUMN_TIPOSANGUE, model.Ficha_Medica.COLUMN_ALERGIA};
    }

    protected ContentValues convertToContentValue(model.Ficha_Medica ficha_medica) {
        ContentValues values = new ContentValues();

        values.put(model.Ficha_Medica.COLUMN_NOME, ficha_medica.getNome());
        values.put(model.Ficha_Medica.COLUMN_RG, ficha_medica.getRg());
        values.put(model.Ficha_Medica.COLUMN_CPF, ficha_medica.getCpf());
        values.put(model.Ficha_Medica.COLUMN_PESO, ficha_medica.getPeso());
        values.put(model.Ficha_Medica.COLUMN_ALTURA, ficha_medica.getAltura());
        values.put(model.Ficha_Medica.COLUMN_DATANASC, DateUtil.dateToString(ficha_medica.getDatanasc()));
        values.put(model.Ficha_Medica.COLUMN_TELEFONE, ficha_medica.gettelefone());
        values.put(model.Ficha_Medica.COLUMN_CONTATOEMERGENCIA, ficha_medica.getContatoemergencia());
        values.put(model.Ficha_Medica.COLUMN_TIPOSANGUE, ficha_medica.getTiposangue());
        values.put(model.Ficha_Medica.COLUMN_ALERGIA, ficha_medica.getAlergia());

        return values;
    }

    @Override
    protected String getTable() {
        return model.Ficha_Medica.TABLE;
    }

    @Override
    protected String getColumnId(){
        return model.Ficha_Medica.COLUMN_ID;
    }


}


