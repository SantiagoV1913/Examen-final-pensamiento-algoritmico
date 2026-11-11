import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] temperaturas = new double[360];
        boolean datosRegistrados = false;
        int opcion;

        do {
            System.out.println("\n --- Estacion Meteorologica ---");
            System.out.println("1. Registrar temperaturas");
            System.out.println("2. Mostrar temperaturas por mes");
            System.out.println("3. Buscar mayor temperatura");
            System.out.println("4. Buscar menor temperatura");
            System.out.println("5. Contar temperaturas (>, <, = a 25)");
            System.out.println("6. Calcular promedio");
            System.out.println("7. Ordenar temperaturas");
            System.out.println("8. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    temperaturas = registrarTemperaturas(360);
                    datosRegistrados = true;
                    System.out.println("Temperaturas registradas.");
                    break;
                case 2:
                    if (datosRegistrados) mostrarTemperaturas(temperaturas);
                    else System.out.println("Error: Primero debes registrar las temperaturas.");
                    break;
                case 3:
                    if (datosRegistrados) obtenerMayor(temperaturas);
                    else System.out.println("Error: Primero debes registrar las temperaturas.");
                    break;
                case 4:
                    if (datosRegistrados) obtenerMenor(temperaturas);
                    else System.out.println("Error: Primero debes registrar las temperaturas.");
                    break;
                case 5:
                    if (datosRegistrados) contarTemperaturas(temperaturas);
                    else System.out.println("Error: Primero debes registrar las temperaturas.");
                    break;
                case 6:
                    if (datosRegistrados) calcularPromedio(temperaturas);
                    else System.out.println("Error: Primero debes registrar las temperaturas.");
                    break;
                case 7:
                    if (datosRegistrados) {
                        ordenarArreglo(temperaturas);
                        System.out.println("Temperaturas ordenadas.");
                    }
                    else System.out.println("Error: Primero debes registrar las temperaturas.");
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 8);

        scanner.close();        
    }

    public static double[] registrarTemperaturas(int sizeArreglo) {
        double[] arreglo = new double[sizeArreglo];
        Random random = new Random();

        for (int i = 0; i < sizeArreglo; i++) {
            arreglo[i] = -10 + (50 - (-10)) * random.nextDouble();
            arreglo[i] = Math.round(arreglo[i] * 10) / 10;
        }
        return arreglo;
    }

    public static void mostrarTemperaturas(double[] arreglo) {
        int diaGeneral = 0;
        for (int mes = 1; mes <= 12; mes++) {
            System.out.println("\n--- Mes " + mes + " ---");
            for (int diaMes = 1; diaMes <= 30; diaMes++) {
                System.out.println("Día " + (diaGeneral + 1) + ": " + arreglo[diaGeneral] + "°C");
                diaGeneral++;
                if (diaMes % 5 == 0) System.out.println();
            }
        }
    }

    public static void obtenerMayor(double[] arreglo) {
        double mayor = arreglo[0];
        int dia = 1;
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] > mayor) {
                mayor = arreglo[i];
                dia = i + 1;
            }
        }
        System.out.println("La mayor temperatura registrada es: " + mayor + "°C en el día " + dia);
    }

    public static void obtenerMenor(double[] arreglo) {
        double menor = arreglo[0];
        int dia = 1;
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] < menor) {
                menor = arreglo[i];
                dia = i + 1;
            }
        }
        System.out.println("La menor temperatura registrada es: " + menor + "°C en el día " + dia);
    }

    public static void contarTemperaturas(double[] arreglo) {
        int mayores = 0, menores = 0, iguales = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] > 25) mayores++;
            else if (arreglo[i] < 25) menores++;
            else iguales++;
        }
        System.out.println("Dias > 25°C: " + mayores);
        System.out.println("Dias < 25°C: " + menores);
        System.out.println("Dias = 25°C: " + iguales);
    }

    public static void calcularPromedio(double[] arreglo) {
        double suma = 0;
        for (int i = 0; i < arreglo.length; i++) {
            suma += arreglo[i];
        }
        double promedio = suma / arreglo.length;
        promedio = Math.round(promedio * 100) / 100.0;
        System.out.println("El promedio de las temperaturas registradas es: " + promedio + "°C");
    }

    public static void ordenarArreglo(double[] arreglo) {
        double auxiliar = 0;
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    auxiliar = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = auxiliar;
                }
            }
        }
    }
}
