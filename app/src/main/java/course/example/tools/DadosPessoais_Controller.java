package com.example.patricia.cad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import model.DadosPessoais_model;
import model.DateUtil;

public class DadosPessoais_Controller extends BaseController <DadosPessoais_model> {
    public DadosPessoais_Controller(Context context) {
        super(context);
    } //integração com o banco


    public boolean insert (DadosPessoais_model dadosPessoais){
        boolean isCreate = db.insert(DadosPessoais_model.TABLE, null, convertToContentValue (dadosPessoais)) > 0;
        return isCreate;
    }

    @Override

    protected DadosPessoais_model convertToObject (Cursor c){
        DadosPessoais_model dadosPessoaisModel = new DadosPessoais_model();

        int columnId = c.getColumnIndex(DadosPessoais_model.COLUMN_ID);
        dadosPessoaisModel.setId(c.getInt(columnId));

        columnId = c.getColumnIndex(DadosPessoais_model.COLUMN_NOME);
        dadosPessoaisModel.setNome(c.getString(columnId));

        columnId = c.getColumnIndex(DadosPessoais_model.COLUMN_RG);
        dadosPessoaisModel.setRg(c.getInt(columnId));

        columnId = c.getColumnIndex(DadosPessoais_model.COLUMN_CPF);
        dadosPessoaisModel.setCpf(c.getString(columnId));

        columnId = c.getColumnIndex(DadosPessoais_model.COLUMN_PESO);
        dadosPessoaisModel.setPeso(c.getDouble(columnId));

        columnId = c.getColumnIndex(DadosPessoais_model.COLUMN_ALTURA);
        dadosPessoaisModel.setAltura(c.getDouble(columnId));

        columnId = c.getColumnIndex(DadosPessoais_model.COLUMN_DATANASC);
        dadosPessoaisModel.setDatanasc(DateUtil.stringToDate(c.getString(columnId)));

        columnId = c.getColumnIndex(DadosPessoais_model.COLUMN_TELEFONE);
        dadosPessoaisModel.setTelefone(c.getString(columnId));

        columnId = c.getColumnIndex(DadosPessoais_model.COLUMN_CONTATOEMERGENCIA);
        dadosPessoaisModel.setContatoemergencia(c.getString(columnId));

        columnId = c.getColumnIndex(DadosPessoais_model.COLUMN_TIPOSANGUE);
        dadosPessoaisModel.setTiposangue(c.getString(columnId));

        columnId = c.getColumnIndex(DadosPessoais_model.COLUMN_ALERGIA);
        dadosPessoaisModel.setAlergia(c.getString(columnId));

        return dadosPessoaisModel;
    }

    @Override
    protected String[] getColumns(){
        return new String[]{DadosPessoais_model.COLUMN_ID, DadosPessoais_model.COLUMN_NOME, DadosPessoais_model.COLUMN_RG,
                DadosPessoais_model.COLUMN_CPF, DadosPessoais_model.COLUMN_PESO, DadosPessoais_model.COLUMN_ALTURA,
                DadosPessoais_model.COLUMN_DATANASC, DadosPessoais_model.COLUMN_TELEFONE,
                DadosPessoais_model.COLUMN_CONTATOEMERGENCIA, DadosPessoais_model.COLUMN_TIPOSANGUE, DadosPessoais_model.COLUMN_ALERGIA};
    }

    protected ContentValues convertToContentValue(DadosPessoais_model dadosPessoaisModel) {
        ContentValues values = new ContentValues();

        values.put(DadosPessoais_model.COLUMN_NOME, dadosPessoaisModel.getNome());
        values.put(DadosPessoais_model.COLUMN_RG, dadosPessoaisModel.getRg());
        values.put(DadosPessoais_model.COLUMN_CPF, dadosPessoaisModel.getCpf());
        values.put(DadosPessoais_model.COLUMN_PESO, dadosPessoaisModel.getPeso());
        values.put(DadosPessoais_model.COLUMN_ALTURA, dadosPessoaisModel.getAltura());
        values.put(DadosPessoais_model.COLUMN_DATANASC, DateUtil.dateToString(dadosPessoaisModel.getDatanasc()));
        values.put(DadosPessoais_model.COLUMN_TELEFONE, dadosPessoaisModel.gettelefone());
        values.put(DadosPessoais_model.COLUMN_CONTATOEMERGENCIA, dadosPessoaisModel.getContatoemergencia());
        values.put(DadosPessoais_model.COLUMN_TIPOSANGUE, dadosPessoaisModel.getTiposangue());
        values.put(DadosPessoais_model.COLUMN_ALERGIA, dadosPessoaisModel.getAlergia());

        return values;
    }

    @Override
    protected String getTable() {
        return DadosPessoais_model.TABLE;
    }

    @Override
    protected String getColumnId(){
        return DadosPessoais_model.COLUMN_ID;
    }




}
