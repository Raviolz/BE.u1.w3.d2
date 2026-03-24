package GestioneEventi.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "eventi")
public class Evento {


    // attributi = colonne

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evento_id")
    private long id;

    @Column(nullable = false, length = 30)
    private String titolo;

    @Column(name = "data_evento")
    private LocalDate dataEvento;

    @Column(length = 200)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(name = "nome_evento", nullable = false)
    private TipoEvento tipoEvento;

    @Column(name = "n_max_pers")
    private int numeroMassimoPartecipanti;


    // costruttore vuoto OBBLIGATORIO

    public Evento() {
    }

    // costruttore normale

    public Evento(String titolo, LocalDate dataEvento, String descrizione,
                  TipoEvento tipoEvento, int numeroMassimoPartecipanti) {

        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }
}