package vista;

import basedatos.BaseDatos;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class VLoginController implements Initializable {

    HashMap<String, String> usuarios = new HashMap<>();

    @FXML
    private TextField lbUsuario;
    @FXML
    private PasswordField lbContrasenia;
    @FXML
    private Button btnButton;
    @FXML
    private Label lbErrorLogin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BaseDatos.cargarDatos();
    }

    @FXML
    private void userLogin(ActionEvent event) {
    }

    private void confirmarLogin() {

    }

}
