package com.example.demo;

import dto.DireccionRegistroDTO;
import dto.UsuarioRegistroDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.UsuarioService;

public class P2_RegistroUsuarioController {
    @FXML
    private TextField txtNombre, txtApellidoP, txtApellidoM, txtCorreo, txtCorreoConfirmado,
            txtContrasena, txtCURP, txtNumeroTel;
    @FXML
    private TextField txtCalle, txtColonia, txtMunicipio, txtEstado, txtCodigoPostal;
    @FXML
    private DatePicker datePicker;
    private UsuarioService usuarioService = new UsuarioService();

    public void onBtnGuardarClick(ActionEvent actionEvent) throws Exception {
        DireccionRegistroDTO direccioDto = new DireccionRegistroDTO(
                txtCalle.getText(), txtColonia.getText(), Integer.parseInt(txtCodigoPostal.getText()),
                txtMunicipio.getText(), txtEstado.getText()
        );
        UsuarioRegistroDTO usuarioDto = new UsuarioRegistroDTO(
                txtNombre.getText(), txtApellidoP.getText(),
                txtApellidoM.getText(), txtCorreo.getText(), datePicker.getValue(),
                txtCURP.getText(), txtNumeroTel.getText(), txtContrasena.getText(),
                direccioDto
        );
        usuarioService.registrarUsuario(usuarioDto);

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("views/P3_InicioSesion.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Registro de Usuario");
        stage.setScene(scene);
        stage.show();
    }

    public void onBtnCancelarClick (ActionEvent actionEvent) throws Exception {

    }

}