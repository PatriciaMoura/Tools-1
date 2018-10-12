package course.example.tools;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ListActivity {

    private static final String[] nomes = new String[]{"Cadastro", "IMC", "SpeechToText", "Calculadora", "Sair"};

        @Override
        public void onCreated(Bundle icicle){
            super.onCreate(icicle);
            this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes));
        }

        @Override
                protected void onListItemClick (ListView l, View v, int position, long id){
            switch (position)
            {
                case 0:
                    startActivity(new Intent(this, Cadastro.class));
                    break;
                case 1:
                    startActivity(new Intent(this, IMC.class));
                    break;
                case 2:
                    startActivity(new Intent(this, SpeechToText.class));
                    break;
                case 3:
                    startActivity(new Intent(this, Calculadora.class));
                case 4:
                    startActivity(new Intent(this, Calcular_Media.class));
                default:
                finish();
            }
        }
    }
}
