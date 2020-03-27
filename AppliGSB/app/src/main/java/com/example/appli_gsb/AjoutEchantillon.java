package com.example.appli_gsb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjoutEchantillon extends MainActivity {

    EditText Code;
    EditText Libelle;
    EditText Stock;
    BdAdapter echantBdd = new BdAdapter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_ajout_echantillon);




        Code = (EditText) findViewById(R.id.etCodeAjout);
        Libelle = (EditText) findViewById(R.id.etLibelleAjout);
        Stock = (EditText) findViewById(R.id.etStockAjout);



        //________________________ BOUTON AJOUTER ______________________________________

        Button btnAjouter = (Button) findViewById(R.id.btnAjouterAjout);
        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String code = Code.getText().toString();
                String libelle = Libelle.getText().toString();
                String quantite = Stock.getText().toString();
                Echantillon echant = new Echantillon(code, libelle, quantite);

                echantBdd.open();

                try {

                    if(code.equals("") || libelle.equals("") || quantite.equals("")){
                        Toast.makeText(AjoutEchantillon.this, "Vous avez oublié un des champs qu'il faut obligatoirement renseigner.",Toast.LENGTH_LONG).show();
                    }

                    if (echantBdd.getEchantillonWithCode(code) == null){
                    Toast.makeText(AjoutEchantillon.this, "Attention ce code es déja utilisé, et existe dans la base !",Toast.LENGTH_LONG).show();
                    }

                    echantBdd.insertEchantillon(echant);
                    Toast.makeText(AjoutEchantillon.this, "Votre échantillon à bien été inséré.",Toast.LENGTH_LONG).show();

                    Code.setText("");
                    Libelle.setText("");
                    Stock.setText("");


                    }catch(Exception e) {
                    Toast.makeText(AjoutEchantillon.this, e.getMessage(),Toast.LENGTH_LONG).show();
                }

                echantBdd.close();

            }
        });


        //________________________ BOUTON QUITTER ______________________________________

        Button btnQuitter = (Button) findViewById(R.id.btnQuitterAjout);
        btnQuitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AjoutEchantillon.this, "Retour !!!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });



    }

}

