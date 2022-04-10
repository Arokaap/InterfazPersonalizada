package vista;

import basedatos.BaseDatos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

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

    }

    @FXML
    private void userRegistro(MouseEvent event) {
        if (lbUsuario.getText().equalsIgnoreCase("") || lbContrasenia.getText().equalsIgnoreCase("")) {
            lbRegistroExitoso.setText("");
            lbErrorLogin.setText("Formato incorrecto");
        } else if (BaseDatos.estaRegistrado(lbUsuario.getText())) {
            lbRegistroExitoso.setText("");
            lbErrorLogin.setText("Este usuario ya está registrado");
        } else {
            BaseDatos.aniadirUsuario(lbUsuario.getText(), lbContrasenia.getText());
            lbErrorLogin.setText("");
            lbRegistroExitoso.setText("Usuario Registrado");
        }

        lbUsuario.setText("");
        lbContrasenia.setText("");
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
