package dto;

import java.time.LocalDate;

public record SolicitudesRegistroDTO (String folio, LocalDate fechaPresentacion,
                                      String usuarioNombre, String animalNombre,
                                      String estado) {
}
