package com.example.negozioapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProdottoAdapter.OnProdottoClickListener {

    private RecyclerView recyclerView;
    private ProdottoAdapter adapter;
    private List<Prodotto> listaProdotti;
    private int numeroArticoliCarrello = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Inizializzazione RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        
        // Inizializzazione lista prodotti
        listaProdotti = new ArrayList<>();
        caricaProdotti();
        
        // Inizializzazione adapter
        adapter = new ProdottoAdapter(listaProdotti, this);
        recyclerView.setAdapter(adapter);
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        // Controlla se il carrello è stato aggiornato
        aggiornaIndicatoreCarrello();
    }

    private void caricaProdotti() {
        // Aggiungi prodotti di esempio
        listaProdotti.add(new Prodotto(1, "Camicia Jeans", "Camicia in cotone slim fit", 49.99, R.drawable.prodotto1));
        listaProdotti.add(new Prodotto(2, "Giacca in Pelle", "Giacca in vera pelle", 129.99, R.drawable.prodotto2));
        listaProdotti.add(new Prodotto(3, "Scarpe Casual", "Scarpe comode casual", 59.99, R.drawable.prodotto3));
        listaProdotti.add(new Prodotto(4, "Orologio", "Elegante orologio da polso", 89.99, R.drawable.prodotto4));
        listaProdotti.add(new Prodotto(5, "Zaino", "Zaino resistente da viaggio", 45.99, R.drawable.prodotto5));
        listaProdotti.add(new Prodotto(6, "Occhiali da Sole", "Occhiali con protezione UV", 29.99, R.drawable.prodotto6));
    }

    @Override
    public void onProdottoClick(Prodotto prodotto) {
        // Naviga ai dettagli del prodotto usando Intent esplicito
        Intent intent = new Intent(this, DettaglioProdottoActivity.class);
        intent.putExtra("id_prodotto", prodotto.getId());
        intent.putExtra("nome_prodotto", prodotto.getNome());
        intent.putExtra("descrizione_prodotto", prodotto.getDescrizione());
        intent.putExtra("prezzo_prodotto", prodotto.getPrezzo());
        intent.putExtra("immagine_prodotto", prodotto.getIdImmagine());
        startActivityForResult(intent, 100);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            if (data != null && data.hasExtra("carrello_aggiornato")) {
                numeroArticoliCarrello = data.getIntExtra("numero_articoli", numeroArticoliCarrello);
                Toast.makeText(this, "Carrello aggiornato! Articoli: " + numeroArticoliCarrello, Toast.LENGTH_SHORT).show();
                aggiornaIndicatoreCarrello();
            }
        }
    }
    
    private void aggiornaIndicatoreCarrello() {
        invalidateOptionsMenu();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principale, menu);
        MenuItem itemCarrello = menu.findItem(R.id.action_carrello);
        
        // Aggiorna indicatore carrello
        if (numeroArticoliCarrello > 0) {
            itemCarrello.setTitle("Carrello (" + numeroArticoliCarrello + ")");
        } else {
            itemCarrello.setTitle("Carrello");
        }
        
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        
        if (id == R.id.action_carrello) {
            Toast.makeText(this, "Carrello selezionato! Articoli: " + numeroArticoliCarrello, Toast.LENGTH_SHORT).show();
            return true;
        }
        
        return super.onOptionsItemSelected(item);
    }
}