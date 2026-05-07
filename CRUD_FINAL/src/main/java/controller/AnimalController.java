package controller;

import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;

public class AnimalController {
    @FXML
    private TextField txtFiltro;
    @FXML
    private Button btnFiltro;
    @FXML
    private Button btnCerrar;
    @FXML
    private TableColumn<Animal, String>  colNombre;
    @FXML
    private TableColumn<Animal, String> colRaza;
    @FXML
    private TableColumn<Animal, String> colSexo;
    @FXML
    private TableColumn<Animal, String> colEdad;
    @FXML
    private TableColumn<Animal, String> colEstado;
    @FXML
    private TableColumn<Animal. String> colAnimal;


    private FilteredList<Animal> FiltrarAnimal;
    public void onBtnFiltrarClick(ActionEvent actionEvent){

        String Filtrar = txtFiltro.getText() == null ? "" : txtFiltro.getText().trim().toLowerCase();

        FiltrarAnimal.setPredicate(animal -> {
                    if (Filtrar.isEmpty()) {
                        return true;
                    }
                    return Nombre.contains(Filtrar)
                            || Animal.getRaza().toLowerCase.contains(Filtrar)
                            || Animal.getSexo().toLowerCase.contains(Filtrar)
                            || Animal.getEdad().toLowerCase.contains(Filtrar)
                            || Animal.getEstado().toLowerCase.contains(Filtrar)
                            || Animal.getAnimal().toLowerCase.contains(Filtrar);
                }
            );
    }


}
