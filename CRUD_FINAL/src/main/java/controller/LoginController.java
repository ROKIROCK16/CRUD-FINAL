package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.UsuarioService;

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

    public void onbtnIngresarSesionClick(ActionEvent actionEvent){
        String Correo = txtCorreoElec.getText().trim();
        String Contrasena = txtContrasena.getText().trim();

        if (Correo.isEmpty() || Contrasena.isEmpty()) {
        MostrarAlerta("Los campos estan vacios, favor de verificarlos");
        return;
        }

        String Rol = usuarioService.login(Correo,Contrasena);

        if (Rol == null){
            MostrarAlerta("Datos incorrecto, verifique de nuevo por favor");
            LimpiarCampos();
        }

    }
    private void onbtnCancelarSesionClick (ActionEvent actionEvent){
        MostrarAlerta("Inicio de sesion Cancelado");
        LimpiarCampos();
    }

    private void MostrarAlerta (String mensaje){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText("los campos estan vacios, favor de verificar");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void LimpiarCampos(){
        txtCorreoElec.clear();
        txtContrasena.clear();
    }
}
