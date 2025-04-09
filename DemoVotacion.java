public class DemoVotacion {
    public static void main(String[] args) {
        System.out.println("=== Iniciando Demo del Sistema de Votación ===");

        SistemaVotacion sistema = new SistemaVotacion();

        System.out.println("\n--- Simulando Votos ---");
        sistema.registrarVoto("Candidato A", TipoPublicidad.INTERNET);
        sistema.registrarVoto("Candidato B", TipoPublicidad.RADIO);
        sistema.registrarVoto("Candidato A", TipoPublicidad.TELEVISION);
        sistema.registrarVoto("Candidato C", TipoPublicidad.INTERNET);
        sistema.registrarVoto("Candidato B", TipoPublicidad.RADIO);
        sistema.registrarVoto("Candidato A", TipoPublicidad.INTERNET);
        sistema.registrarVoto("Candidato B", TipoPublicidad.TELEVISION);
        sistema.registrarVoto("Candidato Fantasma", TipoPublic);
        System.out.println("--- Fin Simulación Votos ---");

        sistema.mostrarResumenResultados();

        String candidatoConsultado = "Candidato A";
        long costo = sistema.getCostoCampanaDe(candidatoConsultado);
        System.out.println("\nConsulta específica:");
        if (costo != -1) {
            System.out.println(" -> Costo de campaña para " + candidatoConsultado + ": $" + costo);
        } else {
            System.out.println(" -> No se encontro al candidato: " + candidatoConsultado);
        }

        sistema.reiniciarEleccion();

        System.out.println("\n--- Resultados después de reiniciar ---");
        sistema.mostrarResumenResultados();

        System.out.println("\n=== Demo t");
    }
}