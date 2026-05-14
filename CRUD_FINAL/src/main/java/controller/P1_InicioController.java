package controller;

import com.example.demo.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class P1_InicioController {

    @FXML
    protected void onBtnRegistrarseClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("P2_RegistroUsuario.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Registro de Usuario");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onBtnIniciarSesionClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("P3_InicioSesion.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Inicio de Sesion");
        stage.setScene(scene);
        stage.show();
    }

}
