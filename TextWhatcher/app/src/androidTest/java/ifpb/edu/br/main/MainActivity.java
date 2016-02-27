package ifpb.edu.br.main;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ifpb.edu.br.asynctask.BuscaAsyncTask;
import ifpb.edu.br.asynctask.NomesInterface;
import ifpb.edu.br.textwhatcher.R;

/**
 * Created by Bruno on 26/02/2016. Parte 1 da atv
 */

public class MainActivity extends Activity implements TextWatcher, NomesInterface {
    // Define o tamanho mínimo do texto para consulta no servidor.
    private static int TAMANHO_MINIMO_TEXTO = 4;

    private EditText nomeEditText;
    List<String> nomes;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Inicialização da activity e definição do layout.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recuperando o EditText e
        nomeEditText = (EditText) findViewById(R.id.editTextWatch);
        nomeEditText.addTextChangedListener(this);

        ListView nomesListView = (ListView) findViewById(R.id.listView1);
        nomes = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                nomes);

        nomesListView.setAdapter(adapter);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

        Log.i("EditTextListener", "beforeTextChanged: " + charSequence);
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

        Log.i("EditTextListener", "onTextChanged: " + charSequence);
        String nome = charSequence.toString();

        // Consultar o servidor. Criar o JSONObject e uma AsyncTask<JSONObject, Void, Response>

        if (nome.length() >= TAMANHO_MINIMO_TEXTO) {
            // JSON
            JSONObject json = new JSONObject();
            try {
                json.put("fullName", nome);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            BuscaAsyncTask buscarNomeAsyncTask = new BuscaAsyncTask(this);
            buscarNomeAsyncTask.execute(json);
            // Adicionar ao ListView.
            nomes.add(nome);
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void afterTextChanged(Editable editable) {

        Log.i("EditTextListener","afterTextChanged: " + editable);
    }

    @Override
    public void BuscaNome(List<String> nome) {
        // TODO Auto-generated method stub
        nomes.clear();
        nomes.addAll(nome);
        adapter.notifyDataSetChanged();
        // Toast.makeText(this, "chegou", Toast.LENGTH_LONG);


    }
}