package course.example.tools;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Button btnFichaMedica, btnIMC, btnSpeech, btnCalculadora, btnCalcularMedia;


    protected void onCreated (Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        btnFichaMedica = (Button) findViewById(R.id.btnFichaMedica);
        btnFichaMedica.setOnClickListener(this);

        btnIMC = (Button) findViewById(R.id.btnIMC);
        btnIMC.setOnClickListener(this);

        btnSpeech = (Button) findViewById(R.id.btnSpeech);
        btnSpeech.setOnClickListener(this);

        btnCalculadora = (Button) findViewById(R.id.btnCalculadora);
        btnCalculadora.setOnClickListener(this);

        btnCalcularMedia = (Button) findViewById(R.id.btnCalcularMedia);
        btnCalcularMedia.setOnClickListener(this);
    }



        @Override
                public void onClick (View view){

            switch (view.getId()){

                case R.id.btnFichaMedica:
                    intent = new Intent(MainActivity.this, Ficha_Medica_Controller.class);
                    startActivity(intent);
                    break;

                case R.id.btnIMC:
                    intent = new Intent(MainActivity.this, IMC.class);
                    startActivity(intent);
                    break;

                case R.id.btnSpeech:
                    intent = new Intent(MainActivity.this, SpeechToText.class);
                    startActivity(intent);
                    break;

                case R.id.btnCalculadora:
                    intent = new Intent(MainActivity.this, Calculadora.class);
                    startActivity(intent);
                    break;

                case R.id.btnCalcularMedia:
                    intent = new Intent(MainActivity.this, Calcular_Media.class);
                    startActivity(intent);
                    break;
            }
        }

        @Override
    protected void onDestroy () {super.onDestroy();
}

}
