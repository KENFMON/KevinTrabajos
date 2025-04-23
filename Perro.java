public class Perro {
    private String placa, nombre, raza, tamaño;
    private int edad;

    public Perro(String placa, String nombre, String raza, int edad, String tamaño) {
        this.placa = placa;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.tamaño = tamaño;
    }

    public String getPlaca() { return placa; }
    public String getNombre() { return nombre; }
    public String getRaza() { return raza; }
    public int getEdad() { return edad; }
    public String getTamaño() { return tamaño; }

    public String toString() {
        return placa + " - " + nombre + " (" + raza + ", " + edad + " años, " + tamaño + ")";
    }

    public String formatoArchivo() {
        return placa + "," + nombre + "," + raza + "," + edad + "," + tamaño;
    }
}