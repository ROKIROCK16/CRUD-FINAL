package models;

import jakarta.persistence.*;
import service.UsuarioService;

import java.time.LocalDate;

@Entity
@Table(name = "solicitudes")
public class SolicitudesEntity {

    private int id_Solicitudes;
    private String folio;
    private LocalDate fechaPresentacion;
    private UsuarioEntity usuario;
    private AnimalesEntity animal;
    private String estadoSolicitud;


    public SolicitudesEntity() {

    }


    public SolicitudesEntity(String folio,
                       LocalDate fechaPresentacion,
                       String estadoSolicitud) {

        this.folio = folio;
        this.fechaPresentacion = fechaPresentacion;
        this.estadoSolicitud = estadoSolicitud;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId_Solicitudes() {
        return id_Solicitudes;
    }

    public void setId_Solicitudes(int id_Solicitudes) {
        this.id_Solicitudes = id_Solicitudes;
    }


    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }


    public LocalDate getFechaPresentacion() {
        return fechaPresentacion;
    }

    public void setFechaPresentacion(LocalDate fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }


    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }


    @ManyToOne
    @JoinColumn(name = "Usuarios_id_Usuarios", referencedColumnName = "id_Usuarios")
    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }


    @ManyToOne
    @JoinColumn(name = "Animales_id_Animales", referencedColumnName = "id_Animales")
    public AnimalesEntity getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalesEntity animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return String.format(
                " %s , %s , %s",
                folio,
                fechaPresentacion,
                estadoSolicitud
        );
    }
}