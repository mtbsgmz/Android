package com.mtbsgmz.encryptedcontacts.com.mtbsgmz.modal;

import android.content.Context;
import android.os.CountDownTimer;

import java.util.Date;

public class LoginState {


    private static Context context;

    public LoginState(Context contextIn) {
        context = contextIn;
    }

    public static Long loginTime ;
    public static String loginUserName = "";

    public static boolean timeisup() {

        Long simdi = new Date().getTime();
        Long zamanFarki = simdi - loginTime;
        if (30000 <= zamanFarki) {
            return true;
        }
        return false;
    }

    public static void geriSayim(){

        new CountDownTimer(3000000, 1000){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                System.exit(0);
            }
        }.start();


    }


}
