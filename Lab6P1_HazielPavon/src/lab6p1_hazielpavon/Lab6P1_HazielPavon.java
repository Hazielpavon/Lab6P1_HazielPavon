package lab6p1_hazielpavon;

import java.util.Scanner;
import java.util.Random;

public class Lab6P1_HazielPavon {

    static Scanner leer = new Scanner(System.in);
    static Random ran = new Random();

    public static void main(String[] args) {

        boolean seguir = true;

        while (seguir) {

            System.out.println("Menu");
            System.out.println("Ejercicio 1, cuantos primos tienes");
            System.out.println("Ejercicio 2, frecuencia de letras");
            System.out.println("3. Salir");
            System.out.println("Ingrese una opcion");
            int opcion = leer.nextInt();

            switch (opcion) {

                case 1:

                    System.out.println("Ingrese el tamano del arreglo a generar");
                    int size = leer.nextInt();

                    System.out.println("Ingrese el limite inferior");
                    int inferior = leer.nextInt();

                    System.out.println("Ingrese el limite superior");
                    int superior = leer.nextInt();

                    if (size < 2) {
                        System.out.println("El tamano debe ser mayor a 1");

                    }
                    if (superior < inferior) {

                        System.out.println("El numero inferior debe ser menor al superior");

                    }

                    int[] mando = new int[size];
                    int[] mando2 = new int[size];
                    mando = genRandArray(size, inferior, superior);

                    System.out.print("Arreglo generado");

                    imprimegenRandArray(mando);

                    System.out.println("");

                    System.out.println("\n No.divisores primos");

                    imprimegetTotalPrimeCount(getTotalPrimeCount(mando));
                    System.out.println();
                    break;

                case 2:
                    boolean vali = false;
                    System.out.print("Ingrese una palabra: ");
                    String palabra = leer.next();

                    for (int i = 0; i < palabra.length(); i++) {

                        char letra = palabra.charAt(i);

                        if ((letra > 96) || (letra > 123)) {
                            vali = true;
                        } else {
                            vali = false;
                            break;
                        }
                    }

                    if (vali == false) {

                        System.out.println("La palabra contiene valores incorrectos");
                    } else {
                        System.out.println("Validos");
                    }

                    int[] frecuencias = extraerFrecuencias(palabra);
                    System.out.println("Frecuencias para la palabra: " + palabra);
                    imprimirArreglo(frecuencias);
                    imprimirArreglo(new String[]{ "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "ñ"});

                    break;

                case 3:
                    System.out.println("Usted esta saliendo del programa");
                    seguir = false;

                default:
                    if (opcion > 3 || 0 > opcion) {

                        System.out.println("Ingrese un valor valido");
                    }
                    break;
            }

        }
    }

    public static int[] genRandArray(int size, int inferior, int superior) {

        int[] temporal = new int[size];

        for (int i = 0; i < size; i++) {
            temporal[i] = inferior + ran.nextInt(superior);

        }

        return temporal;
    }

    public static void imprimegenRandArray(int[] arreglo) {

        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]");
        }
    }

    public static boolean isPrime(int valor) {

        int cont = 0;
        for (int i = 1; i <= valor; i++) {
            if (valor % i == 0) {
                cont++;
            }
        }
        boolean primo = false;

        if (cont == 2) {

            primo = true;
        }

        return primo;
    }

    public static int countPrimeFactors(int valor) {

        int cont = 0;

        for (int i = 2; i <= valor; i++) {

            if (isPrime(i) && valor % i == 0) {

                cont++;
            }
        }

        return cont;

    }

    public static int[] getTotalPrimeCount(int[] numprimo) {

        int[] num = new int[numprimo.length];

        for (int i = 0; i < numprimo.length; i++) {

            int count = countPrimeFactors(numprimo[i]);
            num[i] = count;
        }

        return num;
    }

    public static void imprimegetTotalPrimeCount(int[] num) {

        for (int i = 0; i < num.length; i++) {
            System.out.print("[" + num[i] + "]");
        }
    }
    
    
    public static int[] extraerFrecuencias(String palabra) {
        int[] frecuencias = new int[27];

        for (int i =0 ; i < palabra.length(); i++) {
            char letra = palabra.charAt(i); 
            
            if (Character.isLetter(letra)) {
                
//google me ayudo con este isletter... ya no estabas para preguntarte si se puede usar  

                int indice = Character.toLowerCase(letra) - 'a';

                if (Character.toLowerCase(letra) == 'ñ') {
                    indice = 26;
                } 

                frecuencias[indice]++;
            }
        }

        return frecuencias;
    }

    public static void imprimirArreglo(int[] arreglo) {

        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(" [ " + arreglo[i] + " ] ");
           
        }
        System.out.println("");
 
    }

    public static void imprimirArreglo(String[] arreglo) {
      
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(" [ " + arreglo[i] + " ] ");
        }  
        

    }
}








