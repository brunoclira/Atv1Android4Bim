package ifpb.edu.br.textwhatcher;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

/**
 * Created by Bruno on 22/02/2016. Parte 1 da atv
 */
public class ListaText extends Activity implements TextWatcher {

    //Adapter e lista

    @Override
    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
        Log.i("TextWhatcher","beforeTextChanged: " + charSequence);
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
        Log.i("TextWhatcher","onTextChanged: " + charSequence);
    }

    @Override
    public void afterTextChanged(Editable editable) {

        Log.i("TextWhatcher","afterTextChanged: " + editable);
    }
}


