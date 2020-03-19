package com.example.appli_gsb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjoutEchantillon extends MainActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_ajout_echantillon);


        final EditText Code;
        final EditText Libelle;
        final EditText Stock;
        final BdAdapter echantBdd = new BdAdapter(this);


        Code = (EditText) findViewById(R.id.etCodeAjout);
        Libelle = (EditText) findViewById(R.id.etLibellleAjout);
        Stock = (EditText) findViewById(R.id.etStockAjout);




        Button btnAjouter = (Button) findViewById(R.id.btnAjouterAjout);
        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (Code.getText().toString().equals("") || Libelle.getText().toString().equals("") || Stock.getText().toString().equals("")){
                    Toast.makeText(AjoutEchantillon.this, "Vous avez oublié de renseigner l'un des trois, champs !",Toast.LENGTH_SHORT).show();
                }else {

                    String CvStock = Stock.getText().toString();
                    long StockConvert = Long.valueOf(CvStock);

                    Echantillon echant = new Echantillon(Code.getText().toString(), Libelle.getText().toString(), (int) StockConvert);

                    echantBdd.open();

                    boolean AjoutEchant = echantBdd.insererEchantillon(echant);

                    if(AjoutEchant == true){
                        Toast.makeText(AjoutEchantillon.this, "Vos données ont bien été ajoutées à la base",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(AjoutEchantillon.this, "Erreur, données non insérées",Toast.LENGTH_LONG).show();
                    }

                    Code.setText("");
                    Libelle.setText("");
                    Stock.setText("");

                    echantBdd.close();

                }


            }
        });


        Button btnQuitter = (Button) findViewById(R.id.btnQuitterAjout);
        btnQuitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

}

