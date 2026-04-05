import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class JCF {
    public static void main(String[] args) {
        PriorityQueue<Paciente> heap = new PriorityQueue<>();

        try (BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Paciente paciente = new Paciente(parts[0].trim(), parts[1].trim(), parts[2].trim());
                    heap.add(paciente);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        System.out.println("Pacientes en orden de prioridad:");
        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }    
}
