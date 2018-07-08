package com.mtbsgmz.encryptedcontacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;


import com.mtbsgmz.encryptedcontacts.com.mtbsgmz.adapters.KisiCustomAdapter;
import com.mtbsgmz.encryptedcontacts.com.mtbsgmz.adapters.KisiItem;
import com.mtbsgmz.encryptedcontacts.com.mtbsgmz.dao.KisiDAO;
import com.mtbsgmz.encryptedcontacts.com.mtbsgmz.modal.Kisi;
import com.mtbsgmz.encryptedcontacts.com.mtbsgmz.modal.LoginState;

import java.util.ArrayList;
import java.util.List;

public class KisiListele extends AppCompatActivity {

    ListView LVTumListe;

    ArrayList<KisiItem> listem = new ArrayList<KisiItem>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisi_listele);

        List<Kisi> veriler = new KisiDAO(this).readAll(0,100);
        verileriSetEt(veriler);
        LVTumListe = (ListView) findViewById(R.id.listKisiListesi);
        LVTumListe.setAdapter(new KisiCustomAdapter(listem,this));

    }

    private void verileriSetEt(List<Kisi> veriler){
        listem = new ArrayList<KisiItem>();
        for(Kisi data: veriler){
            KisiItem Ki = new KisiItem();
            Ki.setAD(data.getAD()+" "+data.getSOYAD());
            Ki.setTELEFON(data.getTELEFON());
            Ki.setID(data.getID());
            listem.add(Ki);
        }


    }


    @Override
    protected void onResume() {
        super.onResume();

        if(LoginState.timeisup()){
            finish();
            Intent login = new Intent(this, AnaLoginEkrani.class);
            startActivity(login);
        }

        List<Kisi> veriler = new KisiDAO(this).readAll(0,100);
        verileriSetEt(veriler);
        LVTumListe = (ListView) findViewById(R.id.listKisiListesi);
        LVTumListe.setAdapter(new KisiCustomAdapter(listem,this));
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

}
