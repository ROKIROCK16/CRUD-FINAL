package controller;

import dto.AnimalesConsultaDTO;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import service.AnimalService;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class P7_MenuAdminController implements Initializable {
    @FXML
    private TextField txtNombre, txtFiltros;
    @FXML
    private ComboBox cmbBoxSexo, cmbBoxAnimal, cmbBoxRaza;
    @FXML
    private DatePicker datePickerFechaNacimiento;
    @FXML
    private TableView<AnimalesConsultaDTO> tblAnimales;
    @FXML
    private TableColumn<AnimalesConsultaDTO, String> tblColumnAnimal;
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

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        cmbBoxRaza.setDisable(true);

        tblColumnAnimal.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().animal())
        );
        tblColumnNombre.setCellValueFactory(data ->
                new SimpleObjectProperty<>(data.getValue().nombre())
        );
        tblColumnRaza.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().raza())
        );
        tblColumnSexo.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().sexo())
        );
        tblColumnEdad.setCellValueFactory(data ->
                new SimpleObjectProperty<>(data.getValue().edad()).asString()
        );
        tblColumnEstado.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().estado())
        );
        ObservableList<AnimalesConsultaDTO> AnimalesConsultaDTOObservableList = FXCollections
                .observableList(AnimalService.obtenerAnimales());
        tblAnimales.setItems(AnimalesConsultaDTOObservableList);

        ObservableList<String> listaDeElementos1 = cmbBoxAnimal.getItems();
        listaDeElementos1.add("Perro");
        listaDeElementos1.add("Gato");
        listaDeElementos1.add("Ave");
        String Especie = cmbBoxAnimal.getValue().toString();
        if (cmbBoxRaza != null){
            cmbBoxRaza.setDisable(false);
            ObservableList<String> listaDeElementos2 = cmbBoxRaza.getItems();
            if (Especie == "Perro"){
                listaDeElementos2.add("Labrador Retriever");
                listaDeElementos2.add("Pastor Aleman");
                listaDeElementos2.add("Bulldog");
                listaDeElementos2.add("Poodle");
                listaDeElementos2.add("Chichuaha");
                listaDeElementos2.add("Golden Retriever");
            } else if (Especie == "Gato") {
                listaDeElementos2.add("Siames");
                listaDeElementos2.add("Persa");
                listaDeElementos2.add("Maine Coon");
                listaDeElementos2.add("Bengali");
                listaDeElementos2.add("Sphynx (sin pelo)");
                listaDeElementos2.add("Ragdoll");
            } else {
                listaDeElementos2.add("Aguila Real");
                listaDeElementos2.add("Loro");
                listaDeElementos2.add("Buho");
                listaDeElementos2.add("Colibri");
                listaDeElementos2.add("Pavo Real");
                listaDeElementos2.add("Flamenco");
            }
        }

        ObservableList<String> listaDeElementos3 = cmbBoxSexo.getItems();
        listaDeElementos3.add("Macho");
        listaDeElementos3.add("Hembra");
    }


    public void onBtnAgregarClick(ActionEvent actionEvent) {
    }

    public void onBtnCerrarClick(ActionEvent actionEvent) {
    }

    public void onBtnSolicitudesClick(ActionEvent actionEvent) {
    }

    public void onBtnEliminarClick(ActionEvent actionEvent) {
    }

    public void onBtnFiltrarClick(ActionEvent actionEvent) {
    }
}
