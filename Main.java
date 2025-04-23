import java.io.*;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Persona> personas = new ArrayList<>();
    static List<Perro> perrosDisponibles = new ArrayList<>();

    public static void main(String[] args) {
        cargarPerros();
        cargarPersonas();

        while (true) {
            System.out.print("\n¿Eres admin? (s/n): ");
            String rol = sc.nextLine().trim().toLowerCase();
            if (rol.equals("s")) menuAdmin();
            else if (rol.equals("n")) menuUsuario();
            else System.out.println("Opción inválida.");
        }
    }

    static void menuAdmin() {
        while (true) {
            System.out.println("""
                \n--- MENÚ ADMIN ---
                1. Registrar persona
                2. Registrar perro
                3. Ver personas
                4. Ver perros disponibles
                5. Adoptar perro
                6. Perro más viejo adoptado
                7. Salir
            """);
            switch (sc.nextLine()) {
                case "1" -> registrarPersona();
                case "2" -> registrarPerro();
                case "3" -> personas.forEach(System.out::println);
                case "4" -> perrosDisponibles.forEach(System.out::println);
                case "5" -> adoptarPerro();
                case "6" -> mostrarPerroMasViejo();
                case "7" -> { System.exit(0); }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    static void menuUsuario() {
        while (true) {
            System.out.println("""
                \n--- MENÚ CLIENTE ---
                1. Registrarse
                2. Ver perros disponibles
                3. Adoptar perro
                4. Salir
            """);
            switch (sc.nextLine()) {
                case "1" -> registrarPersona();
                case "2" -> perrosDisponibles.forEach(System.out::println);
                case "3" -> adoptarPerro();
                case "4" -> { System.exit(0); }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    static void registrarPersona() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Edad: ");
        int edad = Integer.parseInt(sc.nextLine());
        System.out.print("Documento: ");
        String doc = sc.nextLine();
        Persona p = new Persona(nombre, apellido, edad, doc);
        personas.add(p);
        guardarPersona(p);
        System.out.println("Persona registrada.");
    }

    static void registrarPerro() {
        System.out.print("Placa: ");
        String placa = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Raza: ");
        String raza = sc.nextLine();
        System.out.print("Edad: ");
        int edad = Integer.parseInt(sc.nextLine());
        System.out.print("Tamaño: ");
        String tam = sc.nextLine();
        Perro p = new Perro(placa, nombre, raza, edad, tam);
        perrosDisponibles.add(p);
        guardarPerro(p);
        System.out.println("Perro registrado.");
    }

    static void adoptarPerro() {
        System.out.print("Documento de la persona: ");
        String doc = sc.nextLine();
        Persona persona = buscarPersona(doc);
        if (persona == null) {
            System.out.println("Persona no encontrada.");
            return;
        }

        System.out.print("Placa del perro: ");
        String placa = sc.nextLine();
        Perro perro = buscarPerro(placa);
        if (perro == null) {
            System.out.println("Perro no disponible.");
            return;
        }

        if (persona.adoptarPerro(perro)) {
            perrosDisponibles.remove(perro);
            sobrescribirPerros();
            System.out.println("Adopción exitosa.");
        } else {
            System.out.println("Esta persona ya adoptó 3 perros.");
        }
    }

    static void mostrarPerroMasViejo() {
        System.out.print("Documento de la persona: ");
        String doc = sc.nextLine();
        Persona p = buscarPersona(doc);
        if (p == null) {
            System.out.println("Persona no encontrada.");
            return;
        }
        Perro mayor = p.perroMasGrande();
        System.out.println(mayor != null ? "Perro más viejo: " + mayor : "No ha adoptado perros.");
    }

    static Persona buscarPersona(String doc) {
        return personas.stream().filter(p -> p.getDocumento().equals(doc)).findFirst().orElse(null);
    }

    static Perro buscarPerro(String placa) {
        return perrosDisponibles.stream().filter(p -> p.getPlaca().equals(placa)).findFirst().orElse(null);
    }

    static void cargarPerros() {
        try (BufferedReader br = new BufferedReader(new FileReader("perros.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] p = linea.split(",");
                perrosDisponibles.add(new Perro(p[0], p[1], p[2], Integer.parseInt(p[3]), p[4]));
            }
        } catch (IOException e) {
            System.out.println("No se encontró 'perros.txt'. Se creará automáticamente.");
        }
    }

    static void cargarPersonas() {
        try (BufferedReader br = new BufferedReader(new FileReader("personas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] p = linea.split(",");
                personas.add(new Persona(p[0], p[1], Integer.parseInt(p[2]), p[3]));
            }
        } catch (IOException e) {
            System.out.println("No se encontró 'personas.txt'. Se creará automáticamente.");
        }
    }

    static void guardarPerro(Perro p) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("perros.txt", true))) {
            pw.println(p.formatoArchivo());
        } catch (IOException e) {
            System.out.println("Error guardando perro.");
        }
    }

    static void guardarPersona(Persona p) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("personas.txt", true))) {
            pw.println(p.formatoArchivo());
        } catch (IOException e) {
            System.out.println("Error guardando persona.");
        }
    }

    static void sobrescribirPerros() {
        try (PrintWriter pw = new PrintWriter("perros.txt")) {
            for (Perro p : perrosDisponibles) pw.println(p.formatoArchivo());
        } catch (IOException e) {
            System.out.println("Error al actualizar perros.");
        }
    }
}