
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        double dinero;
        int resultado;

        System.out.print("Hola ingresa tu dinero ---> ");
        dinero = sc.nextDouble();
        while (dinero > 0) {
            resultado = rand.nextInt(3) + 1;
            System.out.println("obtuviste el numero " + resultado);

            dinero = switch (resultado) {
                case 3 -> 0;
                case 2 -> dinero / 2;
                default -> dinero * 2;
            };
            if (dinero == 0) {
                System.out.println("¡Perdiste todo tu dinero! :(");
                break;
            }
            System.out.println("tu saldo ahora es ---> " + dinero);
            System.out.print("¿quieres seguir jugando? ---> (si/no):");
            if (!sc.next().equalsIgnoreCase("si"));
            System.out.print("¿quieres seguir con este monto o ingresar uno nuevo? (actual/nuevo):");
            if (sc.next().equalsIgnoreCase("nuevo")) {
                System.out.print("Ingresa la nueva cantidad ---> ");
                dinero = sc.nextDouble();
            }
        }
        System.out.println("Tu dinero final es:" + dinero);
    }
}










