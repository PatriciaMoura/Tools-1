package View.Cadastro;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import model.DateUtil;
import model.Ficha_Medica;
import View.Cadastro.FichaMedicaView;
import course.example.tools.Ficha_Medica_Controller;


import java.util.ArrayList;
import java.util.List;

public class FichaMedicaCadastro implements DialogInterface.OnShowListener, View.OnClickListener, DialogInterface.OnDismissListener {

    private Ficha_Medica_Controller fichaMedicaController;

    private List<String> listaFichaMedica = new ArrayList<String>();

}

}
