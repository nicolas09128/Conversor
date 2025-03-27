import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LecturaFichero {
    private Map<String, String> contenidoArchivos = new HashMap<>();
    private String archivoSeleccionado; 

    //Permite al usuario poner el nombre del archivo y leerlo almacenandolo 

    public void leerArchivo() {
        Scanner scanner = new Scanner(System.in); 
        try {
            System.out.println("Ingresa el nombre del archivo:");
            String nombreArchivo = scanner.nextLine();

            String rutaCarpeta = SelectorCarpeta.getRutaCarpeta(); 

            //Verifica si se a seleccionado la carpeta
            if (rutaCarpeta == null) {
                return;
            }

            //Verifica si el archivo existe en la carpeta
            File archivo = new File(rutaCarpeta, nombreArchivo);
            if (!archivo.exists()) {
                System.out.println("El archivo no existe en la carpeta seleccionada.");
                return;
            }

              //Intenta saber la extension del archivo
            String extension = obtenerExtension(nombreArchivo);
            if (extension == null) {
                System.out.println("No se pudo determinar el formato del archivo.");
                return;
            }
            //Lee las lineas del archivo y las une en un string
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


    //Obtiene el nombre del archivo
    public String obtenerArchivoSeleccionado() {
        return archivoSeleccionado; 
    }
    //Determina la extension de un archivo
    private String obtenerExtension(String nombreArchivo) {
        int indice = nombreArchivo.lastIndexOf('.');
        if (indice > 0 && indice < nombreArchivo.length() - 1) {
            return nombreArchivo.substring(indice + 1).toLowerCase();
        }
        return null;
    }

    //Obtiene el contenido del archivo
    public String obtenerContenido(String nombreArchivo) {
        return contenidoArchivos.get(nombreArchivo);
    }
    
}
