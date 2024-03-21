package org.iesvdm;
import org.junit.jupiter.api.Test;
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

        assertTrue(ArrayNuevo[ArrayNuevo.length-1]==nombre);
        assertTrue(ArrayNuevo.length==array.length+1);
        assertArrayEquals(array,Arrays.copyOfRange(ArrayNuevo,0,array.length));

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
    void añadealtura()
    {
        double[] array = {1.3,2.5,2.8};
        double alturadefecto = 1.5;

        double[] arrayActual = AlturaAlumno.añadeAltura(array);

        assertTrue(arrayActual[arrayActual.length-1]==alturadefecto);

        assertTrue(arrayActual.length == array.length+1);
        assertEquals(alturadefecto, arrayActual[arrayActual.length-1]);

        double[] actual = Arrays.copyOfRange(arrayActual,0,array.length);
        assertArrayEquals(array,actual);
    }

    @Test
    void buscaNombre()
    {
        int indice = -1;
        String[] nombres = {"David, Jose, Cesar"};
        String nombre = "Jose";

        int resultado = AlturaAlumno.buscaNombre(nombres, nombre);
        assertTrue(indice==resultado);
    }

    @Test
    void mostrar(){
        String[] arrayNombre = new String[1];
        arrayNombre[0]="David";
        Double[] arrayAltura = new Double[1];
        arrayAltura[0]=1.80;
    }

    @Test
    void calculaMaximo(){
        double [] array = {1.37, 1.60, 1.45};
        assertTrue(AlturaAlumno.calculaMaximo(array)[0]==1);
        assertTrue(AlturaAlumno.calculaMaximo(array)[1]==1.60);
    }

    @Test
    void calculaMedia(){
        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0};
        assertTrue(AlturaAlumno.calculaMedia(array)==3.0);
    }
}


