package com.example.valentinkajdan.firstappli;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent notifIntent=PendingIntent.getActivity(this, 0, intent, 0);
        NotificationCompat.Builder builder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("Actualités")
                        .setContentText("Les notifications sont activées")
                        .setContentIntent(notifIntent);

        NotificationManager notificationManager = (NotificationManager) this.getSystemService(this.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());


        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new
                MyPagerAdapter(getSupportFragmentManager()));


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_preference) {
            Intent intent=new Intent(this, PreferencesActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
