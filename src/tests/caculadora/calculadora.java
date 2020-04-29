package src.tests.caculadora;


import org.junit.Test;

public class calculadora {


    @Test
    public void calculadora() {

        int numero1 = 20;
        int numero2 = 10;
        int numero3 = 15;

        int resultado = sumar(numero1, numero2);
        int resultado1 = restar(numero1, numero2);
        int resultado2 = dividir(numero1, numero2);
        int resultado3 = multiplicar(numero1, numero2);
        int resultado4 = sumar(numero1, numero2, numero3);

        System.out.println("RESULTADO DE LA SUMA DE DOS NUMEROS: " + resultado);
        System.out.println("RESULTADO DE LA RESTA DE DOS NUMEROS: " + resultado1);
        System.out.println("RESULTADO DE LA DIVISION DE DOS NUMEROS: " + resultado2);
        System.out.println("RESULTADO DE LA MULTIPLICACION DE DOS NUMEROS: " + resultado3);
        System.out.println("RESULTADO DE LA SUMA DE TRES NUMEROS: " + resultado4);

    }

    public int sumar(int numero1, int numero2){

        int resultado = numero1 + numero2;
        return resultado;
    }

    public int restar(int numero1, int numero2) {

        int resultado = numero1 - numero2;
        return resultado;

    }

    public int dividir(int numero1, int numero2) {

        int resultado = numero1 / numero2;
        return resultado;

    }

    public int multiplicar(int numero1, int numero2) {

        int resultado = numero1 * numero2;
        return resultado;

    }

    public int sumar(int numero1, int numero2, int numero3){

        int resultado = numero1 + numero2 + numero3;
        return resultado;
    }

}
