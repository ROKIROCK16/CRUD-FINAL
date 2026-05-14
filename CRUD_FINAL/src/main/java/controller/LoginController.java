package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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

        switch (Rol){
            case  "ADMIN": Accion("Admin.fxml", btnIngresarSesion);
            case  "USUARIO COMUN" : Accion("USUARIO COMUN.fxml", btnIngresarSesion);
        }
    }
    private void onbtnCancelarSesionClick (ActionEvent actionEvent){
        MostrarAlerta("Inicio de sesion Cancelado");
        LimpiarCampos();
    }

    @FXML
    private void  Accion(String Archivo, Button BotonOrigen){
        try{
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("com/example/demo/" + Archivo)
            );
            Scene NuevaEscena = new Scene(loader.load());
            Stage Ventana = (Stage) btnIngresarSesion.getScene().getWindow();
            Ventana.setScene(NuevaEscena);
            Ventana.show();
        }
        catch (Exception e){
            System.err.println("Error al cargar" + Archivo);
            e.printStackTrace();
        }
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
