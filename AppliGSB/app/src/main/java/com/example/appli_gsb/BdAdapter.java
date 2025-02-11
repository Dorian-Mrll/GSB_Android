package com.example.appli_gsb;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;

public class BdAdapter {

    static final int VERSION_BDD = 4;
    private static final String NOM_BDD = "gsb.db";
    private static final String TABLE_ECHANT = "echantillons";
    static final String COL_ID = "_id";
    static final int NUM_COL_ID = 0;
    public static final String COL_CODE = "CODE";
    static final int NUM_COL_CODE = 1;
    public static final String COL_LIB = "LIB";
    static final int NUM_COL_LIB = 2;
    public static final String COL_STOCK = "STOCK";
    static final int NUM_COL_STOCK = 3;

    private CreateBdEchantillon bdArticles;
    private Context context;
    private SQLiteDatabase db;

    public BdAdapter(Context context){
        this.context = context;
        bdArticles = new CreateBdEchantillon(context, NOM_BDD, null, VERSION_BDD);
    }

    //si la base n’existe pas, l’objet SQLiteOpenHelper exécute la méthode onCreate
    // si la version de la bse a changé, la méthode onUpgrade sera lancée
    // dans les 2 cas l’appel à getWritableDatabase ou getReadableDatabase renverra la base
    // de données en cache, nouvellement ouverte, nouvellement créée ou mise à jour
    public BdAdapter open (){
        db = bdArticles.getWritableDatabase();
        return this;
    }

    public BdAdapter close (){
        db.close();
        return null;
    }

    public boolean insertEchantillon(Echantillon unEchant){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_CODE, unEchant.getCode());
        values.put(COL_LIB, unEchant.getLibelle());
        values.put(COL_STOCK, unEchant.getQuantiteStock());

        //on insère l'objet dans la BDD via le ContentValues
        long result = db.insert(TABLE_ECHANT, null, values);

        if (result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Echantillon getEchantillonWithCode(String unCode){

        //Récupère dans un Cursor les valeurs correspondant à un echantillon grâce à sa designation)

        Cursor c = db.query(TABLE_ECHANT, new String[] {COL_ID,COL_CODE, COL_LIB, COL_STOCK}, COL_CODE + " LIKE \"" + unCode +"\"", null, null, null, null);

        return cursorToEchant(c);

    }

    public Echantillon cursorToEchant(Cursor c){ //Cette méthode permet de convertir un cursor en un echantillon
        Echantillon unEchant = new Echantillon(); //On créé un echantillon
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0) {
            return null;
        }
        else {
            //Sinon
            c.moveToFirst(); //on se place sur le premier élément
            //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
            unEchant.setCode(c.getString(NUM_COL_CODE));
            unEchant.setLibelle(c.getString(NUM_COL_LIB));
            unEchant.setQuantiteStock(c.getString(NUM_COL_STOCK));
        }

        c.close(); //On ferme le cursor

        return unEchant; //On retourne l'echantillon
    }


    public long updateEchantillon(String unCode, Echantillon unEchant){
        //La mise à jour d'un echantillon dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simple préciser quel echantillon on doit mettre à jour grâce à son code

        ContentValues values = new ContentValues();
        values.put(COL_CODE, unEchant.getCode());
        values.put(COL_LIB, unEchant.getLibelle());
        values.put(COL_STOCK, unEchant.getQuantiteStock());

        return db.update(TABLE_ECHANT, values, COL_CODE + " = \"" +unCode+"\"", null);
    }

    public int removeEchantillonWithCode(String unCode){
        //Suppression d'un echantillon de la BDD grâce à son code
        return db.delete(TABLE_ECHANT, COL_CODE + " = \"" +unCode+"\"", null);

    }


    public Cursor getData(){
        return db.rawQuery("SELECT * FROM echantillons", null);
    }


    public boolean updateAjoutEchantillon(String quantite, String code) {
        //String qte = Integer.toString(quantite);
        db.execSQL("UPDATE " + TABLE_ECHANT + " SET " + COL_STOCK + " = " + COL_STOCK + " + ? WHERE " + COL_CODE , new String[] {quantite, code});

        return true;
    }


}
