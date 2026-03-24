package DAO;

import GestioneEventi.Entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventiDAO {
    // attributo ..
    private final EntityManager entityManager;


    // costruttore
    public EventiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    // metodo ... APPUNTI ANCORA DA RIVEDERE PER ORA QUELLI DELLA LEZIONE

    public void save(Evento newEvento) {
        // 1. Chiediamo all'Entity Manager di creare una nuova transazione
        EntityTransaction transaction = this.entityManager.getTransaction();

        // 2. Facciamo partire la transazione
        transaction.begin();

        // 3. Aggiungiamo newStudent (oggetto NON MANAGED) al PersistenceContext, facendolo
        // quindi diventare MANAGED (cioè monitorato dall'EntityManager). Non sarà ancora parte
        // del DB però
        entityManager.persist(newEvento);

        // 4. Per far si che l'oggetto managed diventi una nuova riga della tabella dobbiamo
        // fare il commit della transazione
        transaction.commit();

        // 5. Log di avvenuto salvataggio
        System.out.println("L evento " + newEvento.getTitolo() + " è stato salvato con successo!");
    }
}
