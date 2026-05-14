package dto;

import models.EspecieEntity;
import models.RazaEntity;

import java.time.LocalDate;

public record AnimalesRegsitroDTO (String nombre, EspecieEntity animal,
                                   RazaEntity raza, String sexo, LocalDate fechaNacimiento,
                                   String estado) {
}
//el registro de animales en la pantalla 7, guarda Animal(Especie), Raza, Sexo, Nombre, FechaNacimiento y el estado que siempre sera no adoptado al registrarlo por primera vez