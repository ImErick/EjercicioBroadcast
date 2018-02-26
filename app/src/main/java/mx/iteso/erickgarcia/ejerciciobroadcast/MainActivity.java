package mx.iteso.erickgarcia.ejerciciobroadcast;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// TODO: diferencia entre extends AppCompatActivity y Activity??
public class MainActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btnNotificacion);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // creando la notificacion
                NotificationCompat.Builder notification = new android.support.v7.app.NotificationCompat.Builder(MainActivity.this);
                notification.setSmallIcon(R.drawable.ic_info_black_24dp);
                notification.setContentTitle("Esta es una notificacion weona");
                notification.setContentText("peluche en el estuche prro");

                // agregandole funcionalidad a la notificacion
                Intent intent = new Intent(MainActivity.this, ActivityClima.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                // addAction solo le hace caso al boton de continuar y setContentIntent a todo
                notification.addAction(R.drawable.ic_info_black_24dp, "Apashurrame", pendingIntent);
                notification.setContentIntent(pendingIntent);

                // hacer la notificacion mas grande, sustituye al contentText cuando esta en modo extendido
                notification.setStyle(new NotificationCompat.BigTextStyle().bigText("peluchote en el estuchote"));

                // disparando la notificacion
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(001, notification.build());

                // hacer que vibre cuando llegue la notificacion: intensidad/tiempo
                long[] vibra = {500, 1000};
                notification.setVibrate(vibra);
            }
        });
    }

    /* hay dos maneras de mandar a llamar el broadcast receiver, la que esta aqui abajo es para
    que solo el broadcast receiver funcione cuando la app este abierta aka onResume porque de la
    otra manera ya vimos que era de manera global por lo que hasta cerandola se abrian los toast */
    @Override
    protected void onResume() {
        super.onResume();
        BroadcastReceiver broadcastReceiver = new BroadcastServices();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        registerReceiver(broadcastReceiver, intentFilter);

        BroadcastServicesBattery broadcastServicesBattery = new BroadcastServicesBattery();
        IntentFilter intentFilterBattery = new IntentFilter();
        intentFilterBattery.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(broadcastServicesBattery, intentFilterBattery);
    }
}
