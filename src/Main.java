import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Historial historial = new Historial();

        historial.cargar();

        System.out.println("Bienvenido al Conversor de Monedas :D");

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Convertir moneda");
            System.out.println("2. Mostrar historial (de las últimas conversiones)");
            System.out.println("3. Salir");
            System.out.print("Opción --> ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el código o nombre de la moneda base (ej: USD o Dólar estadounidense): ");
                    String entradaBase = scanner.nextLine();
                    String entradaCodigo = buscarCodigoMoneda(entradaBase);
                    if (entradaCodigo == null) {
                        System.out.println("La moneda base no fue encontrada.");
                        continue;
                    }

                    System.out.print("Ingrese el código o nombre de la moneda destino (ej: CLP o Peso Chileno): ");
                    String destino = scanner.nextLine();
                    String destinoCodigo = buscarCodigoMoneda(destino);
                    if (destinoCodigo == null) {
                        System.out.println("La moneda de destino no fué encontrada.");
                        continue;
                    }


                    System.out.print("Ingrese el monto de dinero a convertir: ");
                    double cantidad = scanner.nextDouble();


                    try {
                        double resultado = ApiCliente.convertirMoneda(entradaCodigo, destinoCodigo, cantidad);
                        String conversion = String.format("%.2f %s equivalen a %.2f %s", cantidad, entradaCodigo, resultado, destinoCodigo);
                        System.out.println("Resultado: " + conversion);
                        historial.agregar(conversion);
                    } catch (Exception e) {
                        System.out.println("Error durante la conversión: " + e.getMessage());
                    }
                }
                case 2 -> historial.mostrar();
                case 3 -> {
                    System.out.println("Cerrando el programa... ¡Gracias por usar el conversor!");
                    historial.guardar();
                    return;
                }
                default -> System.out.println("Opción Inválida. Intente nuevamente.");
            }
        }
    }

    private static String buscarCodigoMoneda(String entrada) {

        if (entrada.length() == 3) {

            return NombreMoneda.encontrarCodigo(entrada).equalsIgnoreCase("Código no encontrado") ? null : entrada.toUpperCase();
        } else {

            return NombreMoneda.encontrarNombre(entrada).equalsIgnoreCase("Nombre no encontrado") ? null : NombreMoneda.encontrarNombre(entrada);
        }
    }
}
