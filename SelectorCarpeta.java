import java.io.File;
import java.util.Scanner;

public class SelectorCarpeta {
    private static String rutacarpeta; 
    
    public SelectorCarpeta() {
        rutacarpeta = null;
    }

    public String seleccionarCarpeta(Scanner scanner) {
        System.out.println("Introduzca la ruta de la carpeta: ");
        String ruta = scanner.nextLine();

        File carpeta = new File(ruta);
        if (carpeta.exists() && carpeta.isDirectory()) {
            rutacarpeta = ruta;
            System.out.println("Carpeta seleccionada: " + ruta);
        } else {
            System.out.println("La ruta de la carpeta no es válida o la carpeta no existe.");
            rutacarpeta = null;
        }

        return rutacarpeta;
    }
    
    public static String getRutaCarpeta() { 
        return rutacarpeta;
    }

    public String[] listarContenidoCarpeta() {
        if (rutacarpeta == null) {
            System.out.println("Ninguna carpeta.");
            return null;
        }

        File carpeta = new File(rutacarpeta);
        String[] contenido = carpeta.list();
        if (contenido != null) {
            return contenido;
        } else {
            System.out.println("No se pudo obtener el contenido de la carpeta.");
            return null;
        }
    }
    
    @Override
    public String toString() {
        String[] contenido = listarContenidoCarpeta();
        if (contenido == null || contenido.length == 0) {
            return "La carpeta está vacía o no se pudo listar su contenido.";
        }
        StringBuilder resultado = new StringBuilder("Contenido de la carpeta:\n");
        for (String item : contenido) {
            resultado.append("- ").append(item).append("\n");
        }
        return resultado.toString();
    }
}
