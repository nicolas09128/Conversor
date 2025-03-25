import java.io.File;
import java.util.Scanner;

public class SelectorCarpeta {
    private String rutacarpeta;
    
    public SelectorCarpeta() {
        this.rutacarpeta = null;
    }

    public String seleccionarCarpeta(Scanner scanner) {
        System.out.println("Introduzca la ruta de la carpeta: ");
        String ruta = scanner.nextLine();

        File carpeta = new File(ruta);
        if (carpeta.exists() && carpeta.isDirectory()) {
            this.rutacarpeta = ruta;
            System.out.println("Carpeta seleccionada: " + ruta);
        } else {
            System.out.println("La ruta de la carpeta no es válida o la carpeta no existe.");
            this.rutacarpeta = null;
        }

        return this.rutacarpeta;
    }

    public String getRutaCarpeta() {
        return rutacarpeta;
    }
}
