import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Conversion {
    public Conversion(List<String> datos, String rutacarpeta) {
        if (datos == null || datos.isEmpty()) {
            System.out.println("No hay datos para convertir.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Dime a qué lo quieres convertir (CSV, JSON o XML):");
        String formato = scanner.nextLine().toUpperCase();

        System.out.println("Ponme el nombre del archivo de salida (sin extensión):");
        String nombrearchivo = scanner.nextLine();

        String nombrecompleto = rutacarpeta + "/" + nombrearchivo;

        try {
            switch (formato) {
                case "CSV" -> {
                    nombrecompleto += ".csv";
                    escribirCSV(datos, nombrecompleto);
                }
                case "JSON" -> {
                    nombrecompleto += ".json";
                    escribirJSON(datos, nombrecompleto);
                }
                case "XML" -> {
                    nombrecompleto += ".xml";
                    escribirXML(datos, nombrecompleto);
                }
                default -> {
                    System.out.println("Formato no válido.");
                    return;
                }
            }
            System.out.println("Archivo convertido y guardado en: " + nombrecompleto);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }


    public Conversion(String datos, String rutacarpeta) {
        this(List.of(datos), rutacarpeta); 
    }

    private void escribirCSV(List<String> datos, String nombrearchivo) throws IOException {
        try (FileWriter writer = new FileWriter(nombrearchivo)) {
            for (String dato : datos) {
                writer.write(dato + "\n");
            }
        }
    }

    private void escribirJSON(List<String> datos, String nombrearchivo) throws IOException {
        try (FileWriter writer = new FileWriter(nombrearchivo)) {
            writer.write("[\n");
            for (int i = 0; i < datos.size(); i++) {
                writer.write("  \"" + datos.get(i) + "\"");
                if (i < datos.size() - 1) {
                    writer.write(",");
                }
                writer.write("\n");
            }
            writer.write("]");
        }
    }

    private void escribirXML(List<String> datos, String nombrearchivo) throws IOException {
        try (FileWriter writer = new FileWriter(nombrearchivo)) {
            writer.write("<datos>\n");
            for (String dato : datos) {
                writer.write("  <dato>" + dato + "</dato>\n");
            }
            writer.write("</datos>");
        }
    }
}






