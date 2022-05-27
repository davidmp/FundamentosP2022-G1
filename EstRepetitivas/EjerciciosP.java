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
    /*
    Factorizar un número ingresado por teclado. Po ejemplo:
    #Solución:

    Definición de variables:
    * n: número cuyos factores se desean obtener, 
    * i: posibles factores

    No debemos confundir el término factorizar que significa encontrar todos los factores primos de un número y el término factorial que significa el producto de todos los números consecutivos desde la unidad hasta el mismo número

    Para encontrar todos los factores de un número necesitamos generar los posibles valores que puedan dividir a dicho número. Esto se logra con la variable $i$ que inicializamos en 2, no se considera el 1 porque es un factor de todos los números. El bucle se ejecuta mientras estos posibles factores $i$ sean menores que el numero $n$. Si $i$ divide exactamente a  n entonces  le  sacamos  el  factor  $i$ mediante  la  división  entera  $n  =  n / i$,  y lo imprimimos.  En este caso $i$ no aumenta en una unidad, pues deberá volver a probar si $i$ es nuevamente un factor de $n$. El incremento de $i$ ocurre solamente cuando $i$ no dividió a $n$ ejecutándose la parte correspondiente al else.
    */
    public static void factorizar() {
        int n, i;        
        System.out.println("Ingres número: "); n=leerT.nextInt();        
        i = 2;
        while (i<=n) {
            if(n%i==0) {n = n/i; System.out.println(i); }else{i++;}             
        }
    }
    /*
    #Ejercicio 5
    Escriba un algoritmo que diga si un número es primo.   
    ##Solución:
    Definición de variables: 

    * n: número a evaluar 
    * i: posible divisor
    * band: 0 indica que no es primo

    Un número es primo, cuando solamente es divisible por la unidad y por sí mismo. 
    Entonces, necesitamos encontrar un número $i$ mayor que 1 pero menor a $n$, que divida exactamente a $n$, para afirmar que $n$ no es primo. Si esta búsqueda no es satisfactoria el número será primo.

    Suponemos pues, que todo número es primo, hasta que se demuestre lo contrario; así que usaremos un indicador bandera (flag) representado por la variable band.  Si band = 1 el número es primo y no lo es cuando band=0.

    Comenzamos inicializando los posibles divisores $i$, igual a $n/2$, pues no existen divisores que sean mayores que la mitad del número, para ir preguntando si $i$ divide a $n$, en este caso debemos cambiar band a cero, indicando que el número $n$ ha sido dividido por otro número $i$ diferente de 1 y de él mismo, y por lo tanto $n$ ya no será primo. Al terminar el bucle, preguntamos por band si fuera igual a 1, el número $n$ será primo y no primo en caso contrario.    
    */
    public static void siNumeroPrimo() {
        int n,i,band;
        System.out.println("Ingrese número: ");n=leerT.nextInt();
        i=n/2;
        band=1;
        while (i>1) {
            if (n%i == 0) {
                band=0;
            }
            i++;
        }

        if (band==1) {
            System.out.println("Es primo");
        }else{System.out.println("No es primo");}
    }
    /*
    Escriba un programa que permita reducir una fracción a su mínima expresión, por ejemplo: 28/64 = 7/16
    #Solución:
    Definición     de     variables: 
    * a:   numerador 
    * b: denominador
    * i: posible divisor de a y b

    Basta con probar si $i$ divide al numerador y al denominador al mismo tiempo, para cada $i$ desde 2 y mientras sea menor a ambos números.  Si $i$ es un divisor de $a$ y $b$, entonces simplificar la fracción en caso contrario probar con el siguiente $i$.
    */
    public static void reducirFraccion() {
        int a, b, i;
        System.out.println("Ingrese numerador: "); a=leerT.nextInt();
        System.out.println("Ingrese denominador: "); b=leerT.nextInt();
        i = 2;
        while (i<=a && i<=b) {
            if (a%i==0 && b%i==0) {
                a = a/i;
                b = b/i;
            }else{i=i+1;}
        }
    }
    /*
    Lea un número y forme otro número con las cifras en orden inverso. Así si el número es 12345 el nuevo número será 54321.
    ## Solución:
    Definición de variables:
    * n: numero cuyos dígitos se invertirán 
    * inv: número invertido

    Para    obtener    un    nuevo    número    $inv$, formado por los dígitos de $n$, pero en orden invertido, debemos obtener cada uno de los dígitos de $n$, e ir desplazándolos un valor posicional (unidad, decena, centena, etc.).  Cada uno de los dígitos, pueden ser obtenidos al buscar el resto de la división entera entre 10 (n MOD 10) y se debe ir incrementando el valor posicional mediante la multiplicación del resto por 10, y su acumulación en la variable $inv$.  Se puede usar la división entera (que de manera estándar se representa mediante el operador DIV, y que en python, se implementa con el operador /, y cuando queremos obtener el valor entero de la división se usa //. El ciclo se ejecuta mientras el número aún tenga dígitos que obtener (mientras $n$ sea mayor que cero), luego del cual imprimimos 
    $inv$.
    */
    public static void numeroInverso() {
        int n,inv;
        System.out.println("Ingrese número: "); n=leerT.nextInt();
        inv = 0;
        while (n>0) {
            inv = 10*inv + n%10;
            n = (int)n/10;
        }
        System.out.println("El inverso es: "+inv); 
    }

    /*
    Ejericio 8.
    Un número se considera perfecto cuando la suma de sus divisores es igual al número. Por ejemplo 6 tiene como divisores a 1, 2 y 3 y como 1+2+3 = 6, el número 6 será perfecto; 28 tiene como divisores a 1, 2, 5, 7 y 14, luego 28 es perfecto pues 1+2+4+7+14 = 28, lo mismo ocurre con 496 y 8128, escriba un programa que lea un número y diga si es perfecto.
    ##Solución:
    Definición de variables:
    * n: numero a evaluar 
    * s: suma de los divisores 
    * i: posibles divisores

    Basta con obtener sus divisores y sumarlos. Utilizaremos la siguiente estrategia, comenzando desde la mitad del número $n$ iremos probando los posibles divisores $i$, disminuyendo $i$ de uno en uno, mientras $i$ sea mayor que cero.

    En caso de que $n$ sea dividido exactamente por $i$ acumular $i$ en $s$, y probar siguiente $i$.  Al final del bucle preguntamos si la suma $s$, resultó ser igual al número digitado $n$, en cuyo caso imprimiremos que $n$ es perfecto.    
    */
    public static void numeroPerfecto() {
        int n, i, s;
        System.out.println("Ingrese número: ");
        n=leerT.nextInt();
        s = 0;
        i = n/2;
        while(i>0){
            if(n%i==0){
                s = s+i;
            }
            i--;
        }
        if (s==n) {
            System.out.println(n+" es perfecto");
        }else{System.out.println(n+" no es perfecto");}
    }
    /* 
    Los números Amstrong o cubos perfectos son aquellos sque sumados los cubos de sus dígitos nos dan el mismo número. por ejemplo 153 es un cubo perfecto pues:  13+53+33=153 . Lea un número y diga si es o no un cubo perfecto.
    ## Solución:

    Definición de variables

    * n: número a evaluar
    * sc: suma de los cubos de sus cifras
    * temp: se iguala inicialmente a $n$ y sirve para trabajar en el algoritmo sin perder $n$

    De manera similar al ejercicio anterio pero esta vez obtenemos cada dígito para elevarlo al cubo y acumularlo en $sc$. si $sc$ resulta ser igual a $n$, entonces el número es un cubo perfecto.

    Pruebe el algoritmo con los siguientes cubos perfectos: 1,153,370,371 y 407
    */
    public static void cubosPerfectos() {
        int n, sc, temp;
        System.out.println("Ingrese número: "); n=leerT.nextInt();
        sc = 0;
        temp = n;    
        while(temp>0){
            sc = sc + ((int)(Math.pow(temp%10, 3)));
            temp = temp/10;
        }
        if(n==sc){
            System.out.println("El cubo es perfecto");
        }else{System.out.println("No es cubo perfecto");}
    }


    public static void main(String[] args) {
        System.out.println("Indique el numero de ejercicio:");
        int opt=leerT.nextInt();
        switch (opt) {
            case 1: tabalMultiplicar(); break;
            case 2: obtenerCocienteReciduo(); break;
            case 3: fibonaci(); break;
            case 4: divisoresCumunes(); break;
            case 5: factorizar(); break;
            case 6: siNumeroPrimo(); break;
            case 7: reducirFraccion(); break;
            case 8: numeroInverso(); break;
            case 9: numeroPerfecto();break;
            case 10: cubosPerfectos();break;

            default: System.out.println("opcion no existe"); break;
        }
    }
    
}