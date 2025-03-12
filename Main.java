import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int llamadas = 0, duracionllamada = 0, costofinal = 0, opcion, minutos;
    System.out.println("---- CONTROLADOR DE LINEAS TELEFONICAS ----");

    while (true){
        System.out.println("\n1. Registrar Llamada. \n2. Mostrar información almacenada. \n3. Reiniciar. \n4. Salir.");
        opcion = sc.nextInt();
        if (opcion == 1) {
            System.out.println("\n1. Llamada local. \n2. Llamada de larga distancia. \n3. Llamada a celular.");
            int tipo = sc.nextInt();
            System.out.println("Duración en minutos: ");
            minutos = sc.nextInt();
            llamadas += 1;
            duracionllamada += minutos;
            costofinal += (tipo == 1 ? 50 : tipo ==2 ? 350: 150) * minutos;
        } else if (opcion == 2) {
            System.out.println("Llamadas = " + llamadas + "\n Duracion Total:" + duracionllamada + " minutos" + "\n Costo total: $ " + costofinal);
        } else if (opcion == 3) {
            llamadas = costofinal = duracionllamada = 0;
            System.out.println("Toda la información ha sido reiniciada");
        } else if (opcion == 4) break;

        }
        sc.close();
    }

}
