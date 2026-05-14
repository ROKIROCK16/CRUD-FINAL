package controller;

import dto.SolicitudesConsultaDTO;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import service.SolicitudService;

import java.net.URL;
import java.util.ResourceBundle;

public class P8_TablaSolicitudAdminController implements Initializable {
    @FXML
    private TableView <SolicitudesConsultaDTO> tblSolicitudes;
    @FXML
    private TableColumn <SolicitudesConsultaDTO, String> tblColumnFolio;
    @FXML
    private TableColumn <SolicitudesConsultaDTO, String> tblColumnNombre;
    @FXML
    private TableColumn <SolicitudesConsultaDTO, String> tblColumnFecha;
    @FXML
    private TableColumn <SolicitudesConsultaDTO, String> tblColumnEstado;

    @FXML
    private Button btnRegresar;
    @FXML
    private Button btnFiltrarSolicitudes;
    @FXML
    private Button btnAceptarSolicitud;
    @FXML
    private Button btnRechazarSolicitud;

    @FXML
    private TextField txtFiltrarSolicitudes;


    public void onBtnRegresarClick (ActionEvent actionEvent) {
    }

    public void onBtnFiltrarSolicitudesClick (ActionEvent actionEvent) {
    }

    public void onBtnAceptarSClick (ActionEvent actionEvent) {
    }

    public void onBtnRechazarSClick (ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblColumnFolio.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().folio())
        );
        tblColumnNombre.setCellValueFactory(data ->
                new SimpleObjectProperty<>(data.getValue().nombre())
        );
        tblColumnFecha.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().fecha())
        );
        tblColumnEstado.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().estado())
        );
        ObservableList<SolicitudesConsultaDTO> usuarioConsultaDTOObservableList = FXCollections
                .observableList(SolicitudService.obtenerSolicitudes());
        tblSolicitudes.setItems(usuarioConsultaDTOObservableList);
    }
}
