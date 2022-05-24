package subprogramas;

/**
 * Aritmetica
 */
public class Aritmetica {
    int va, vb;

    Aritmetica(){        
    }

    Aritmetica(int va, int vb){
        this.va=va;
        this.vb=vb;
    }

    public int sumar(int a, int b) {
        return a+b;
    }

    public int multiplicar(){
        return (va*vb);
    }
    
}