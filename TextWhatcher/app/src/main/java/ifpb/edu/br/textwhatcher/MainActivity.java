package ifpb.edu.br.textwhatcher;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends Activity implements TextWatcher {

    private ArrayAdapter<String> adapter;
    private ArrayList<String> lista;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		/* Initializing views */
        EditText editText1 = (EditText) findViewById(R.id.editText1);
        editText1.addTextChangedListener(this);
        ListView nomesList = (ListView) findViewById(R.id.listaNomes);
        lista = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        nomesList.setAdapter(adapter);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // Log.i("editText1", "beforeTextChanged " + s);

    }

    @Override
    public void onTextChanged(CharSequence CharSequence, int start, int before, int count) {
        // Log.i("editText1", "beforeTextChanged " + s);
        String nomes = CharSequence.toString();
        JSONObject json = new JSONObject();
        lista.add(nomes);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void afterTextChanged(Editable s) {
        // Log.i("editText1", "beforeTextChanged " + s);

    }

}

