package com.example.appli_gsb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MajEchantillon extends MainActivity {

    private EditText Code;
    private EditText Stock;
    private BdAdapter echantBdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_maj_echantillon);

        Code = (EditText) findViewById(R.id.etMajCode);
        Stock = (EditText) findViewById(R.id.etMajQuantite);
        echantBdd = new BdAdapter(this);
        //On ouvre la base de données pour écrire dedans


        //________________________ BOUTON MODIFIER ______________________________________

        Button buttonModifier = (Button) findViewById(R.id.btnMajModifier);
        buttonModifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String code = Code.getText().toString();     // créer une variable qui recupère l'edit text du code
                String stock = Stock.getText().toString();   // créer une variable qui recupère l'edit text du stock

                echantBdd.open();   // on ouvre la connexion à la base

                try {
                    if (code.equals("") || stock.equals("")){   // boucle qui permet de vérifier que les champs ne sont pas vides
                        Toast.makeText(MajEchantillon.this, "Vous avez oublié un des champs qu'il faut obligatoirement renseigner, pour identifier l'échantillon à prendre.",Toast.LENGTH_LONG).show();
                    }

                    if (echantBdd.getEchantillonWithCode(code) == null){    // boucle qui permet de vérifier que le code (= l'échantillon) existe dans la base
                        Toast.makeText(MajEchantillon.this, "Impossible de modifier, le code n'existe pas dans la base !",Toast.LENGTH_LONG).show();
                    }

                    Echantillon unEchantt = echantBdd.getEchantillonWithCode(code); // on créer un objet échantillon, et on utlise son code (fct) pour récupérer tout ces attributs
                    unEchantt.setQuantiteStock(stock);  // on modifie son stock par le nouveau entré

                    echantBdd.updateEchantillon(code, unEchantt); // et on le retourne dans la base avec la fct update

                    Toast.makeText(MajEchantillon.this, "Votre échantillon à bien été modifié.",Toast.LENGTH_SHORT).show();

                    Code.setText("");   // on vide les saisies
                    Stock.setText("");

                }catch(Exception e) {
                    Toast.makeText(MajEchantillon.this, e.getMessage(),Toast.LENGTH_LONG).show();
                }
                echantBdd.close();  // on ferme la connexion à la base
            }
        });


        //________________________ BOUTON SUPPRIMER ______________________________________

        Button buttonSupprimer = (Button) findViewById(R.id.btnMajSupprimer);
        buttonSupprimer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                String code = Code.getText().toString();

                echantBdd.open();

                try {
                    if (code.equals("")){
                    Toast.makeText(MajEchantillon.this, "Vous avez oublié un des champs qu'il faut obligatoirement renseigner, pour identifier l'échantillon à prendre.",Toast.LENGTH_LONG).show();
                    }

                    if (echantBdd.getEchantillonWithCode(code) == null){
                        Toast.makeText(MajEchantillon.this, "Impossible de supprimer, le code n'existe pas dans la base !",Toast.LENGTH_LONG).show();
                    }

                    echantBdd.removeEchantillonWithCode(code);
                    Toast.makeText(MajEchantillon.this, "Votre échantillon à bien été supprimé.",Toast.LENGTH_SHORT).show();

                    Code.setText("");
                    Stock.setText("");

                }catch(Exception e) {
                    Toast.makeText(MajEchantillon.this, e.getMessage(),Toast.LENGTH_LONG).show();
                }
                echantBdd.close();
            }

        });


        //________________________ BOUTON SUPPRIMER ______________________________________

        Button buttonQuitter = (Button) findViewById(R.id.btnMajQuitter);
        buttonQuitter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub
                Toast.makeText(MajEchantillon.this, "Retour !!!",Toast.LENGTH_SHORT).show();
                finish(); //fermeture de la fenêtre

            }

        });
    }
}
