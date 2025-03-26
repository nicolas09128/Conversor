
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Conversion {
    public Conversion(List<String> datos, String rutacarpeta){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Dime a que formato quieres convertir los datos (CSV, JSON o XML)");
        String formato = scanner.nextLine().toUpperCase();

        System.out.println("Introduce el nombre del archivo: ");
        String nombrearchivo = scanner.nextLine();

        String nombrecompleto = rutacarpeta + "/" + nombrearchivo;

        try{
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
                System.out.println("Formato no valido");
                return;
                }
        }
        System.out.println("Archivo convertido a: " + nombrecompleto);

    } catch (IOException e){
        System.out.println("Error al escribir el archivo" + e.getMessage());
    }
} 

 private void escribirCSV(List<String> datos, String nombrearchivo) throws IOException{
    try (FileWriter Writer = new FileWriter(nombrearchivo)){
        for (String dato: datos){
            Writer.write(dato + "\n");
        }
    }
 }

    private void escribirJSON(List<String> datos, String nombrearchivo) throws IOException {
        try (FileWriter writer = new FileWriter(nombrearchivo)) {
            writer.write("Formato JSON no implementado\n");
            for (String dato : datos){
                writer.write(dato + "\n");
            }   
        }
    }

    private void escribirXML(List<String> datos, String nombrearchivo) throws IOException {
        try (FileWriter writer = new FileWriter(nombrearchivo)){
            writer.write("Formato xml no implementado\n");
            for (String dato : datos){
                writer.write(dato + "\n");
            }
        }
    }
   
 
}

    

    


