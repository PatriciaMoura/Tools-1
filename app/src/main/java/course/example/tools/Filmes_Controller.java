package course.example.tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import model.DateUtil;
import model.Filmes_model;

public class Filmes_Controller extends BaseController <Filmes_model> {
    public Filmes_Controller (Context context) {super(context);} //integração com o banco


    public boolean insert (Filmes_model filmes_model){
            boolean isCreate = db.insert(Filmes_model.TABLE, null, convertToContentValue (filmes_model)) > 0;
            return isCreate;
        }

        @Override

        protected Filmes_model convertToObject (Cursor c){
            Filmes_model filmes_model = new Filmes_model();

            int columnId = c.getColumnIndex(model.Ficha_Medica.COLUMN_ID);
            filmes_model.setId(c.getInt(columnId));

            columnId = c.getColumnIndex(model.Ficha_Medica.COLUMN_NOME);
            filmes_model.setNome(c.getString(columnId));

            columnId = c.getColumnIndex(model.Ficha_Medica.COLUMN_DIRETOR);
            filmes_model.set(c.getInt(columnId));



            return filmes_model;
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


}
