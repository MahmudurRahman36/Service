package com.cse24gmail.jakir.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    private static final String TAG="MyService";
    public MyService() {
    }

    MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(MyService.this, "onBind()", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"OnBind()");
        return null;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        player=MediaPlayer.create(this,R.raw.tum_hu);
        Toast.makeText(MyService.this, "onCreate()", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(MyService.this, "onStartCommand()", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onStartCommand()");
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(MyService.this, "onStart()", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onStart()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        Toast.makeText(MyService.this, "onDestroy()", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onDestroy()");
    }

}
