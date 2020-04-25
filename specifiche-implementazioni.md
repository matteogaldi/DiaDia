*Specifiche di implementazione per le singole classi*

**Stanza**
Versione con campi privati (information hiding)

**StanzaProtected**
Campi protetti

**StanzaMagica**
Estende stanza

**StanzaMagicaProtected**
Estende stanza protected

**StanzaBuia**
Se non è presente un oggetto con un determinato nome, il metodo getDescrizione() ritorna un messaggio particolare.
Deve avere una variabile d'istanza String che memorizza il nome dell'attrezzo che permette di avere la descrizione completa.
- Sovrascrivere getDescrizione() per ottenere il risultato desiderato
- L'attrezzo necessario va impostato tramite costruttore

**StanzaBloccata**
Una delle direzioni della stanza non può essere seguita a meno che nella stanza non sia presente un oggetto con un determinato nome.
- String nome direzione bloccata
- String attrezzo che sblocca la stanza
- Override getStanzaAdiacente(), se non è presente l'attrezzo sbloccante, ritorna un riferimento alla stanza corrente
- getDescrizione() va modificato per fornire una descrizione opportuna che dica come sbloccare la porta
- le stringhe sopra descritte vanno impostate tramite il costruttore

