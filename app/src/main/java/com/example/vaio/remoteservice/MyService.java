package com.example.vaio.remoteservice;

import android.Manifest;
import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;


/**
 * Created by vaio on 11/9/2016.
 */

public class MyService extends Service {
    public static final String KEY_URI = "key_uri";
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;

    private MediaPlayer mediaPlayer ;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return function.asBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int  startId) {

        String data = intent.getStringExtra(KEY_URI);
//        if(mediaPlayer!=null){
//            mediaPlayer.release();
//        }
//        mediaPlayer = MediaPlayer.create(this, Uri.parse(data));
//        mediaPlayer.start();
        Toast.makeText(this,data,Toast.LENGTH_SHORT).show();

        return START_NOT_STICKY;
    }
    private Function function = new Function.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void create(String uri) throws RemoteException {
//            if (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.MEDIA_CONTENT_CONTROL) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions((Activity) getBaseContext(), new String[]{Manifest.permission.MEDIA_CONTENT_CONTROL}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);
//            }
            if(mediaPlayer!=null){
                mediaPlayer.release();
            }
            mediaPlayer = MediaPlayer.create(MyService.this,Uri.parse(uri));
        }

        @Override
        public void start() throws RemoteException {
            if(mediaPlayer!=null){
                mediaPlayer.start();
            }
        }

        @Override
        public void pause() throws RemoteException {
            if (mediaPlayer!=null){
                mediaPlayer.pause();
            }
        }

        @Override
        public void stop() throws RemoteException {
            if (mediaPlayer!=null){
                mediaPlayer.stop();
            }
        }

        @Override
        public boolean isPlaying() throws RemoteException {
            if(mediaPlayer!=null) {
                return mediaPlayer.isPlaying();
            }
            return false;
        }

        @Override
        public int getCurrentDuration() throws RemoteException {
            if(mediaPlayer!=null){
                return mediaPlayer.getCurrentPosition();
            }
            return 0;
        }

        @Override
        public int getDuration() throws RemoteException {
            if(mediaPlayer!=null){
                return mediaPlayer.getDuration();
            }
            return 0;
        }

        @Override
        public void seekTo(int position) throws RemoteException {
            if(mediaPlayer!=null){
                mediaPlayer.seekTo(position);
            }
        }

    };

}
