package vista;

import basedatos.BaseDatos;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import login.Login;

public class VRegistroController implements Initializable {

    @FXML
    private TextField lbUsuario;
    @FXML
    private TextField lbContrasenia;
    @FXML
    private TextField lbConfirmar;
    @FXML
    private ImageView imgVolver;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Label lbErrorLogin;
    @FXML
    private Label lbRegistroExitoso;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void volverAtras(MouseEvent event) {
        Login login = new Login();
        try {
            login.cambiarEscena("/vista/VLogin.fxml");
        } catch (IOException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void registrarme(MouseEvent event) {
        if (lbUsuario.getText().equalsIgnoreCase("") || lbContrasenia.getText().equalsIgnoreCase("") || lbConfirmar.getText().equalsIgnoreCase("")) {
            lbRegistroExitoso.setText("");
            lbErrorLogin.setText("Faltan datos por rellenar");
        } else if (BaseDatos.estaRegistrado(lbUsuario.getText())) {
            lbRegistroExitoso.setText("");
            lbErrorLogin.setText("Este usuario ya está registrado");
        } else if(lbContrasenia.getText().equals(lbConfirmar.getText())){
            if (true) {
                BaseDatos.aniadirUsuario(lbUsuario.getText(), lbContrasenia.getText());
                lbErrorLogin.setText("");
                lbRegistroExitoso.setText("Usuario Registrado Correctamente");
            }
        }else{
            lbRegistroExitoso.setText("");
            lbErrorLogin.setText("La contraseña no coincide");
        }

        lbUsuario.setText("");
        lbContrasenia.setText("");
        lbConfirmar.setText("");
    }

    @FXML
    private void espacioPulsado(KeyEvent event) {
        lbUsuario.addEventFilter(event.ANY, (keyEvent) -> {
            if (keyEvent.getCharacter().equals(" ")) {
                keyEvent.consume();
            }
        });

        lbContrasenia.addEventFilter(event.ANY, (keyEvent) -> {
            if (keyEvent.getCharacter().equals(" ")) {
                keyEvent.consume();
            }
        });

        lbConfirmar.addEventFilter(event.ANY, (keyEvent) -> {
            if (keyEvent.getCharacter().equals(" ")) {
                keyEvent.consume();
            }
        });
    }

}
