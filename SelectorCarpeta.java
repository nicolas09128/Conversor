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
}
