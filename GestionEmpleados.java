import java.util.*;

public class GestionEmpleados { private static final Scanner scanner = new Scanner(System.in); private static final List<Empleado> empleados = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Registrar Empleado de Planta\n2. Registrar Empleado por Horas\n3. Mostrar Empleados\n4. Salir");
            switch (scanner.nextInt()) {
                case 1 -> registrarEmpleadoPlanta();
                case 2 -> registrarEmpleadoPorHoras();
                case 3 -> empleados.forEach(Empleado::mostrarInfo);
                case 4 -> { return; }
                default -> System.out.println("Opción invalida");
            }
        }
    }

    private static void registrarEmpleadoPlanta() {
        System.out.print("Nombre del empleado: ");
        String nombre = scanner.next();
        System.out.print("Edad del empleado: ");
        int edad = scanner.nextInt();
        empleados.add(new EmpleadoPlanta(nombre, edad));
        System.out.println("Empleado registrado con exito en el sistema");
    }

    private static void registrarEmpleadoPorHoras() {
        System.out.print("Nombre del empleado: ");
        String nombre = scanner.next();
        System.out.print("Edad del empleado: ");
        int edad = scanner.nextInt();
        System.out.print("Digite las horas trabajadas: ");
        int horas = scanner.nextInt();
        empleados.add(new EmpleadoPorHoras(nombre, edad, 98_000, horas));
        System.out.println("Empleado registrado con exito en el sistema");
    }

}
