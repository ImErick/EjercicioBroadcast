package mx.iteso.erickgarcia.ejerciciobroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

/**
 * Created by erickgarcia on 14/02/18.
 */

public class BroadcastServicesBattery extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int batteryLvl = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
        Toast.makeText(context, "el nivel de tu bateria es "+ String.valueOf(batteryLvl), Toast.LENGTH_SHORT).show();
    }
}
