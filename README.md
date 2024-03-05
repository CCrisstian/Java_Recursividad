<h1 align="center">Recursividad</h1>
<p>La <b>recursividad</b> es un concepto en programación en el que una función se llama a sí misma para resolver un problema. En el caso de Java, la recursividad se implementa mediante la invocación de una función dentro de sí misma. Es importante tener en cuenta que la recursividad debe tener un caso base para evitar la ejecución infinita y causar un desbordamiento de la pila (stack overflow).</p>
<p>Eejemplo simple para entender mejor la recursividad en Java. Supongamos que queremos calcular el factorial de un número utilizando una función recursiva.</p>

```java
public class RecursividadEjemplo {

    public static void main(String[] args) {
        int numero = 5;
        int resultado = calcularFactorial(numero);
        System.out.println("El factorial de " + numero + " es: " + resultado);
    }

    public static int calcularFactorial(int n) {
        // Caso base: el factorial de 0 es 1
        if (n == 0) {
            return 1;
        } else {
            // Llamada recursiva: n! = n * (n-1)!
            return n * calcularFactorial(n - 1);
        }
    }
}

```
En este ejemplo, la función `calcularFactorial` se llama a sí misma para calcular el factorial de un número dado. El caso base es cuando `n` es igual a 0, en ese caso, la función devuelve 1. Si n es diferente de 0, la función realiza una llamada recursiva multiplicando n por el factorial de `(n-1)`.
