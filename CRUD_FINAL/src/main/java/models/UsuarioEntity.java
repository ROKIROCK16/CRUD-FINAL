package models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity
@Table( name = "usuarios" )
public class UsuarioEntity {

    private int id;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String correoE;
    private LocalDate fechaNacimiento;
    private String curp;
    private String numeroTel;
    private String contrasena;
    private String tipo;
    private DireccionEntity direccionEntity;
    public UsuarioEntity() {

    }

    public UsuarioEntity(String nombre, String apellidoP, String apellidoM, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getCorreoE () {
        return correoE;
    }

    public void setCorreoE (String correoE) {
        this.correoE = correoE;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCurp () {
        return curp;
    }

    public void setCurp (String curp) {
        this.curp = curp;
    }

    public String getNumeroTel () {
        return numeroTel;
    }

    public void setNumeroTel (String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getContrasena () {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo () {
        return tipo;
    }

    public void setTipo (String tipo) {
        this.tipo = tipo;
    }

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "direcciones_id_direccion", referencedColumnName = "id_direccion")
    public DireccionEntity getDireccionEntity() {
        return direccionEntity;
    }

    public void setDireccionEntity(DireccionEntity direccionEntity) {
        this.direccionEntity = direccionEntity;
    }
}