package com.example.appli_gsb;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collection;

public class MainActivity extends AppCompatActivity {


    private EditText Login;
    private EditText Password;
    private Button Connexion;
    private TextView Info;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_de_connexion);


        Login = (EditText)findViewById(R.id.ptLogin);
        Password = (EditText)findViewById(R.id.ptPassword);
        Connexion = (Button)findViewById(R.id.btnConnexion);



        Connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Login.getText().toString(), Password.getText().toString());
            }
        });


        Button buttonQuitter = (Button)findViewById(R.id.btnQuitterCon);
        buttonQuitter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this, "KENAVO !!!",Toast.LENGTH_SHORT).show();
                finish(); //fermeture de la fenêtre

            }

        });
    }


    private void validate(String login, String password){


        try {

            // TODO Auto-generated method stub
            Toast toast = new Toast(getApplicationContext());

            toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.BOTTOM, 0, 250);
            TextView tv = new TextView(MainActivity.this);
            TextView tv2 = new TextView(MainActivity.this);

            tv.setTextColor(Color.RED);
            tv.setTextSize(20);
            tv2.setTextColor(Color.RED);
            tv2.setTextSize(20);

            Typeface t = Typeface.create("serif", Typeface.BOLD_ITALIC);
            tv.setTypeface(t);
            tv.setText("Le login ou le mot de passe est incorrecte !!!");
            tv2.setTypeface(t);
            tv2.setText("L'un deux deux champs obligatoire est vide !");



            if (login.equals("") || password.equals("")){
                toast.setView(tv2);
                toast.show();
            }

            else if ((login.equals("Admin")) && (password.equals("1234"))){
                startActivity(new Intent(MainActivity.this, AppliMenu.class));

            }else{
                toast.setView(tv);
                toast.show();

                Login.setText("");
                Password.setText("");

            }

        }catch(Exception e) {
            Toast.makeText(MainActivity.this, e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

}