import java.util.*;

sealed class Libro permits LibroImpreso, LibroDigital { protected String titulo, autor; protected double precio;

    public Libro(String titulo, String autor, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    public void mostrarInfo() {
        System.out.printf("Título: %s\nAutor: %s\nPrecio: %.2f\n", titulo, autor, precio);
    }

}

final class LibroImpreso extends Libro { private double peso;

    public LibroImpreso(String titulo, String autor, double precio, double peso) {
        super(titulo, autor, precio);
        this.peso = peso;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.printf("Peso: %.2f kg\n", peso);
    }

}

final class LibroDigital extends Libro { private double tamanioArchivo;

    public LibroDigital(String titulo, String autor, double precio, double tamanioArchivo) {
        super(titulo, autor, precio);
        this.tamanioArchivo = tamanioArchivo;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.printf("Tamaño del archivo: %.2f MB\n", tamanioArchivo);
    }

}

public class Main { public static void main(String[] args) { Scanner scanner = new Scanner(System.in); List<Libro> libros = new ArrayList<>();

    while (true) {
        System.out.println("Ingrese el tipo de libro (1 - Impreso, 2 - Digital, 0 - Salir): ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion == 0) break;

        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        if (opcion == 1) {
            System.out.print("Peso (kg): ");
            double peso = scanner.nextDouble();
            libros.add(new LibroImpreso(titulo, autor, precio, peso));
        } else if (opcion == 2) {
            System.out.print("Tamaño del archivo (MB): ");
            double tamanio = scanner.nextDouble();
            libros.add(new LibroDigital(titulo, autor, precio, tamanio));
        }
    }

    System.out.println("\nLista de libros registrados:");
    libros.forEach(libro -> {
        libro.mostrarInfo();
        System.out.println("----------------");
    });
}

}