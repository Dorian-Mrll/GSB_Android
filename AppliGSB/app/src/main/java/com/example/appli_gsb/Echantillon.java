package com.example.appli_gsb;

public class Echantillon {


    protected String code;

    protected String libelle;

    protected int quantiteStock;


    public Echantillon(String code, String libelle, int qteStock){
        super();
        this.code = code;
        this.libelle = libelle;
        this.quantiteStock = qteStock;
    }

    public Echantillon() {

    }

    public String getCode(){

        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getLibelle(){
        return libelle;
    }

    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    public int getQuantiteStock(){
        return quantiteStock;
    }

    public void setQuantiteStock(int quantiteStock){
        this.quantiteStock = quantiteStock;
    }

}
