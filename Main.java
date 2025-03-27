import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /*
     * @autor: Nicolás
     * @autor: Jose Antonio
     * @version: 2.0
     */
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
            System.out.println("║ 4.  Menú Extra                    ║");
            System.out.println("║ 5.  Salir                         ║");
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
                    String archivoSeleccionado = lecturaFichero.obtenerArchivoSeleccionado();
                    if (archivoSeleccionado == null) {
                        System.out.println("Primero debes seleccionar y leer un archivo.");
                    } else {
                        String contenido = lecturaFichero.obtenerContenido(archivoSeleccionado);
                        if (contenido != null) {
                            new Conversion(Arrays.asList(contenido.split("\n")), SelectorCarpeta.getRutaCarpeta());
                        } else {
                            System.out.println("No se pudo obtener el contenido del archivo.");
                        }
                    }
                    break;
                case 4:
                    int opcionExtra;
                    do {
                        System.out.println("\n╔═══════════════════════════════════╗");
                        System.out.println("║            MENÚ EXTRA             ║");
                        System.out.println("╠═══════════════════════════════════╣");
                        System.out.println("║ 1. Mostrar Ruta carpeta           ║ ") ;
                        System.out.println("║ 2. Mostrar Contenido carpeta      ║   ");
                        System.out.println("║ 3. Mostrar Fichero seleccionado   ║   ");
                        System.out.println("║ 4. Volver al menú principal       ║");
                        System.out.println("╚═══════════════════════════════════╝");
                        System.out.print("   Elige una opción: ");
                        opcionExtra = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcionExtra) {
                            case 1:
                                System.out.println("Ruta carpeta: " + (SelectorCarpeta.getRutaCarpeta()));
                                break;
                            case 2:
                                System.out.println(selectorCarpeta.toString());
                                break;
                            case 3:
                                archivoSeleccionado = lecturaFichero.obtenerArchivoSeleccionado();
                                    System.out.println("Fichero seleccionado: " + archivoSeleccionado);
                                break;
                            case 4:
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                    } while (opcionExtra != 4);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }
}
