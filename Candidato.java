import java.util.EnumMap;
import java.util.Map;

public class Candidato {
    private final String nombre;
    private final Map<TipoPublicidad, Integer> votosRecibidos;

    public Candidato(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            this.nombre = "Candidato Anónimo";
            System.err.println("Advertencia: Se creó un candidato con nombre inválido.");
        } else {
            this.nombre = nombre.trim();
        }
        this.votosRecibidos = new EnumMap<>(TipoPublicidad.class);
        reiniciarConteoVotos();
    }

    public void registrarVoto(TipoPublicidad tipo) {
        if (tipo != null) {
            int conteoActual = this.votosRecibidos.getOrDefault(tipo, 0);
            this.votosRecibidos.put(tipo, conteoActual + 1);
        } else {
            System.err.println("Error: Se intentó registrar un voto sin tipo de publicidad para " + this.nombre);
        }
    }

    public long calcularCostoTotalCampana() {
        long costoTotal = 0;
        for (Map.Entry<TipoPublicidad, Integer> registro : votosRecibidos.entrySet()) {
            TipoPublicidad tipo = registro.getKey();
            int cantidadVotos = registro.getValue();
            costoTotal += (long) cantidadVotos * tipo.getCostoPorVoto();
        }
        return costoTotal;
    }

    public int getTotalVotos() {
        int total = 0;
        for (int votos : votosRecibidos.values()) {
            total += votos;
        }
        return total;
    }

    public void reiniciarConteoVotos() {
        for (TipoPublicidad tipo : TipoPublicidad.values()) {
            this.votosRecibidos.put(tipo, 0);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Map<TipoPublicidad, Integer> getVotosDetallados() {
        return new EnumMap<>(votosRecibidos);
    }

    @Override
    public String toString() {
        return "Candidato: " + nombre + " | Votos: " + getTotalVotos() +
                " | Costo Campaña: $" + calcularCostoTotalCampana();
    }
}