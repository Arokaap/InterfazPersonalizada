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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import login.Login;

public class VLoginController implements Initializable {

    @FXML
    private TextField lbUsuario;
    @FXML
    private PasswordField lbContrasenia;
    @FXML
    private Label lbErrorLogin;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Label lbRegistroExitoso;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void userLogin(MouseEvent event) {
        if (lbUsuario.getText().equalsIgnoreCase("") || lbContrasenia.getText().equalsIgnoreCase("")) {
            lbRegistroExitoso.setText("");
            lbErrorLogin.setText("Faltan datos por rellenar");
        } else if (BaseDatos.loginCorrecto(lbUsuario.getText(), lbContrasenia.getText())) {
            lbRegistroExitoso.setText("Accediendo...");
            lbErrorLogin.setText("");
        } else{
            lbRegistroExitoso.setText("");
            lbErrorLogin.setText("Usuario o contraseña incorrecto!");
        }
    }

    @FXML
    private void userRegistro(MouseEvent event) {
        Login login = new Login();
        try {
            login.cambiarEscena("/vista/VRegistro.fxml");
        } catch (IOException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
        }

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

    }
}
