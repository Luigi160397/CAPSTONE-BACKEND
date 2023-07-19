# FilmVerse Backend - Server Java per Recensioni Cinematografiche

Benvenuti nel repository del backend di FilmVerse, il sito web dedicato alle recensioni cinematografiche! 🎬🍿

## Descrizione del progetto

FilmVerse Backend è la parte server del progetto FilmVerse. Si tratta di un'applicazione Java che gestisce la logica di business e fornisce le API necessarie per supportare le funzionalità del sito web.

## Prerequisiti

Prima di eseguire l'applicazione, assicurarsi di avere installato:

1. **Java Development Kit (JDK)** - Versione 8 o superiore.
2. **PostgreSQL** - Un database PostgreSQL in cui verranno memorizzate le recensioni cinematografiche.

## Configurazione del server

Dopo aver clonato il progetto, è necessario creare un file `env.properties` nella root del progetto contenente le seguenti informazioni:

```
PG_PW= //password postgres
PG_USER= //user postgres
PG_DB= //nome DB
PORT=3001 //porta su cui startare il server da impostare obbligatoriamente a 3001
JWT_SECRET= //segreto per JWT
JWT_EXPIRATION= //durata token

SEGRETO= //segreto per BCript
ALGORITMO=AES/ECB/PKCS5Padding //algoritmo di hashing
```

Assicurarsi di impostare i valori corretti per la connessione al database PostgreSQL e per la configurazione del JSON Web Token (JWT).

## Documentazione delle REST API

Una volta avviato il server, è possibile visualizzare la documentazione delle REST API utilizzando Swagger. Accedi al seguente URL nel tuo browser:

[Swagger - FilmVerse Backend](http://localhost:3001/swagger-ui/index.html#/)

## Contributi al progetto

Il backend di FilmVerse è un progetto open source che accoglie con entusiasmo contributi dalla community. Se sei interessato a partecipare allo sviluppo, controlla il repository del frontend per ulteriori informazioni:

👉 [FilmVerse Frontend Repository](https://github.com/Luigi160397/CAPSTONE-FRONTEND) 👈

Siamo sempre alla ricerca di nuove funzionalità, miglioramenti dell'interfaccia utente e correzioni di bug. Unisciti a noi e rendi FilmVerse ancora migliore!

## Contattaci

Se hai domande, suggerimenti o feedback riguardo a FilmVerse, non esitare a contattarci:

-📧 Email: luigi.difraia.97@gmail.com
-👥 LinkedIn: [Luigi Di Fraia su LinkedIn](https://www.linkedin.com/in/luigi-di-fraia-full-stack-developer/)
-🐙 GitHub: [Luigi Di Fraia su GitHub](https://github.com/Luigi160397)
-📒 Portfolio: [Portfolio](https://portfolio-luigi-di-fraia.vercel.app/)

Unisciti a noi in questa avventura cinematografica e scopri il magico mondo del cinema su FilmVerse! 🌟🎥✨
