package mx.iteso.erickgarcia.ejerciciobroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by erickgarcia on 14/02/18.
 * clase para saber los metodos del broadcast receiver
 */

public class BroadcastServices extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED))
            Toast.makeText(context, "tu dispositivo se esta cargando", Toast.LENGTH_SHORT).show();
        else if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED))
            Toast.makeText(context, "tu dispositivo esta desconectado", Toast.LENGTH_SHORT).show();
    }
}
