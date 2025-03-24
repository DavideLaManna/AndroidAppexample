package com.example.negozioapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProdottoAdapter extends RecyclerView.Adapter<ProdottoAdapter.ProdottoViewHolder> {

    private List<Prodotto> listaProdotti;
    private OnProdottoClickListener listener;
    
    public interface OnProdottoClickListener {
        void onProdottoClick(Prodotto prodotto);
    }
    
    public ProdottoAdapter(List<Prodotto> listaProdotti, OnProdottoClickListener listener) {
        this.listaProdotti = listaProdotti;
        this.listener = listener;
    }
    
    @NonNull
    @Override
    public ProdottoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prodotto, parent, false);
        return new ProdottoViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull ProdottoViewHolder holder, int position) {
        Prodotto prodotto = listaProdotti.get(position);
        holder.associa(prodotto, listener);
    }
    
    @Override
    public int getItemCount() {
        return listaProdotti.size();
    }
    
    static class ProdottoViewHolder extends RecyclerView.ViewHolder {
        ImageView immagineProdotto;
        TextView nomeProdotto, prezzoProdotto;
        ImageButton bottonePreferito;
        
        public ProdottoViewHolder(@NonNull View itemView) {
            super(itemView);
            immagineProdotto = itemView.findViewById(R.id.immagine_prodotto);
            nomeProdotto = itemView.findViewById(R.id.nome_prodotto);
            prezzoProdotto = itemView.findViewById(R.id.prezzo_prodotto);
            bottonePreferito = itemView.findViewById(R.id.bottone_preferito);
        }
        
        public void associa(final Prodotto prodotto, final OnProdottoClickListener listener) {
            immagineProdotto.setImageResource(prodotto.getIdImmagine());
            nomeProdotto.setText(prodotto.getNome());
            prezzoProdotto.setText("€" + String.format("%.2f", prodotto.getPrezzo()));
            
            // Imposta listener per l'intero elemento
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onProdottoClick(prodotto);
                }
            });
            
            // Imposta listener per il bottone preferiti
            bottonePreferito.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), 
                            prodotto.getNome() + " aggiunto ai preferiti!", 
                            Toast.LENGTH_SHORT).show();
                    bottonePreferito.setImageResource(R.drawable.ic_preferito_pieno);
                }
            });
        }
    }
}