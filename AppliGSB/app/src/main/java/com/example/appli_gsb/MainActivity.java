package com.example.appli_gsb;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button ajout;
    private Button liste;
    private Button maj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_menu);


        ajout = (Button) findViewById(R.id.btnAjouterMenu);   //Appel du "button1"
        ajout.setOnClickListener(new View.OnClickListener()      //Creation du listener sur ce bouton

        {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AjoutEchantillon.class));
            }

        });


        liste = (Button) findViewById(R.id.btnListerMenu);   //Appel du "button1"
        liste.setOnClickListener(new View.OnClickListener()      //Creation du listener sur ce bouton

        {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListeEchantillon.class));
            }

        });


        maj = (Button) findViewById(R.id.btnMajMenu);   //Appel du "button1"
        maj.setOnClickListener(new View.OnClickListener()      //Creation du listener sur ce bouton

        {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MajEchantillon.class));
            }

        });



    }

/*

    public void testBd(){

//Création d'une instance de la classe echantBDD

        BdAdapter echantBdd = new BdAdapter(this);

//Création d'un Echantillon

        Echantillon unEchant = new Echantillon("code1", "lib1", "3");

//On ouvre la base de données pour écrire dedans

        echantBdd.open();

//On insère l'echantillon que l'on vient de créer

        echantBdd.insererEchantillon(unEchant);

//System.out.println("insertion echantillon");

//Pour vérifier que l'on a bien créé un echantillon dans la BDD

//on extrait l’echantillon de la BDD grâce au libelle de l'echantillon que l'on a créé précédemment

        Echantillon unEchantFromBdd = echantBdd.getEchantillonWithLib("lib1");

//Si un unArticle est retourné (donc si le unEchant à bien été ajouté à la BDD)

        if(unEchantFromBdd != null){

//On affiche les infos de l’echantillon dans un Toast

            Toast.makeText(this, unEchantFromBdd.getLibelle(), Toast.LENGTH_LONG).show();

            System.out.println("echantillon trouve : "+unEchantFromBdd.getLibelle());

//On modifie le titre de l’echantillon

            unEchantFromBdd.setLibelle("lib2");

//Puis on met à jour la BDD

            echantBdd.updateEchantillon(unEchantFromBdd.getCode(), unEchantFromBdd);

        }

        else {

            Toast.makeText(this, "echantillon non trouvé", Toast.LENGTH_LONG).show();

            System.out.println("echantillon non trouvé");

        }

//On extrait l’Article de la BDD grâce à son nouveau lib

        unEchantFromBdd = echantBdd.getEchantillonWithLib("Lib2");

//S'il existe un Article possédant cette désignation dans la BDD

        if(unEchantFromBdd != null){

//On affiche les nouvelles info de l’echantillon pour vérifié que le lib de l’echantillon a bien été maj

            Toast.makeText(this, unEchantFromBdd.getLibelle(), Toast.LENGTH_LONG).show();

//on supprime le unEchant de la BDD grâce à son ID

            echantBdd.removeEchantillonWithCode(unEchantFromBdd.getCode());

        }

//On essait d'extraire de nouveau l’echantillon de la BDD toujours grâce à son nouveau libelle

        unEchantFromBdd = echantBdd.getEchantillonWithLib("lib2");

//Si aucun unEchant n'est retourné

        if(unEchantFromBdd == null){

//On affiche un message indiquant que l’echantillon n'existe pas dans la BDD

            Toast.makeText(this, "Cet echantillon n'existe pas dans la BDD", Toast.LENGTH_LONG).show();

        }

        else{ //Si l'Aechantillon existe (mais normalement il ne devrait pas)

//on affiche un message indiquant que l’echantillon existe dans la BDD

            Toast.makeText(this, "Cet echantillon existe dans la BDD", Toast.LENGTH_LONG).show();

        }

        echantBdd.close();




}*/
}
