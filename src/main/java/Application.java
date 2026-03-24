import DAO.EventiDAO;
import GestioneEventi.Entities.Evento;
import GestioneEventi.Entities.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestioneeventi");
    // Apre la porta tra java e il database, connette i due mondi le informazioni passata verranno tradotte non da lui direttamente ma da EntityManager
    // Persistence e' una classe JPA chje ha metodo createEntity ecc che serve a cercare le persintence unit .. quelkle che io ho scritto nel file

    // QUELLA SINTASSI E' COME SE FOSSE UN NEW NASCOSTO CREA UN OGGETTO DI TIPO EMF

    // Per connettere l'applicazione al DB dobbiamo usare la Persistence Unit descritta dentro il file persistence.xml
    // Per farlo, creiamo un attributo statico di tipo EntityManagerFactory passandogli il nome della Persistence Unit

    public static void main(String[] args) {
        System.out.println("Hello World!");

        // Main creo EntityManager che serve per parlare con il DB
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // lo passo alla classe per poterlo usare .. creo un oggetto DAO che sa usare l EntityManager
        // perche mi serve per far si che l oggetto DAO sia solo un insieme di metodi per lavorare con DB


        EventiDAO eventiDAO = new EventiDAO(entityManager);

        // questo e' possibile perche' di la nella classe ho un costruttore di questo tipo
        // per poter poi usare i metodi che creo nella classe eventi dao mi bastera' riferirmi all oggetto eventiDAO. visto che ho appena creato questo oggetto che sa usare l EM


        Evento e1 = new Evento("Matrimonio", LocalDate.parse("2026-08-22"), "Matrimonio tra Rosa e Pino a Villa Fabia in blu", TipoEvento.PRIVATO, 70);
        Evento e2 = new Evento("Laurea", LocalDate.parse("2026-09-15"), " Laura Economia Gabriele", TipoEvento.PRIVATO, 40);
        Evento e3 = new Evento("Presentazione Libro", LocalDate.parse("2026-04-01"), "Presentazione Libro per Bambini: L Efelante di Laura Bianchi", TipoEvento.PUBBLICO, 700);
        Evento e4 = new Evento("Pensionamento Pino", LocalDate.parse("2026-05-29"), "Festa pensionamento Pino Astolfi anni 78", TipoEvento.PRIVATO, 120);

        // per poter usare come detto sopra

//        eventiDAO.save(e1);
//        eventiDAO.save(e2);
        eventiDAO.save(e3);
        eventiDAO.save(e4);

        // sarebbe poi da chiudere l entity maganer perche a quanto pare creandolo qui gia' e' aperto e non va bene tenerlo aperto spreca risorse ma tanto questa non e' app vera e a noi al momento non importa
        // casomai poi comunque per riaprilo sarebbe da crearne uno nuovo come se quello vecchio fosse buttato via
    }
}
