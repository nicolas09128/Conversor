import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        SelectorCarpeta selectorCarpeta = new SelectorCarpeta();
        LecturaFichero lecturaFichero = new LecturaFichero();
        do {
            System.out.println("\n╔═══════════════════════════════════╗");
            System.out.println("║         MENÚ PRINCIPAL            ║");
            System.out.println("╠═══════════════════════════════════╣");
            System.out.println("║ 1.  Seleccionar carpeta           ║");
            System.out.println("║ 2.  Lectura de fichero            ║");
            System.out.println("║ 3.  Conversión a...               ║");
            System.out.println("║ 4.  Salir                         ║");
            System.out.println("╚═══════════════════════════════════╝");
            System.out.print("   Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                   selectorCarpeta.seleccionarCarpeta(scanner);
                break;
                case 2:
                    lecturaFichero.leerArchivo();
                break;
                case 3:
                //     Conversión();
                  break;
                default:
                     System.out.println("Opción no válida.");
                break;
                    }
            } while (opcion != 3);
                    
        scanner.close();
    }
                    
              

}
