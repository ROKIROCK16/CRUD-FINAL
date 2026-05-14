package controller;

import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import models.AnimalesEntity;

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
    private TableColumn<AnimalesEntity, String>  colNombre;
    @FXML
    private TableColumn<AnimalesEntity, String> colRaza;
    @FXML
    private TableColumn<AnimalesEntity, String> colSexo;
    @FXML
    private TableColumn<AnimalesEntity, String> colEdad;
    @FXML
    private TableColumn<AnimalesEntity, String> colEstado;
    @FXML
    private TableColumn<AnimalesEntity, String> colAnimal;


    private FilteredList<AnimalesEntity> FiltrarAnimal;
    public void onBtnFiltrarClick(ActionEvent actionEvent){

        String Filtrar = txtFiltro.getText() == null ? "" : txtFiltro.getText().trim().toLowerCase();

        FiltrarAnimal.setPredicate(animal -> {
                    if (Filtrar.isEmpty()) {
                        return true;
                    }
                    return animal.getSexo().contains(Filtrar)
                            || animal.getNombre().contains(Filtrar)
                            || animal.getEstadoAdopcion().contains(Filtrar);
                }
            );
    }


}
