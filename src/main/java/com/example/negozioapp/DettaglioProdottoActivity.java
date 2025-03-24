package com.example.negozioapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DettaglioProdottoActivity extends AppCompatActivity {

    private ImageView immagineProdotto;
    private TextView nomeProdotto, descrizioneProdotto, prezzoProdotto;
    private Button bottoneAggiungiCarrello, bottoneCompraOra;
    private CheckBox checkboxPreferito;
    private RatingBar barraDiValutazione;
    private int contatoreCarrello = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dettaglio_prodotto);
        
        // Ottieni dati dall'intent
        Intent intent = getIntent();
        int idProdotto = intent.getIntExtra("id_prodotto", 0);
        String nome = intent.getStringExtra("nome_prodotto");
        String descrizione = intent.getStringExtra("descrizione_prodotto");
        double prezzo = intent.getDoubleExtra("prezzo_prodotto", 0.0);
        int idImmagine = intent.getIntExtra("immagine_prodotto", 0);
        
        // Inizializza le viste
        immagineProdotto = findViewById(R.id.immagine_prodotto);
        nomeProdotto = findViewById(R.id.nome_prodotto);
        descrizioneProdotto = findViewById(R.id.descrizione_prodotto);
        prezzoProdotto = findViewById(R.id.prezzo_prodotto);
        bottoneAggiungiCarrello = findViewById(R.id.bottone_aggiungi_carrello);
        bottoneCompraOra = findViewById(R.id.bottone_compra_ora);
        checkboxPreferito = findViewById(R.id.checkbox_preferito);
        barraDiValutazione = findViewById(R.id.barra_valutazione);
        
        // Imposta i dati alle viste
        immagineProdotto.setImageResource(idImmagine);
        nomeProdotto.setText(nome);
        descrizioneProdotto.setText(descrizione);
        prezzoProdotto.setText("€" + String.format("%.2f", prezzo));
        
        // Imposta i listener di eventi
        bottoneAggiungiCarrello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contatoreCarrello++;
                Toast.makeText(DettaglioProdottoActivity.this, "Aggiunto al carrello!", Toast.LENGTH_SHORT).show();
                inviaRisultato();
            }
        });
        
        bottoneCompraOra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contatoreCarrello++;
                Toast.makeText(DettaglioProdottoActivity.this, "Procedendo al pagamento!", Toast.LENGTH_SHORT).show();
                inviaRisultato();
                finish();
            }
        });
        
        checkboxPreferito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean èPreferito = checkboxPreferito.isChecked();
                if (èPreferito) {
                    Toast.makeText(DettaglioProdottoActivity.this, "Aggiunto ai preferiti!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DettaglioProdottoActivity.this, "Rimosso dai preferiti!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
        barraDiValutazione.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float valutazione, boolean fromUser) {
                if (fromUser) {
                    Toast.makeText(DettaglioProdottoActivity.this, "Hai valutato: " + valutazione, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    
    private void inviaRisultato() {
        Intent intentRisultato = new Intent();
        intentRisultato.putExtra("carrello_aggiornato", true);
        intentRisultato.putExtra("numero_articoli", contatoreCarrello);
        setResult(RESULT_OK, intentRisultato);
    }
    
    @Override
    public void onBackPressed() {
        inviaRisultato();
        super.onBackPressed();
    }
}