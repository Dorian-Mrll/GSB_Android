package com.example.appli_gsb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;

public class CreateBdEchantillon extends SQLiteOpenHelper {

    private static final String TABLE_ECHANT = "echantillons";
    private static final String COL_ID = "_id";
    private static final String COL_CODE = "CODE";
    private static final String COL_LIB = "LIB";
    private static final String COL_STOCK = "STOCK";

    private static final String TABLE_CONEXION = "connexion";                       //table connexion
    private static final String KEY_ID = "id";                                      // colonne clé primaire id
    private static final String KEY_LOGIN = "login";                                // colone identifiant
    private static final String KEY_PASSWORD = "password";                          // colone mot de passe


    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_ECHANT + " ("+ COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
            "" + COL_CODE + " TEXT NOT NULL, " + COL_LIB + " TEXT NOT NULL, " + COL_STOCK + " TEXT NOT NULL);";


    private static final String CREATE_CONNEXION = "CREATE TABLE " + TABLE_CONEXION + " ("+ KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
            "" + KEY_LOGIN + " TEXT NOT NULL, " + KEY_PASSWORD + " TEXT NOT NULL);";


    public CreateBdEchantillon(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // appelée lorsqu’aucune base n’existe et que la classe utilitaire doit en créer une
        //on créé la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_CONNEXION);
        db.execSQL(CREATE_BDD);
    }

    @Override // appelée si la version de la base a changé
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //On peut supprimer la table et de la recréer
        db.execSQL("DROP TABLE " + TABLE_CONEXION + ";");
        db.execSQL("DROP TABLE " + TABLE_ECHANT + ";");
        onCreate(db);
    }




}
