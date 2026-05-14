package controller;

import com.example.demo.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.UsuarioService;

import java.io.IOException;

public class P3_InicioSesionController {
    @FXML
    private TextField txtCorreoElec;
    @FXML
    private TextField txtContrasena;
    @FXML
    private Button btnIngresarSesion;
    @FXML
    private Button btnCancelarSesion;


    private UsuarioService usuarioService = new UsuarioService();

    public void onBtnIngresarSesionClick(ActionEvent actionEvent) throws IOException {
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
            case  "ADMIN": Accion("P7_MenuAdminController.fxml", btnIngresarSesion, "Menu Admin");
            case  "USUARIO COMUN" : Accion("P4_MenuUsuarioController.fxml", btnIngresarSesion, "Menu Usuario");
        }
    }
    @FXML
    private void onBtnCancelarSesionClick (ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("P1_Inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Inicio");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void  Accion (String Archivo, Button BotonOrigen, String NombreScene) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(Archivo));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle(NombreScene);
        stage.setScene(scene);
        stage.show();
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
