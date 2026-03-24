package DAO;

import GestioneEventi.Entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

// classe che serve per lavorare con i database ci metto i metodi in modo che dal main siano accessibili senza sporcarlo con logica che qui rimane "nascosta"

public class EventiDAO {
    // attributo ... serve epr parlare con il database per comandarlo
    private final EntityManager entityManager;


    // costruttore serve peer poter passare l EM per poterci lavorare
    public EventiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    // Preparo metodi che poi verranno utilizzati nel main con logica nascosta. Qui e' solo definizione del metodo come al solito

    // newEvento e' solo il nome del parametro da passargli non e' collegato al new della creazione potevo chiamarlo EventoInpuy
    public void save(Evento newEvento) {
        // 1. Chiedo all EM di aprire una transazione. E' il "posto" sicuro in cui lavorare. Qui dentro le operazioni sono tipo tutelate
        EntityTransaction transaction = this.entityManager.getTransaction();

        // 2.Prima l avevo solo creata ma non iniziata
        transaction.begin();

        // 3 Dico che voglio salvare questo oggetto da qui diventa un oggetto controllato fino al commit rimarra' sotto osservazione fino a che decido la sua sorte
        // se agigungerlo o meno al database e se prima modificarelo o no
        // .persist(oggetto) serve per DIRE DI voler SALVARE ma ancora non lo fa
        entityManager.persist(newEvento);

        // 4. Come commit git chiude e pusha nel database
        transaction.commit();

        // 5. Log di avvenuto salvataggio
        System.out.println("L evento " + newEvento.getTitolo() + " è stato salvato con successo!");
    }
}
