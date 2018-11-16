package View.Cadastro;

import course.example.tools.Livro_Controller;

import android.app.AlertDialog;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
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

import com.airam.helpfisio.controller.HospitalController;
import com.airam.helpfisio.controller.LeitoController;
import com.airam.helpfisio.model.DateUtil;
import com.airam.helpfisio.model.Hospital;
import com.airam.helpfisio.model.Leito;
import com.airam.helpfisio.view.PacienteView;
import com.airam.helpfisio.R;
import com.airam.helpfisio.controller.PacienteController;
import com.airam.helpfisio.model.Paciente;


public class LivrosCadastro {
    private EditText editTextTitulo, editTextAutor, editTextEditora;

    private Livro_Controller _livroController;
    private AlertDialog dialog;
    private EditText editTextTitulo, editTextAutor, editTextEditora;

    private List<String> listaCadastroLivros = new ArrayList<String>();

}
