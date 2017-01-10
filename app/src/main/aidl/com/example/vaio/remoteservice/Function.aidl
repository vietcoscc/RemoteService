// Function.aidl
package com.example.vaio.remoteservice;

// Declare any non-default types here with import statements
interface Function {

    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,double aDouble, String aString);

            void create(String uri);
            void start();
            void pause();
            void stop();
            boolean isPlaying();
            int getCurrentDuration();
            int getDuration();
 void seekTo(int position);
}