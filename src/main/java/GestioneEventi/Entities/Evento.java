package GestioneEventi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "eventi")
public class Evento {

    @Id
    private long id;
}