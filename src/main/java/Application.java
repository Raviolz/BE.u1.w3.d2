import DAO.EventiDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestioneeventi");
    // Per connettere l'applicazione al DB dobbiamo usare la Persistence Unit descritta dentro il file persistence.xml
    // Per farlo, creiamo un attributo statico di tipo EntityManagerFactory passandogli il nome della Persistence Unit

    public static void main(String[] args) {
        System.out.println("Hello World!");

        // Main creo EntityManager che serve per parlare con il DB
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // lo passo alla classe per poterlo usare .. creo un oggetto DAO che sa usare l EntityManager
        // perche mi serve per far si che l oggetto DAO sia solo un insieme di metodi per lavorare con DB

        // quindi anche se e' un oggetto io gli posso passare altri oggetti come nel caso save perche lui
        // lavora con dei metodi che per funzionare hanno bisogno di Entity Manager
        EventiDAO eventiDAO = new EventiDAO(entityManager);

        // questo e' possibile perche' di la nella classe ho un costruttore di questo tipo
    }
}