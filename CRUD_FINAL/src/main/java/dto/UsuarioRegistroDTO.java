package dto;

import java.time.LocalDate;

public record UsuarioRegistroDTO (String nombre, String apellidoPaterno,
                                 String apellidoMaterno, String correoElectronico,
                                 LocalDate fechaNacimiento, String curp, String numeroTelefono,
                                 String contrasena,
                                 DireccionRegistroDTO direccionRegistroDTO) {
}
