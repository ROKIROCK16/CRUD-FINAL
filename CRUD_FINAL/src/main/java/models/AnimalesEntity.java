package models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Table( name = "animales" )
public class AnimalesEntity {

    private int id_Animales;
    private String nombre;
    private String sexo;
    private Date fechaNacimiento;
    private String estadoAdopcion;
    private RazaEntity raza;





    public AnimalesEntity () {

    }

    public AnimalesEntity (String nombre, String sexo, Date fechaNacimiento, String estadoAdopcion ) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechaNacimiento=fechaNacimiento;
        this.estadoAdopcion=estadoAdopcion;


    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public int getId_Animales() {
        return id_Animales;
    }

    private void setId_Animales(int id_Animales) {
        this.id_Animales = id_Animales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstadoAdopcion() {
        return estadoAdopcion;
    }

    public void setEstadoAdopcion(String estadoAdopcion) {
        this.estadoAdopcion = estadoAdopcion;
    }

    @ManyToOne
    @JoinColumn(name = "Raza_id_Raza", referencedColumnName = "id_Raza")
    public RazaEntity getRaza() {
        return raza;
    }

    public void setRaza(RazaEntity raza) {
        this.raza = raza;
    }


}