package basedatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
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
            FileWriter insertador = new FileWriter("src\\basedatos\\Datos_Usuarios.txt", true);
            PrintWriter escribiendo = new PrintWriter(insertador);

            escribiendo.write(usuario + "\n");
            escribiendo.write(contrasenia + "\n");

            insertador.close();
            insertador.close();
        } catch (IOException ex) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("Error en el inicio de sesion");
            error.setContentText("El usuario o contraseña es incorrecto");
        }
        cargarDatos();
    }

    public static void cargarDatos() {

        try {
            String usuario, contrasenia;
            File archivo = new File("src\\basedatos\\Datos_Usuarios.txt");
            Scanner entrada = null;

            entrada = new Scanner(archivo);

            while (entrada.hasNext()) {
                usuario = entrada.next();
                contrasenia = entrada.next();

                usuarios.put(usuario, contrasenia);
            }

            entrada.close();

        } catch (FileNotFoundException ex) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("No se cargaron correctamente los datos");
            error.setContentText("Los datos de los usuarios no se han cargado de la forma debida");
            error.show();
        } catch (IOException ex) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("No se cargaron correctamente los datos");
            error.setContentText("Los datos de los usuarios no se han cargado de la forma debida");
        }
    }

    public static boolean estaRegistrado(String usuario) {
        return (usuarios.containsKey(usuario));
    }

    public static boolean loginCorrecto(String usuario, String contrasenia) {
        boolean esCorrecto = false;

        for (Map.Entry<String, String> entry : usuarios.entrySet()) {
            if (entry.getKey().equals(usuario) && entry.getValue().equals(contrasenia)) {
                esCorrecto = true;
            }
        }

        return esCorrecto;
    }
}
