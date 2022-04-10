package vista;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        
    }    

    @FXML
    private void volverAtras(MouseEvent event) {
    }

    @FXML
    private void registrarme(MouseEvent event) {
    }
    
}
