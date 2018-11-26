package course.example.tools;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Button btnDadosPessoais, btnViagens, btnDispositivos, btnMusica, btnGames, btnLivros, btnFilmes, btnSeries;


    protected void onCreated (Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        btnDadosPessoais = (Button) findViewById(R.id.btnDadosPessoais);
        btnDadosPessoais.setOnClickListener(this);

        btnViagens = (Button) findViewById(R.id.btnIMC);
        btnViagens.setOnClickListener(this);

        btnDispositivos = (Button) findViewById(R.id.btnDispositivos);
        btnDispositivos.setOnClickListener(this);

        btnMusica = (Button) findViewById(R.id.btnCalculadora);
        btnMusica.setOnClickListener(this);

        btnGames = (Button) findViewById(R.id.btnCalcularMedia);
        btnGames.setOnClickListener(this);

        btnLivros = (Button) findViewById(R.id.btnCadastrarLivros);
        btnLivros.setOnClickListener(this);

        btnFilmes = (Button) findViewById(R.id.btnCadastrarFilmes);
        btnFilmes.setOnClickListener(this);

        btnSeries = (Button) findViewById(R.id.btnCadastrarSeries);
        btnSeries.setOnClickListener(this);
    }



        @Override
                public void onClick (View view){

            switch (view.getId()){

                case R.id.btnDadosPessoais:
                    intent = new Intent(MainActivity.this, DadosPessoais_Controller.class);
                    startActivity(intent);
                    break;

                case R.id.btnViagens:
                    intent = new Intent(MainActivity.this, Viagens_Controller.class);
                    startActivity(intent);
                    break;

                case R.id.btnDispositivos:
                    intent = new Intent(MainActivity.this, Dispositivos_Controller.class);
                    startActivity(intent);
                    break;

                case R.id.btnMusica:
                    intent = new Intent(MainActivity.this, Musica_Controller.class);
                    startActivity(intent);
                    break;

                case R.id.btnGames:
                    intent = new Intent(MainActivity.this, Games_Controller.class);
                    startActivity(intent);
                    break;

                case R.id.btnLivros:
                    intent = new Intent(MainActivity.this, Livro_Controller.class);
                    startActivity(intent);

                case R.id.btnFilmes:
                    intent = new Intent( MainActivity.this,Filmes_Controller.class);
                    startActivity(intent);

                case R.id.btnSeries:
                    intent = new Intent( MainActivity.this, Series_Controller.class);
                    startActivity(intent);
            }
        }

        @Override
    protected void onDestroy () {super.onDestroy();
}

}
