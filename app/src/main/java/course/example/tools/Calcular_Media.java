package course.example.tools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calcular_Media extends AppCompatActivity {

    private EditText txtNota1;
    private EditText txtNota2;
    private EditText txtNota3;
    private Button btnCalcular;
    private TextView txtMediaFinal;
    private double nota1;
    private double nota2;
    private double nota3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular__media);

        txtNota1 = (EditText) findViewById(R.id.txtNota1);
        txtNota2 = (EditText) findViewById(R.id.txtNota2);
        txtNota3 = (EditText) findViewById(R.id.txtNota3);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        txtMediaFinal = (TextView) findViewById(R.id.txtMediaFinal);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                nota1 = Double.parseDouble(txtNota1.getText().toString());
                nota2 = Double.parseDouble(txtNota2.getText().toString());
                nota3 = Double.parseDouble(txtNota3.getText().toString());

                Double media = calcularMedia(nota1, nota2, nota3);
                txtMediaFinal.setText(media.toString());
            }
        });

    }

    private double calcularMedia(double n1, double n2, double n3) {
        double mediaFinal = (n1 + n2 + n3) / 3;
        return mediaFinal;
    }
}
