package EstRepetitivas;

import java.util.Scanner;

public class EjerciciosP {

    static Scanner leerT=new Scanner(System.in);

    /**
     Práctica 1: escribir un programa que genere la tabla de multiplicar desde el 1 hasta el 10
    */
    public static void tabalMultiplicar() {
        int a=1,  b=1;
        while (a<=10 && b<=10) {
            int r=b*a;
            System.out.println(b+"*"+a+"="+r);
            a++;
            if (a==11) {
                b++;
                a=1;
                System.out.println("");
            }
        }
    }

    /*
        EJERCICIO NRO 1.
        Obtenga el cociente y el residuo de una división calculado la cantidad de veces que un número esta contenido en otro, midiante restas sucesivas:

        Por Ejemplo:
        Si el dividendo es a=5236 y el divisor b=1247, entonces tendremos:

        5236 - 1247 = 3989
        3989 - 1247 = 2742
        2742 - 1247 = 1495
        1495 - 1247 = 248 

        Ya no seguimos restando pues 248 es menor que 1247. El cociente será dado por el número (4) y el residuo por el último número obtenido (248)
    */
    public static void obtenerCocienteReciduo() {
        int a, b, coc;
        System.out.println("Dividendo"); a=leerT.nextInt();
        System.out.println("Divisor"); b=leerT.nextInt();

        coc=0;
        while (a>b) {
            a=a-b;
            System.out.println(a+"-"+b+"="+(a-b));
            coc=coc+1;
        }
        System.out.println("El cociente es:"+coc);
        System.out.println("El el Residuo es:"+a);
    }
    /*
    La secuencia de Fibonacci, es muy conocida en los ciruclos matemáticos y tiene la particuaridad de que cada número es igual a la suma de los dos anteriores. La serie de Fibonacci comienza con los números 0 y 1, produciendo una secuencia: 0,1,1,2,3,5,8,13 ... Escribir un programa que ingrese un número, y se genere la serie.
    ## Solución:

    Definición de variables.
    * m: nmáximo número fibonacci a generar
    * a: enésimo número fibonacci
    *b: enésimo  + 1 número fibonacci

    El agoritmo va calcunado cada término de la secuencia como la suma del término enésimo y el término enésimo + 1. Observece la necesidad
    de una terceravariable que llamaremos c, servirá para no perder el valor de a suma cuando cambiamos a y b.    
    */
    public static void fibonaci() {
        int a, b, t, m;
        System.out.println("Ingrese el límite: ");
        m=leerT.nextInt();
        a=0; b=1;
        System.out.println(a+",");
        while (b<m) {
            System.out.println(b+",");
           t=a+b;
            a=b;
            b=t;
        } 
    }
    /*
    Calcule los divisores comunes de dos números. Por ejemplo los divisores comunes de 6 y 18 son: 1, 2, 3 y 6
    ## Solución:
    Definición de variables: 
    * a: primer número 
    * b: segundo número 
    * i: posibles divisores

    El algoritmo va generando los posibles divisores (i), desde la unidad y mientras este sea menor que ambos números. 
    Observe el uso del operador de relación AND (en C++ es && en python: and), pues es necesario considerar el caso de que uno sea múltiplo del otro (por ejemplo 4 y 8).

    El operador MOD (en python %) obtiene el resto de la división entera entre sus argumentos y por lo tanto si estas divisiones tienen como resto cero, i divide a los números.
    */
    public static void divisoresCumunes() {
        int i, a, b;
        System.out.println("Divisores comunes de dós números");
        System.out.println("Ingrese primer  número: "); a=leerT.nextInt();
        System.out.println("Ingrese segundo número: "); b=leerT.nextInt();
        i = 1;
        while (i<=a && i<=b) {
            if (a%i==0 && b%i==0) {
                System.out.println(i);
            }
            i++;
        }
    }


    public static void main(String[] args) {
        System.out.println("Indique el numero de ejercicio:");
        int opt=leerT.nextInt();
        switch (opt) {
            case 1: tabalMultiplicar(); break;
            case 2: obtenerCocienteReciduo(); break;
            case 3: fibonaci(); break;
            case 4: divisoresCumunes(); break;
            case 5: ; break;
            case 6:  break;
            default: System.out.println("opcion no existe"); break;
        }
    }
    
}