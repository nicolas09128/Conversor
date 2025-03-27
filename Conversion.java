import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Conversion {
    public Conversion(List<String> datos, String rutacarpeta) { //Constructor de la clase conversion
        if (datos == null || datos.isEmpty()) { //Valida si la lista de datos esta vacia
            System.out.println("No hay datos para convertir.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Dime a qué lo quieres convertir (CSV, JSON o XML):");
        String formato = scanner.nextLine().toUpperCase(); // Lee el formato que quiera el usuario

        System.out.println("Ponme el nombre del archivo de salida (sin extensión):");
        String nombrearchivo = scanner.nextLine();//Construye la ruta del archivo

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
        } //Constructor alternativo que deja pasar los datos con un string
    }


    public Conversion(String datos, String rutacarpeta) {
        this(List.of(datos), rutacarpeta); 
    }

    private void escribirCSV(List<String> datos, String nombrearchivo) throws IOException { //Escribe los datos en un archivo csv
        try (FileWriter writer = new FileWriter(nombrearchivo)) {
            for (String dato : datos) {
                writer.write(dato + "\n");
            }
        }
    }

    private void escribirJSON(List<String> datos, String nombrearchivo) throws IOException { //Escribe los datos en un archivo json
        try (FileWriter writer = new FileWriter(nombrearchivo)) {
            writer.write("[\n");
            for (int i = 0; i < datos.size(); i++) {
                writer.write("  \"" + datos.get(i) + "\"");
                if (i < datos.size() - 1) {
                    writer.write(",");
                }
                writer.write("\n");
            }
            writer.write("]");//Cierra el array de json
        }
    }

    private void escribirXML(List<String> datos, String nombrearchivo) throws IOException { //Escribe los datos en un archivo xml
        try (FileWriter writer = new FileWriter(nombrearchivo)) {
            writer.write("<coches>\n");
            for (String dato : datos) {
                writer.write("  <coche>" + dato + "</coche>\n");
            }
            writer.write("</coches>");
        }
    }

    private void escribirXML(
        String nombrearchivo,
        String marca,
        String modelo,
        String año,
        String color,
        double precio
        )
        throws IOException{
        try (FileWriter writer = new FileWriter(nombrearchivo)){ //Escribe los datos en un archivo xml
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<marca>" + marca + "</marca>\n");
            writer.write("<modelo>" + modelo + "</modelo>\n");
            writer.write("<año>" + año + "</año>\n");
            writer.write("<color>" + color + "</color>\n");
            writer.write("<precio>" + precio + "</precio>\n");

        }
    }

    public static void escribirJSON( //Escribe los datos en un archivo json
        String nombreArchivo,
        String marca,
        String modelo,
        int año,
        String color,
        double precio
    ) throws IOException {
        JSONObject coche = new JSONObject();
        coche.put("Marca", marca);
        coche.put("Modelo", modelo);
        coche.put("Año", año);
        coche.put("Color", color);
        coche.put("Precio", precio);

        try (FileWriter file = new FileWriter(nombreArchivo)) { //Escribe los datos en un archivo json con 2 espacios
            file.write(coche.toString(2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generarJSON(String[] args) { // Metodo de ejemplo para generar un archivo JSON con información de un coche
        try {
            escribirJSON(
                "coche.json", 
                "Toyota", 
                "Corolla", 
                2022, 
                "Rojo", 
                20000.0
            );
            System.out.println("Archivo JSON creado con éxito");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo JSON: " + e.getMessage());
        }
    }
}







