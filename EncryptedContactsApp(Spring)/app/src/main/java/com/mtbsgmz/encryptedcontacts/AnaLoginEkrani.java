package com.mtbsgmz.encryptedcontacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


import com.mtbsgmz.encryptedcontacts.com.mtbsgmz.modal.LoginState;
import com.mtbsgmz.encryptedcontacts.com.mtbsgmz.tools.AndroTool;

import java.util.Date;

public class AnaLoginEkrani extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_login_ekrani);
    }

    public void giris(View view){

        String kadi =  ((EditText)findViewById(R.id.txtKadi)).getText().toString();

        String sifre =  ((EditText)findViewById(R.id.txtSifre)).getText().toString();

        if(kadi != null && sifre != null){
            if(kadi.equals("admin") && sifre.equals("123")){

             //TODO: Ana ekranı çağır
                LoginState.loginTime = new Date().getTime();
                LoginState.geriSayim();
                Intent ekran = new Intent(getApplicationContext(),Menu.class);
                startActivity(ekran);


            }else{
                AndroTool.mesajVer(this,"Bilgiler Hatalı !");
            }

        }else{
            AndroTool.mesajVer(this,"Lütfen Bilgileri Doldurunuz !");
        }
    }
}
