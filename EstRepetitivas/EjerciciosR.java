package EstRepetitivas;

/**
 * EjerciciosR
 */
public class EjerciciosR {

    public static void imprimirWhileN1_20() {
        int numInit=21;
        while (numInit<=20) {
            System.out.println(numInit);
            numInit=numInit+1;
        }
    }
    public static void imprimirDowhileN1_20() {
        int numInit=21;
        do {
            System.out.println(numInit);
            numInit++;
        } while (numInit<=20);
    }

    public static void imprimirForN1_20() {
         for (int numInit = 1; numInit <= 20; numInit++) {
             System.out.println(numInit);
         }
    }

    public static void main(String[] args) {
       System.out.println("Imprime While:");  imprimirWhileN1_20();
       System.out.println("Imprime Do while:"); imprimirDowhileN1_20();
       System.out.println("Imprime for:"); imprimirForN1_20();
    }
}