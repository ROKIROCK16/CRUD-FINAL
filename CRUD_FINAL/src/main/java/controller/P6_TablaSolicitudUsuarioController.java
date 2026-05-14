package controller;

import dto.SolicitudesConsultaDTO;
import dto.SolicitudesRegistroDTO;
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
import service.SolicitudService;

import java.net.URL;
import java.util.ResourceBundle;

public class P6_TablaSolicitudUsuarioController implements Initializable {
    @FXML
    private TableView<SolicitudesConsultaDTO> tblSolicitudes;
    @FXML
    private TableColumn<SolicitudesRegistroDTO, String> tblColumnFolioS;
    @FXML
    private TableColumn<SolicitudesRegistroDTO, String> tblColumnFechaS;
    @FXML
    private TableColumn<SolicitudesRegistroDTO, String> tblColumnEstadoS;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblColumnFolioS.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().folio())
        );
        tblColumnFechaS.setCellValueFactory(data ->
                new SimpleObjectProperty<>(data.getValue().fechaPresentacion()).asString()
        );
        tblColumnEstadoS.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().estado())
        );
        ObservableList<SolicitudesConsultaDTO> usuarioConsultaDTOObservableList = FXCollections
                .observableList(SolicitudService.obtenerSolicitud());
        tblSolicitudes.setItems(usuarioConsultaDTOObservableList);
    }

    public void onBtnRegresarClick (ActionEvent actionEvent) throws Exception{

    }
}
