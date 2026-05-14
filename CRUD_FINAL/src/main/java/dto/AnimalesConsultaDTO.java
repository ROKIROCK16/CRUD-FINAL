package dto;

import java.time.LocalDate;

public record AnimalesConsultaDTO (String nombre, String animal,
                                   String raza, String sexo, int edad,
                                   String estado){
}
