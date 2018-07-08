package com.mtbsgmz.encryptedcontacts.com.mtbsgmz.tools;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Android uygulama içinde
 * kullanılacak araçlar burada bulunur.
 */
public class AndroTool extends Application {

    private static Application App;

    public AndroTool() {
        App = this;
    }

    public static Application getApp() {
        return App;
    }

    public static void setApp(Application app) {
        App = app;
    }


    public boolean emailYolla() {

        Log.i("BilgeAdamInfo", "Email Yollandı");
        return true;
    }


    public boolean smsAt() {

        Log.i("BilgeAdamInfo", "Sms Yollandı");
        return true;
    }

    public static void mesajVer(Context context, String mesaj) {


        Toast.makeText(context, mesaj, Toast.LENGTH_LONG).show();


    }


}
