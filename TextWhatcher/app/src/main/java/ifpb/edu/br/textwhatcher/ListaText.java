package ifpb.edu.br.textwhatcher;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno on 22/02/2016.
 */
public class ListaText extends Activity implements TextWatcher {

    //Adapter e lista

    private 

    EditText TextWhatcher = (EditText) findViewById(R.id.TextWhatcher);
    TextWatcher.addTextChangedListener(this);

    TextListView

    @Override
    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
        Log.i("TextWhatcher","beforeTextChanged: " + charSequence);
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
        Log.i("TextWhatcher","onTextChanged: " + charSequence);

        String nome = charSequence.toString();

        nomes.add(nome);

        adapter.notifyDataSetChanged();


    }

    @Override
    public void afterTextChanged(Editable editable) {

        Log.i("TextWhatcher","afterTextChanged: " + editable);
    }
}
