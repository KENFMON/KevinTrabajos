import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int opcion;
        do {
            System.out.println(" ️ CONVERSOR DE TEMPERATURAS ");
            System.out.println("1. Celsius a Fahrenheit ");
            System.out.println("2 Celsius a Kelvin ");
            System.out.println("3. Celsius a Rankine");
            System.out.println("4. Celsius a Réaumur");
            System.out.println("5. Fahrenheit a Celsius ");
            System.out.println("6. Fahrenheit a Kelvin ");
            System.out.println("7. Fahrenheit a Rankine ");
            System.out.println("8. Fahrenheit a Réaumur");
            System.out.println("9. Kelvin a Celsius ");
            System.out.println("10.Kelvin a Fahrenheit ");
            System.out.println("11.Kelvin a Rankine ");
            System.out.println("12.Kelvin a Réaumur ");
            System.out.println("13.Rankine a Celsius ");
            System.out.println("14.Rankine a Fahrenheit ");
            System.out.println("15 Rankine a Kelvin ");
            System.out.println("16.Salir");

            System.out.print("Selecciona una opción (1-16): ");

            while (!sc.hasNextInt()) {
             System.out.print("Error Ingresa un número valido");
             sc.next();
            }
            opcion = sc.nextInt();

            if (opcion >= 1 && opcion <= 15) {
                System.out.print("Ingresa la temperatura: ");
                while (!sc.hasNextDouble()) {
                    System.out.print("Error ingrese de nuevo la temperatura");
                    sc.next();
                }
                double temperatura = sc.nextDouble();
                double resultado = convertir(opcion, temperatura);
                System.out.println("Resultado: " + resultado);
            } else if (opcion != 16) {
                System.out.println("Opción no válida, intenta de nuevo.");
            }

        } while (opcion != 16);

        System.out.println("¡Gracias por usar el conversor de tempperatras");
        sc.close();
    }

    public static double convertir(int opcion, double temp){
        return switch (opcion) {
            case 1 -> (temp * 9 / 5) + 32;
            case 2 -> temp + 273.15;
            case 3 -> (temp + 273.15) * 9 / 5;
            case 4 -> temp * 4 / 5;
            case 5 -> (temp - 32) * 5 / 9;
            case 6 -> (temp - 32) * 5 / 9 + 273.15;
            case 7 -> temp + 459.67;
            case 8 -> (temp - 32) * 4 / 9;
            case 9 -> temp - 273.15;
            case 10 -> (temp - 273.15) * 9 / 5 + 32;
            case 11 -> temp * 9 / 5;
            case 12 -> (temp - 273.15) * 4 / 5;
            case 13 -> (temp - 491.67) * 5 / 9;
            case 14 -> temp - 459.67;
            case 15 -> temp * 5 / 9;
            default -> 0;
        };
    }
}