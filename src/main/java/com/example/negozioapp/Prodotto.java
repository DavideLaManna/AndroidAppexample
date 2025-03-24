package com.example.negozioapp;

public class Prodotto {
    private int id;
    private String nome;
    private String descrizione;
    private double prezzo;
    private int idImmagine;
    
    public Prodotto(int id, String nome, String descrizione, double prezzo, int idImmagine) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.idImmagine = idImmagine;
    }
    
    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getDescrizione() {
        return descrizione;
    }
    
    public double getPrezzo() {
        return prezzo;
    }
    
    public int getIdImmagine() {
        return idImmagine;
    }
}