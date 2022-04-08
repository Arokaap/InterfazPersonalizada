package basedatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import javafx.scene.control.Alert;

public class BaseDatos {

    static HashMap<String, String> usuarios = new HashMap<>();

    public BaseDatos() {
    }

    public HashMap<String, String> getUsuarios() {
        return usuarios;
    }

    public static void aniadirUsuario(String usuario, String contrasenia) {
        try {
            FileWriter insertador = new FileWriter("Datos_Usuarios.txt");
            BufferedWriter buffer = new BufferedWriter(insertador);

            buffer.write(usuario);
            buffer.write(contrasenia);

        } catch (IOException ex) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("Error en el inicio de sesion");
            error.setContentText("El usuario o contraseña es incorrecto");
        }
    }

    public static void cargarDatos() {
        try {

            FileReader lector = new FileReader("Datos_Usuarios.txt");
            BufferedReader buffer = new BufferedReader(lector);

            String usuario = buffer.readLine();
            String contrasenia = buffer.readLine();
            while (usuario != null || contrasenia != null) {
                usuarios.put(usuario, contrasenia);

                usuario = buffer.readLine();
                contrasenia = buffer.readLine();
            }

        } catch (FileNotFoundException ex) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("No se cargaron correctamente los datos");
            error.setContentText("Los datos de los usuarios no se han cargado de la forma debida");
        } catch (IOException ex) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("No se cargaron correctamente los datos");
            error.setContentText("Los datos de los usuarios no se han cargado de la forma debida");
        }
    }

}