package course.example.tools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity {

    private EditText campo;
    private Button somar, subtrair, multiplicar,
            dividir, igual, limpar;

    double numero1, numero2, resultado;
    int operacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campo = (EditText)findViewById(R.id.campo);
        somar = (Button)findViewById(R.id.somar);
        subtrair = (Button)findViewById(R.id.subtrair);
        multiplicar = (Button)findViewById(R.id.multiplicar);
        dividir = (Button)findViewById(R.id.dividir);
        igual = (Button)findViewById(R.id.igual);
        limpar = (Button)findViewById(R.id.limpar);


        operacao = 0; //Informa qual operação será executada
        numero1 = 0.0; //Primeiro número digitado
        numero2 = 0.0; //Segundo número digitado após clicar na operação desejada
        resultado = 0.0; //Resultado que será exibido no campo

        //Iniciar o app com os botões de operação desabilitados

        somar.setEnabled(false);
        subtrair.setEnabled(false);
        multiplicar.setEnabled(false);
        dividir.setEnabled(false);
        igual.setEnabled(false);


        campo.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                if(campo.getText().toString().equals("")){
                    somar.setEnabled(false);
                    subtrair.setEnabled(false);
                    multiplicar.setEnabled(false);
                    dividir.setEnabled(false);
                    igual.setEnabled(false);
                } else {
                    somar.setEnabled(true);
                    subtrair.setEnabled(true);
                    multiplicar.setEnabled(true);
                    dividir.setEnabled(true);
                    igual.setEnabled(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });

        /**
         * Listener que fica esperando apertar o botão
         * para efetuar a soma. Ele guarda o primeiro
         * número digitado, diz qual a operação que será
         * executada (1 = soma) ao clicar no botão igual
         * e limpa o campo para digitar o segundo número.
         */
        somar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                numero1 = Double.parseDouble(campo.getText().toString());
                operacao = 1;
                campo.setText("");
            }
        });


        subtrair.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                numero1 = Double.parseDouble(campo.getText().toString());
                operacao = 2;
                campo.setText("");
            }
        });


        multiplicar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                numero1 = Double.parseDouble(campo.getText().toString());
                operacao = 3;
                campo.setText("");
            }
        });


        dividir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                numero1 = Double.parseDouble(campo.getText().toString());
                operacao = 4;
                campo.setText("");
            }
        });

        /**
         * Listener que fica esperando apertar o botão
         * para efetuar a operação e exibir o resultado.
         */
        igual.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (operacao) {
                    case 1:
                        numero2 = Double.parseDouble(campo.getText().toString());
                        resultado = numero1 + numero2;
                        campo.setText(String.valueOf(resultado));
                        igual.setEnabled(false);
                        break;

                    case 2:
                        numero2 = Double.parseDouble(campo.getText().toString());
                        resultado = numero1 - numero2;
                        campo.setText(String.valueOf(resultado));
                        igual.setEnabled(false);
                        break;

                    case 3:
                        numero2 = Double.parseDouble(campo.getText().toString());
                        resultado = numero1 * numero2;
                        campo.setText(String.valueOf(resultado));
                        igual.setEnabled(false);
                        break;

                    case 4:
                        numero2 = Double.parseDouble(campo.getText().toString());
                        resultado = numero1 / numero2;
                        campo.setText(String.valueOf(resultado));
                        igual.setEnabled(false);
                        break;
                }
            }
        });

        /**
         * Listener que fica esperando apertar o botão
         * para efetuar limpar o campo e as variáveis
         * numero1, numero2, resultado e operacao.
         * Também inabilita os botões das operações,
         * para digitar o primeiro número novamente.
         */
        limpar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                campo.setText("");
                numero1 = 0.0;
                numero2 = 0.0;
                resultado = 0.0f;
                operacao = 0;
            }
        });
    }
}
