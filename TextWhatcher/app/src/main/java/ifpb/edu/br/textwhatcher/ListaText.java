package ifpb.edu.br.textwhatcher;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

/**
 * Created by Bruno on 22/02/2016.
 */
public class ListaText extends Activity implements TextWatcher {

    @Override
    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
        Log.i("charSequence","beforeTextChanged");
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
        Log.i("charSequence","onTextChanged");
    }

    @Override
    public void afterTextChanged(Editable editable) {
        Log.i("editable","afterTextChanged");
    }
}
