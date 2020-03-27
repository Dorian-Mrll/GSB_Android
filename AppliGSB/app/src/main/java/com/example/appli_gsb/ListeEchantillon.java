package com.example.appli_gsb;


        import android.database.Cursor;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ListView;
        import android.widget.SimpleCursorAdapter;
        import android.widget.Toast;

        import androidx.appcompat.app.AppCompatActivity;


public class ListeEchantillon extends AppCompatActivity {

        private ListView mListView;
        //private ImageView Img;
        private BdAdapter echantBdd;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.fenetre_liste_echantillon);

                mListView = (ListView) findViewById(R.id.lvListeEchant);


                echantBdd = new BdAdapter(this);
                //On ouvre la base de données pour écrire dedans

                echantBdd.open();

                Cursor leCurseur = echantBdd.getData();

                Toast.makeText(getApplicationContext(), "il y a " + String.valueOf(leCurseur.getCount()) + " echantillons dans la BD", Toast.LENGTH_LONG).show();

// colonnes à afficher

                String[] colNoms = new String[] {BdAdapter.COL_CODE, BdAdapter.COL_LIB, BdAdapter.COL_STOCK};

                //Img = (ImageView) findViewById(R.id.ivEchant);

// champs dans lesquelles afficher les colonnes

                int[] colNumeros = new int[] {R.id.tvCode, R.id.tvLib, R.id.tvQuantite};

                SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(this, R.layout.ligne_liste_echantillon,leCurseur,colNoms,colNumeros);

// Assign adapter to ListView

                mListView.setAdapter(dataAdapter);
                echantBdd.close();


                //________________________ BOUTON QUITTER ______________________________________

                Button buttonQuitter = (Button)findViewById(R.id.btnQuitterListe);
                buttonQuitter.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {

                                // TODO Auto-generated method stub
                                Toast.makeText(ListeEchantillon.this, "Retour !!!",Toast.LENGTH_SHORT).show();
                                finish(); //fermeture de la fenêtre

                        }

                });

        }

}