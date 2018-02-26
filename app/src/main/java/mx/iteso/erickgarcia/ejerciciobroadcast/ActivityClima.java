package mx.iteso.erickgarcia.ejerciciobroadcast;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by erickgarcia on 14/02/18.
 */

public class ActivityClima extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clima_layout);

    }
}
