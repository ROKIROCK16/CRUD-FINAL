package service;

public class UsuarioService {


    public String login(String correo, String contrasena) {


        if(correo.equals("admin@ejempli.com") && contrasena.equals("1234")){
            return "ADMIN";
        }
        if(correo.equals("usuario@ejemplo.com") && contrasena.equals("1234")){
            return "USUARIO COMUN";
        }

    return null;
    }
}
