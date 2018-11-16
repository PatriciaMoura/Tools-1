package course.example.tools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.Date;

import model.DateUtil;
import model.Musica_model;

public class Musica_Controller extends BaseController<Musica_model> {

    public Musica_Controller (Context context) {
        super(context);
    }

    //INSERT
    public boolean insert(Musica_model musica) {
        boolean IsCreate = db.insert(Musica_model.TABLE, null, convertToContentValue(musica)) > 0;
        return IsCreate;
    }


    @Override
    protected Musica_model convertToObject(Cursor c) {
        Musica_model musica_model = new Musica_model();

        int columnId = c.getColumnIndex(Musica_model.COLUMN_ID);
        musica_model.setId(c.getInt(columnId));

        columnId = c.getColumnIndex(Musica_model.COLUMN_ARTISTA);
        musica_model.setArtista(c.getString(columnId));

        columnId = c.getColumnIndex(Musica_model.COLUMN_ALBUM);
        musica_model.setAlbum(c.getString(columnId));

        columnId = c.getColumnIndex(Musica_model.COLUMN_GENEROMUSICAL);
        musica_model.setGeneromusical(c.getString(columnId));

        columnId = c.getColumnIndex(Musica_model.COLUMN_DATALANCAMENTOMUSICA);
        musica_model.setDatalancamentomusica(DateUtil.stringToDate(c.getString(columnId)));

        columnId = c.getColumnIndex(Musica_model.COLUMN_QUANTFAIXAS);
        musica_model.setQuantfaixas(c.getInt(columnId));

        columnId = c.getColumnIndex(Musica_model.COLUMN_GRAVADORAMUSICA);
        musica_model.setGravadoramusica(c.getString(columnId));

        columnId = c.getColumnIndex(Musica_model.COLUMN_PRODUTORAMUSICA);
        musica_model.setProdutoramusica(c.getString(columnId));

        columnId = c.getColumnIndex(Musica_model.COLUMN_ESTUDIO);
        musica_model.setEstudio(c.getString(columnId));

        columnId = c.getColumnIndex(Musica_model.COLUMN_FAIXAFAVORITA);
        musica_model.setFaixafavorita(c.getInt(columnId));

        columnId = c.getColumnIndex(Musica_model.COLUMN_PREMIO);
        musica_model.setPremio(c.getString(columnId));

        return musica_model;
    }

    @Override
    protected String[] getColumns() {
        return new String[]{Musica_model.COLUMN_ID, Musica_model.COLUMN_ARTISTA, Musica_model.COLUMN_ALBUM, Musica_model.COLUMN_GENEROMUSICAL,
                Musica_model.COLUMN_DATALANCAMENTOMUSICA, Musica_model.COLUMN_QUANTFAIXAS, Musica_model.COLUMN_GRAVADORAMUSICA, Musica_model.COLUMN_PRODUTORAMUSICA,
                Musica_model.COLUMN_ESTUDIO, Musica_model.COLUMN_FAIXAFAVORITA, Musica_model.COLUMN_PREMIO};
    }

    protected ContentValues convertToContentValue(Musica_model musica_model) {
        ContentValues values = new ContentValues();

        values.put(Musica_model.COLUMN_ARTISTA, musica_model.getArtista());
        values.put(Musica_model.COLUMN_ALBUM, musica_model.getAlbum());
        values.put(Musica_model.COLUMN_GENEROMUSICAL, musica_model.getGeneromusical());
        values.put(Musica_model.COLUMN_DATALANCAMENTOMUSICA, DateUtil.dateToString(musica_model.getDatalancamentomusica()));
        values.put(Musica_model.COLUMN_QUANTFAIXAS, musica_model.getQuatfaixas());
        values.put(Musica_model.COLUMN_GRAVADORAMUSICA, musica_model.getGravadoramusica());
        values.put(Musica_model.COLUMN_PRODUTORAMUSICA, musica_model.getProdutoramusica());
        values.put(Musica_model.COLUMN_ESTUDIO, musica_model.getEstudio());
        values.put(Musica_model.COLUMN_FAIXAFAVORITA, musica_model.getFaixafavorita());
        values.put(Musica_model.COLUMN_PREMIO, musica_model.getPremio());

        return values;
    }

    @Override
    protected String getTable() {
        return Musica_model.TABLE;
    }

    @Override
    protected String getColumnId() {
        return Musica_model.COLUMN_ID;
    }

}
