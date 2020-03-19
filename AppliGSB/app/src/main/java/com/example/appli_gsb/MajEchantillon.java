package com.example.appli_gsb;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MajEchantillon extends MainActivity {

    private EditText code;
    private EditText quantite;
    private BdAdapter echantBdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_maj_echantillon);

        code = (EditText) findViewById(R.id.etMajCode);
        quantite = (EditText) findViewById(R.id.etMajQuantite);
        echantBdd = new BdAdapter(this);
        //On ouvre la base de données pour écrire dedans


        Button buttonSupprimer = (Button) findViewById(R.id.btnMajSupprimer);
        buttonSupprimer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (code.getText().toString().equals("")){
                    Toast.makeText(MajEchantillon.this, "Vous devez renseigner le code pour identifier votre échantillon !",Toast.LENGTH_SHORT).show();
                }else {

                // TODO Auto-generated method stub

                echantBdd.open();
                Toast.makeText(MajEchantillon.this, "L'échantillon à bien été supprimer.",Toast.LENGTH_SHORT).show();
                String chaine = code.getText().toString();
                echantBdd.removeEchantillonWithCode(chaine);

                code.setText("");
                quantite.setText("");

                echantBdd.close();
                }

            }

        });


        Button buttonAjouter = (Button) findViewById(R.id.btnMajAjouter);
        buttonAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String CvQuantite = quantite.getText().toString();
                long QuantiteConvert = Long.valueOf(CvQuantite);

                Echantillon echant = new Echantillon(code.getText().toString(), "", (int) QuantiteConvert);

                String Code = code.getText().toString();
                echantBdd.open();

                echantBdd.updateEchantillon(Code, echant);

                code.setText("");
                quantite.setText("");

                echantBdd.close();

            }
        });


        Button buttonQuitter = (Button) findViewById(R.id.btnMajQuitter);
        buttonQuitter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub
                finish(); //fermeture de la fenêtre

            }

        });
    }
}
