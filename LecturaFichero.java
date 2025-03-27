import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LecturaFichero {
    private Map<String, String> contenidoArchivos = new HashMap<>();
    private String archivoSeleccionado; 

    public void leerArchivo() {
        Scanner scanner = new Scanner(System.in); 
        try {
            System.out.println("Ingresa el nombre del archivo:");
            String nombreArchivo = scanner.nextLine();

            String rutaCarpeta = SelectorCarpeta.getRutaCarpeta(); 
            if (rutaCarpeta == null) {
                return;
            }

            File archivo = new File(rutaCarpeta, nombreArchivo);
            if (!archivo.exists()) {
                System.out.println("El archivo no existe en la carpeta seleccionada.");
                return;
            }

            String extension = obtenerExtension(nombreArchivo);
            if (extension == null) {
                System.out.println("No se pudo determinar el formato del archivo.");
                return;
            }

            try {
                String contenido = String.join("\n", Files.readAllLines(archivo.toPath()));
                contenidoArchivos.put(nombreArchivo, contenido);
                archivoSeleccionado = nombreArchivo; 
                System.out.println("Archivo leído y almacenado exitosamente.");
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public String obtenerArchivoSeleccionado() {
        return archivoSeleccionado; 
    }

    private String obtenerExtension(String nombreArchivo) {
        int indice = nombreArchivo.lastIndexOf('.');
        if (indice > 0 && indice < nombreArchivo.length() - 1) {
            return nombreArchivo.substring(indice + 1).toLowerCase();
        }
        return null;
    }

    public String obtenerContenido(String nombreArchivo) {
        return contenidoArchivos.get(nombreArchivo);
    }
    
}
