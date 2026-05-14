package controller;

import dto.AnimalesConsultaDTO;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import models.AnimalesEntity;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.awt.*;

public class P5_FormularioSolicitudController {
    @FXML
    private TextField txtFiltrar;
    @FXML
    private TableColumn<AnimalesConsultaDTO, String> tblColumnNombre;
    @FXML
    private TableColumn<AnimalesConsultaDTO, String> tblColumnRaza;
    @FXML
    private TableColumn<AnimalesConsultaDTO, String> tblColumnSexo;
    @FXML
    private TableColumn<AnimalesConsultaDTO, String> tblColumnEdad;
    @FXML
    private TableColumn<AnimalesConsultaDTO, String> tblColumnEstado;
    @FXML
    private TableColumn<AnimalesConsultaDTO, String> tblColumnAnimal;

    //Se debe crear la tabla de animales filtados

    //Filtrado de animales
    private FilteredList<AnimalesConsultaDTO> FiltrarAnimal;

    public void onBtnFiltrarClick (ActionEvent actionEvent){

        String Filtrar = txtFiltrar.getText() == null ? "" : txtFiltrar.getText().trim().toLowerCase();

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


    public void onBtnCancelarClick (ActionEvent actionEvent) throws Exception {

    }

    public void onBtnCrearSolicitudClick (ActionEvent actionEvent) throws Exception{
    }

}
