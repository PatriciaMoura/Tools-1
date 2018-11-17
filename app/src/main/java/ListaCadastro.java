import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import View.Games_View;
import View.Livros_View;
import View.Viagens_View;
import View.Series_View;
import View.FilmesView;
import View.Musica_View;
import View.FichaMedica_View;
import View.Cadastro.GamesCadastro;
import View.Cadastro.LivrosCadastro;
import View.Cadastro.ViagensCadastro;
import View.Cadastro.SeriesCadastro;
import View.Cadastro.FilmesCadastro;
import View.Cadastro.MusicaCadastro;
import View.Cadastro.FichaMedicaCadastro;


public class ListaCadastro extends ListActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.cadastro));
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent;

        switch (position) {
            case 0:
                intent = new Intent(ListaCadastros.this, FichaMedica_View.class);
                startActivity(intent);
                break;

            case 1:
                intent = new Intent(ListaCadastros.this, FilmesView.class);
                startActivity(intent);
                // LeitoCadastro leitoCadastro = new LeitoCadastro(v);

                break;

            case 2:
                intent = new Intent(ListaCadastros.this, Games_View.class);
                startActivity(intent);

                //MedicoCadastro medicoCadastro= new MedicoCadastro(v);

                break;

            case 3:
                intent = new Intent(ListaCadastros.this, Livros_View.class);
                startActivity(intent);

                //HospitalCadastro hospitalCadastro = new HospitalCadastro(v);

                break;

            case 4:
                intent = new Intent(ListaCadastros.this, Musica_View.class);
                startActivity(intent);
                //ConsultaMedicoCadastro consultaMedicoCadastro= new ConsultaMedicoCadastro(v);

                break;

            case 5:
                intent = new Intent(ListaCadastros.this, Series_View.class);
                startActivity(intent);

                //FisioterapeutaCadastro fisioterapeutaCadastro= new FisioterapeutaCadastro(v);

                break;

            case 6:
                intent = new Intent(ListaCadastros.this, Viagens_View.class);
                startActivity(intent);
                //ConsultaFisioCadastro consultaFisioCadastro= new ConsultaFisioCadastro(v);

                break;

           default:
                finish();
        }
    }

    private void dispararIntent(Intent intent){
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.erro_intent, Toast.LENGTH_SHORT).show();
        }
    }

}
