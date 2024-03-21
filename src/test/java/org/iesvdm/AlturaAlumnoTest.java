package org.iesvdm;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
public class AlturaAlumnoTest {

    @Test
    void añadenombre()
    {
        String[] array = new String [0];
        String nombre = "";

        String[] ArrayNuevo = AlturaAlumno.añadeNombre(array,nombre);

        assertSame(ArrayNuevo[ArrayNuevo.length - 1], nombre);
        assertEquals(ArrayNuevo.length, array.length + 1);
        assertArrayEquals(array,Arrays.copyOfRange(ArrayNuevo,0,array.length));

    }

    @Test
    void añadealtura()
    {
        double[] array = {1.3,2.5,2.8};
        double alturadefecto = 1.5;

        double[] arrayActual = AlturaAlumno.añadeAltura(array);

        assertEquals(arrayActual[arrayActual.length - 1], alturadefecto);

        assertEquals(arrayActual.length, array.length + 1);
        assertEquals(alturadefecto, arrayActual[arrayActual.length-1]);

        double[] actual = Arrays.copyOfRange(arrayActual,0,array.length);
        assertArrayEquals(array,actual);
    }
    
    @Test
    void modificaAltura()
    {
        double[] array = {1.3,1.4,2.4};
        int posicion = 1;
        double altura = 2;
        
        AlturaAlumno.modificaAltura(array,posicion,altura);
        assertEquals(altura,array[posicion]);
    }

    @Test
    void buscaNombre()
    {
        int indice = -1;
        String[] nombres = {"David, Jose, Cesar"};
        String nombre = "Jose";

        int resultado = AlturaAlumno.buscaNombre(nombres, nombre);
        assertEquals(indice, resultado);
    }

    @Test
    void mostrar()
    {
        String[] nombres = {"Juan", "María", "Pedro"};
        double[] alturas = {1.75, 1.60, 1.85};

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        AlturaAlumno.mostrar(nombres, alturas);

        String salida = "Juan\t|   1.75\nMaría\t|   1.6\nPedro\t|   1.85\n";
        assertEquals(salida, outContent.toString());
    }

    @Test
    void calculaMaximo(){
        double[] alturas = {1.75, 1.60, 1.85};

        double[] resultadoMaximo = AlturaAlumno.calculaMaximo(alturas);

        double[] ResultadoMaximoEsperado = {2, 1.85};

        assertArrayEquals(ResultadoMaximoEsperado, resultadoMaximo);
    }

    @Test
    void calculaMedia(){
        double[] alturas = {1.75, 1.60, 1.85};

        double media = AlturaAlumno.calculaMedia(alturas);

        double MediaEsperada = (1.75 + 1.60 + 1.85) / alturas.length;

        assertEquals(MediaEsperada, media);
    }
}

