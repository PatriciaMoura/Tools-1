package View;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import course.example.tools.Cadastro_Livro;
import model.Ficha_Medica;


public class CadastroLivroView extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener{

        private ListView listView;
        private EditText editText;
        ArrayAdapter<String> adapter;
        List<Ficha_Medica> CadastroLivroList; // é a classe model?
        private List<String> FichaMedicaListNome = new ArrayList<String>();
        private Cadastro_Livro cadastroLivroController;
        private ImageView imageView;
}
