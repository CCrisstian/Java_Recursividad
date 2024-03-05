package Org.CCrisstian.Recursividad.Ejemplo;

import Org.CCrisstian.Recursividad.Ejemplo.Models.Componente;

import java.util.stream.Stream;

public class Ejemplo_Recursividad {
    public static void main(String[] args) {

        Componente pc = new Componente("Gabinete PC ATX");
        Componente poder = new Componente("Fuente Poder 700w");
        Componente placaMadre = new Componente("MainBoard Asus sockets AMD");
        Componente cpu = new Componente("Cpu AMD Ryzen 5 2800");
        Componente ventilador = new Componente("Ventilador CPU");
        Componente disipador = new Componente("Disipador");
        Componente tarjetaVideo = new Componente("Nvidia RTX 3080 8GB");
        Componente gpu = new Componente("Nvidia GPU RTX");
        Componente gpuRam = new Componente("4GB Ram");
        Componente gpuRam2 = new Componente("4GB Ram");
        Componente gpuVentiladores = new Componente("Ventiladores");
        Componente ram = new Componente("Memoria Ram 32GB");
        Componente ssd = new Componente("Disco SSD 2T");

        cpu.addComponente(ventilador)
                .addComponente(disipador);
        tarjetaVideo.addComponente(gpu)
                .addComponente(gpuRam)
                .addComponente(gpuRam2)
                .addComponente(gpuVentiladores);
        placaMadre.addComponente(cpu)
                .addComponente(tarjetaVideo)
                .addComponente(ram)
                .addComponente(ssd);
        pc.addComponente(poder)
                .addComponente(placaMadre)
                .addComponente(new Componente("Teclado"))
                .addComponente(new Componente("Mouse"));

        System.out.println("-------------------Método recursivo propio-------------------");
        metodoRecursivo(pc, 0);

        System.out.println("\n-------------------Método recursivo usando Java 8-------------------");
        metodoRecursivo_Java_8(pc, 0).forEach(
                comp -> System.out.println("Nivel: " + comp.getNivel() +"\t- ".repeat(comp.getNivel()) + comp.getNombre())
        );
    }

    public static Stream<Componente> metodoRecursivo_Java_8(Componente componente, int nivel){
        componente.setNivel(nivel);

        return Stream.concat(Stream.of(componente), componente.getHijos().stream()
                .flatMap(hijo -> metodoRecursivo_Java_8(hijo, nivel+1)));
    }

    public static void metodoRecursivo (Componente componente, int nivel){
        System.out.println("Nivel: " + nivel +"\t- ".repeat(nivel) + componente.getNombre());
        if (componente.tieneHijos()){
            for (Componente hijo : componente.getHijos()){
                metodoRecursivo(hijo, nivel+1); /*(nivel+1) suma 1 al valor actual de 'nivel' pero no cambia el valor de 'nivel' en sí.*/
            }
        }
    }
}
