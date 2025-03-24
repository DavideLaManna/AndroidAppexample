# App Negozio - Applicazione Android per E-commerce

Un'applicazione Android semplice ma completa che simula un'esperienza di shopping online. Quest'applicazione è stata sviluppata come progetto universitario per dimostrare l'implementazione di vari componenti e funzionalità Android.

![Screenshot dell'app](screenshots/app_screenshot.jpg)

## Caratteristiche

- **Catalogo Prodotti**: Visualizzazione di prodotti in una griglia scorrevole
- **Dettagli Prodotto**: Schermata dettagliata con immagine, descrizione e prezzo
- **Preferiti**: Possibilità di aggiungere prodotti ai preferiti 
- **Carrello**: Funzionalità per aggiungere articoli al carrello con contatore aggiornato
- **Valutazioni**: Sistema di valutazione prodotti

## Requisiti Universitari Soddisfatti

### 1. Componenti Obbligatori
- ✅ **Due Activities**: MainActivity e DettaglioProdottoActivity
- ✅ **Intent**: Intent esplicito per passare dalla lista prodotti al dettaglio
- ✅ **Immagini**: Utilizzo di immagini per rappresentare i prodotti
- ✅ **Event Listener**: Implementazione di vari listener (click, rating change, ecc.)

### 2. Funzionalità Avanzate
- ✅ **RecyclerView**: Implementato per visualizzare la lista dei prodotti
- ✅ **Comunicazione tra Activities**: Passaggio dei dati in entrambe le direzioni (dettagli prodotto all'andata, aggiornamento carrello al ritorno)
- ✅ **Metodi del Ciclo di Vita**: Utilizzo di onCreate(), onResume(), onActivityResult()

### 3. Widget di Input
- ✅ **Button**: Bottoni "Aggiungi al Carrello" e "Compra Ora"
- ✅ **ImageButton**: Bottone per aggiungere ai preferiti nella lista prodotti
- ✅ **CheckBox**: Checkbox per aggiungere ai preferiti nella schermata dettaglio
- ✅ **RatingBar**: Barra di valutazione a stelle per i prodotti

### 4. Funzionalità dell'App
- ✅ **Interattività**: Risponde agli input utente con feedback visivi e toast
- ✅ **Navigazione**: Navigazione intuitiva tra le schermate
- ✅ **Stato Persistente**: Mantenimento dello stato del carrello tra le schermate

## Struttura del Progetto
