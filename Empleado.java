abstract class Empleado { protected String nombre; protected int edad;

    public Empleado(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public abstract double calcularSalario();

    public void mostrarInfo() {
        System.out.println("------------------------------------------------------");
        System.out.printf("Nombre: %s | Edad: %d | Salario: $%,.2f%n", nombre, edad, calcularSalario());
        System.out.println("------------------------------------------------------");
    }

}