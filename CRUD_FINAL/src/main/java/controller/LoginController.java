package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.UsuarioService;

import javax.management.relation.Role;

public class LoginController {
    @FXML
    private TextField txtCorreoElec;
    @FXML
    private TextField txtContrasena;
    @FXML
    private Button btnIngresarSesion;
    @FXML
    private Button btnCancelarSesion;


    private UsuarioService usuarioService = new UsuarioService();

    public void OnbtnIngresarSesion(ActionEvent actionEvent){
        String Correo = txtCorreoElec.getText().trim();
        String Contrasena = txtContrasena.getText().trim();

        if (Correo.isEmpty() || Contrasena.isEmpty()) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Los campos estan vacios, favor de verificarlos");
        return;
        }

    }
}
