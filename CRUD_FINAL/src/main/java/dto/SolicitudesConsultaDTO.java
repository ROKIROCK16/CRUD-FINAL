package dto;

import java.time.LocalDate;

public record SolicitudesConsultaDTO (String folio, LocalDate fechaPresentacion, String estado) {
}
