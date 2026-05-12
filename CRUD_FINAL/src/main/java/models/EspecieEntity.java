package models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "especie" )
public class    EspecieEntity {

    private int id_Especie;
    private String especie;



    public EspecieEntity() {

    }

    public EspecieEntity(String   especie) {
        this.especie = especie;

    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public int getId_Especie() {
        return id_Especie;
    }

    public void setId_Especie(int id_Especie) {
        this.id_Especie = id_Especie;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }



}