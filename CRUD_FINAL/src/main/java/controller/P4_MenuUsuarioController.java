package controller;

import com.example.demo.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class P4_MenuUsuarioController {
    public void onBtnConsultarPelutidosClick (ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("P5_FormularioSolicitud.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Formulario de Solicitudes");
        stage.setScene(scene);
        stage.show();
    }

    public void onBtnSolicitudesClick (ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("P6_TablaSolicitudUsuario.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Tabla de Solicitudes");
        stage.setScene(scene);
        stage.show();
    }

    public void onBtnCerrarSesionClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("P1_Inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Inicio");
        stage.setScene(scene);
        stage.show();
    }
}
