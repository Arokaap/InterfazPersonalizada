package login;

import basedatos.BaseDatos;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application {
    
    private static Stage ventanaActual;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage ventana) throws Exception {
        ventanaActual = ventana;
        ventana.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("/vista/VLogin.fxml"));
        
        Scene escena = new Scene(root, 612, 400);
        
        ventana.setTitle("JavaFX01");
        ventana.setScene(escena);
        ventana.show();
        
        BaseDatos.cargarDatos();
    }
    
    public void cambiarEscena(String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        ventanaActual.getScene().setRoot(root);
    }
    
}
