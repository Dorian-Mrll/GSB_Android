package com.example.appli_gsb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AppliMenu extends MainActivity {

    private Button ajout;
    private Button liste;
    private Button maj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_menu);



        ajout = (Button) findViewById(R.id.btnConnexion);   //Appel du "button1"
        ajout.setOnClickListener(new View.OnClickListener()      //Creation du listener sur ce bouton

        {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AppliMenu.this, AjoutEchantillon.class));
            }

        });


        liste = (Button) findViewById(R.id.btnListerMenu);   //Appel du "button2"
        liste.setOnClickListener(new View.OnClickListener()      //Creation du listener sur ce bouton

        {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AppliMenu.this, ListeEchantillon.class));
            }

        });


        maj = (Button) findViewById(R.id.btnMajMenu);   //Appel du "button3"
        maj.setOnClickListener(new View.OnClickListener()      //Creation du listener sur ce bouton

        {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AppliMenu.this, MajEchantillon.class));
            }

        });

    }
}
