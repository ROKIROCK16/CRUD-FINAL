package controller;

import dto.UsuarioConsultaDTO;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import service.UsuarioService;

import java.net.URL;
import java.util.ResourceBundle;

public class UsuariosTableViewController implements Initializable {
    @FXML
    private TableView<UsuarioConsultaDTO> tblUsuarios;
    @FXML
    private TableColumn<UsuarioConsultaDTO, String> tblColumnNombre;
    @FXML
    private TableColumn<UsuarioConsultaDTO, Integer> tblColumnEdad;
    @FXML
    private TableColumn<UsuarioConsultaDTO, String> tblColumnDireccion;

    private UsuarioService usuarioService = new UsuarioService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblColumnNombre.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().nombreCompleto())
        );
        tblColumnEdad.setCellValueFactory(data ->
                new SimpleObjectProperty<>(data.getValue().edad())
        );
        tblColumnDireccion.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().domicilio())
        );
        ObservableList<UsuarioConsultaDTO> usuarioConsultaDTOObservableList = FXCollections
                .observableList(usuarioService.obtenerUsuarios());
        tblUsuarios.setItems(usuarioConsultaDTOObservableList);
    }
}
