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
<p>Es crucial tener un caso base en la recursividad para evitar la ejecución indefinida. En el ejemplo, el caso base es cuando n es igual a 0. Cada llamada recursiva reduce el problema a una instancia más pequeña hasta llegar al caso base.</p>

<h2 align="center">API Streams</h2>
<p>En Java, se puede utilizar la API de <b>Streams</b> junto con la recursividad para realizar operaciones en colecciones de manera recursiva. Sin embargo, se debe tener en cuenta que el enfoque con <b>Streams</b> puede no ser tan directo, ya que los <b>Streams</b> están diseñados principalmente para operaciones de datos en paralelo o en secuencia, y la recursividad puede ser más evidente utilizando métodos tradicionales.</p>

Ejemplo utilizando `Streams` en Java para calcular el factorial de un número de manera recursiva:
```java
import java.util.stream.LongStream;

public class RecursividadConStream {

    public static void main(String[] args) {
        int numero = 5;
        long resultado = calcularFactorial(numero);
        System.out.println("El factorial de " + numero + " es: " + resultado);
    }

    public static long calcularFactorial(int n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (a, b) -> a * b);
    }
}
```
En este ejemplo, `LongStream.rangeClosed(1, n)` genera un stream de números desde 1 hasta n, inclusive. Luego, la operación `.reduce`(1, (a, b) -> a * b) multiplica todos los elementos del stream, comenzando desde 1, que es el valor inicial proporcionado.
<p> En general, el uso de <b>Streams</b> no es la forma más común de implementar recursividad en Java, pero puede ser útil en ciertos contextos, especialmente cuando se trabaja con operaciones de datos en colecciones.</p>
<p>En muchos casos, la recursividad tradicional con métodos convencionales puede ser más clara y fácil de entender. La elección entre <b>Streams</b> y recursión depende del problema específico en el que se esté resolviendo y de las preferencias de estilo de programación.</p>
