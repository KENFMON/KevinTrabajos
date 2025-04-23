import java.util.*;

public class Persona {
    private String nombre, apellido, documento;
    private int edad;
    private List<Perro> perrosAdoptados = new ArrayList<>();

    public Persona(String nombre, String apellido, int edad, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
    }

    public String getDocumento() { return documento; }
    public List<Perro> getPerrosAdoptados() { return perrosAdoptados; }

    public boolean adoptarPerro(Perro perro) {
        if (perrosAdoptados.size() < 3) {
            perrosAdoptados.add(perro);
            return true;
        }
        return false;
    }

    public Perro perroMasGrande() {
        return perrosAdoptados.stream()
                .max(Comparator.comparingInt(Perro::getEdad))
                .orElse(null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(" ").append(apellido)
                .append(" (").append(edad).append(" años, Doc: ").append(documento).append(")\n");
        if (perrosAdoptados.isEmpty()) sb.append("  No ha adoptado perros.\n");
        else for (Perro p : perrosAdoptados) sb.append("  - ").append(p).append("\n");
        return sb.toString();
    }

    public String formatoArchivo() {
        return nombre + "," + apellido + "," + edad + "," + documento;
    }
}