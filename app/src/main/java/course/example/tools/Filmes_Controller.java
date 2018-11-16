package course.example.tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import model.DateUtil;
import model.Filmes_model;

public class Filmes_Controller extends BaseController<Filmes_model> {

    public Filmes_Controller (Context context) {
        super(context);
    }

    //INSERT
    public boolean insert(Filmes_model filmes) {
        boolean IsCreate = db.insert(Filmes_model.TABLE, null, convertToContentValue(filmes)) > 0;
        return IsCreate;
    }


    @Override
    protected Filmes_model convertToObject(Cursor c) {
        Filmes_model filmes_model = new Filmes_model();

        int columnId = c.getColumnIndex(Filmes_model.COLUMN_ID);
        filmes_model.setId(c.getInt(columnId));

        columnId = c.getColumnIndex(Filmes_model.COLUMN_NOMEFILME);
        filmes_model.setNomefilme(c.getString(columnId));

        columnId = c.getColumnIndex(Filmes_model.COLUMN_DIRETORFILME);
        filmes_model.setDiretorfilme(c.getString(columnId));

        columnId = c.getColumnIndex(Filmes_model.COLUMN_DATALANCAMENTOFILME);
        filmes_model.setDatalancamentofilme(DateUtil.stringToDate(c.getString(columnId)));

        columnId = c.getColumnIndex(Filmes_model.COLUMN_ATRIZPRINCIPALFILME);
        filmes_model.setAtrizprincipalfilme(c.getString(columnId));

        columnId = c.getColumnIndex(Filmes_model.COLUMN_ATORPRINCIPALFILME);
        filmes_model.setAtorprincipalfilme(c.getString(columnId));

        columnId = c.getColumnIndex(Filmes_model.COLUMN_CLASSIFICACAOFILME);
        filmes_model.setClassificacaofilme(c.getInt(columnId));

        columnId = c.getColumnIndex(Filmes_model.COLUMN_PRODUTORAFILME);
        filmes_model.setProdutorafilme(c.getString(columnId));

        columnId = c.getColumnIndex(Filmes_model.COLUMN_GENEROFILME);
        filmes_model.setGenerofilme(c.getString(columnId));

        columnId = c.getColumnIndex(Filmes_model.COLUMN_MUSICATEMA);
        filmes_model.setMusicatema(c.getString(columnId));

        columnId = c.getColumnIndex(Filmes_model.COLUMN_DURACAO);
        filmes_model.setDuracao(c.getString(columnId));


        return filmes_model;
    }

    @Override
    protected String[] getColumns() {
        return new String[]{Filmes_model.COLUMN_ID, Filmes_model.COLUMN_NOMEFILME, Filmes_model.COLUMN_DIRETORFILME, Filmes_model.COLUMN_DATALANCAMENTOFILME,
                Filmes_model.COLUMN_ATRIZPRINCIPALFILME, Filmes_model.COLUMN_ATORPRINCIPALFILME, Filmes_model.COLUMN_CLASSIFICACAOFILME, Filmes_model.COLUMN_PRODUTORAFILME,
                Filmes_model.COLUMN_GENEROFILME, Filmes_model.COLUMN_MUSICATEMA, Filmes_model.COLUMN_DURACAO};
    }

    protected ContentValues convertToContentValue(Filmes_model filmes_model) {
        ContentValues values = new ContentValues();

        values.put(Filmes_model.COLUMN_NOMEFILME, filmes_model.getNomefilme());
        values.put(Filmes_model.COLUMN_DIRETORFILME, filmes_model.getDiretorfilme());
        values.put(Filmes_model.COLUMN_DATALANCAMENTOFILME, DateUtil.dateToString(filmes_model.getDatalancamentofilme()));
        values.put(Filmes_model.COLUMN_ATRIZPRINCIPALFILME, filmes_model.getAtorprincipalfilme());
        values.put(Filmes_model.COLUMN_ATORPRINCIPALFILME, filmes_model.getAtorprincipalfilme());
        values.put(Filmes_model.COLUMN_CLASSIFICACAOFILME, filmes_model.getClassificacaofilme());
        values.put(Filmes_model.COLUMN_PRODUTORAFILME, filmes_model.getProdutorafilme());
        values.put(Filmes_model.COLUMN_GENEROFILME, filmes_model.getGenerofilme());
        values.put(Filmes_model.COLUMN_MUSICATEMA, filmes_model.getMusicatema());
        values.put(Filmes_model.COLUMN_DURACAO, filmes_model.getDuracao());

        return values;
    }

    @Override
    protected String getTable() {
        return Filmes_model.TABLE;
    }

    @Override
    protected String getColumnId() {
        return Filmes_model.COLUMN_ID;
    }

}
