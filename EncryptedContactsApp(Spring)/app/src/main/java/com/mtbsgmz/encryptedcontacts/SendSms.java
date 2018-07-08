package com.mtbsgmz.encryptedcontacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mtbsgmz.encryptedcontacts.com.mtbsgmz.tools.AndroTool;


public class SendSms extends AppCompatActivity {

    Button gonderButonu;
    EditText txtTelefon;
    EditText txtMesaj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        gonderButonu = (Button) findViewById(R.id.btnSmsGonder);
        txtTelefon   = (EditText) findViewById(R.id.txtTelefonNumarasi);
        txtMesaj     = (EditText) findViewById(R.id.txtMesaj);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String tel = getIntent().getExtras().get("tel").toString();
        txtTelefon.setText(tel);
    }

    public void sendSms(View view){

        final String tel = txtTelefon.getText().toString();
        final String mesaj = txtMesaj.getText().toString();
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(tel,null,mesaj,null,null);

            AndroTool.mesajVer(getApplicationContext(),"Mesaj Gönderildi !");
        }catch (Exception e){
            AndroTool.mesajVer(getApplicationContext(),"Mesaj Gönderilemedi !");
            Log.e("MesajHatalari",e.getMessage());
        }


    }


}
