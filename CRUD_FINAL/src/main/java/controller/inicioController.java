package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;

public class inicioController {
    @FXML
    private Button btnRegistrarse;
    @FXML
    private Button btnIniarSesion;

    @FXML
    public void inicializar(){
        System.out.println("Cargando Pantalla");


    }
    //Este metodo se usa para cargar las pantallas, se puede aplicar para los demas controlller solo hay
    //que cambiar el nombre de los FXML
    @FXML
    protected void  Accion(String Archivo){
        try{
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("com/example/demo/" + Archivo)
            );
            Scene NuevaEscena = new Scene(loader.load());
            Stage Ventana = (Stage) btnRegistrarse.getScene().getWindow();
            Ventana.setScene(NuevaEscena);
            Ventana.show();
        }
        catch (Exception e){
            System.err.println("Error al cargar" + Archivo);
            e.printStackTrace();
        }
    }
    @FXML
    protected void OnbtnRegistrarseClick(){
        Accion("INICIO.fxml");
    }
    @FXML
    protected void OnIniciarSesionClick(){
        Accion("INICIO.fxml");
    }


}
