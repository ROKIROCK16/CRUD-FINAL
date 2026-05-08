package models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "raza" )
public class RazaEntity {

    private int id_Raza;
    private String raza;
    private EspecieEntity especie;


    public RazaEntity() {

    }

    public RazaEntity(String raza) {
        this.raza = raza;


    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public int getId_Raza() {
        return id_Raza;
    }

    private void setId_Raza(int id_raza) {
        this.id_Raza = id_raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }



    @ManyToOne
    @JoinColumn(name = "Especie_id_Especie", referencedColumnName = "id_Especie")
    public EspecieEntity getEspecie() {
        return especie;
    }

    public void setEspecie(EspecieEntity especie) {
        this.especie = especie;
    }


}