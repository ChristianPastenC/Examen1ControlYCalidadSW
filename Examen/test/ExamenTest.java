/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author ChristianPasten
 */
public class ExamenTest {
    //Se insertan menos de 5 datos
    @Test
    public void limitInf()
    {
        String cad = "Queen,10,Metallica,9,Nirvana,8,";
        String[] partes = cad.split(",");
        assertEquals(false,ExamenJFrame.validaInput(partes));
    }
    
    //Se imnsertan mas de 10 entradas
    @Test
    public void limitSup()
    {
        String cad = "G1,10,G2,9,G3,8,G4,7,G5,6,G6,5,G7,4,G8,3,G9,2,G10,1,G11,1";
        String[] partes = cad.split(",");
        assertEquals(false,ExamenJFrame.validaInput(partes));
    }
    
    //Enteros entre 1 y 10
    @Test
    public void rangoTop()
    {
        int x = 100;
        assertEquals(false,ExamenJFrame.validarRank(x));
    }
    
    //No se permiten numeros repetidos
    @Test
    public void repetido()
    {
        List<Integer> rank = new ArrayList<Integer>();
        rank.add(9);
        rank.add(9);
        rank.add(9);
        assertEquals(false,ExamenJFrame.validarOrden(rank));
    }
    
    //Orden incorrecto de los numeros
    @Test
    public void notOrdered()
    {
        List<Integer> rank = new ArrayList<Integer>();
        rank.add(8);
        rank.add(10);
        rank.add(9);
        assertEquals(false,ExamenJFrame.validarOrden(rank));
    }
    
    //Nombres solamente alfanumericos
    @Test
    public void alphaNumeric(){
        String cad = "@+9*@";
        assertEquals(false,ExamenJFrame.validarNombre(cad));
    }
    
    //Limite de nombre en 50 caracteres
    @Test
    public void limitName()
    {
        String cad = "";
        for(int i  = 0; i < 51; i++)
        {
            cad += "a";
        }
        assertEquals(false,ExamenJFrame.validarNombre(cad));
    }
    
    //Se ignoran espacios en blanco al inicio
    @Test
    public void initSpace()
    {
        String cad = "           G1,10,G2,9,G3,8,G4,7,G5,6,G6";
        cad = cad.replace(" ","");
        assertEquals(cad,"G1,10,G2,9,G3,8,G4,7,G5,6,G6");
    }
    
    //No se permite una entrada vacia
    @Test
    public void notNull()
    {
        String cad = " , ,,,,, , , ,";
        String[] partes = cad.split(",");
        assertEquals(false,ExamenJFrame.validaInput(partes));
    }
    
    //Formato no separado por comas
    @Test(expected = RuntimeException.class)
    public void notComa()
    {
        String cad = "a.10.b.9.c.8.d.7.f.6";
        if(cad.contains(","))
           return;
        else
            throw new RuntimeException();
    }
    
    //Formato string number
    @Test
    public void correctFormat()
    {
        String cad = "grupo1, 10";
        cad = cad.replace(" ", "");
        String[] array;
        array = cad.split(",");
        int proof = Integer.parseInt(array[1]);
        assertEquals(10,proof);
    }
    
    //Sin formato String Number
    @Test(expected = RuntimeException.class)
    public void incorrectFormat()
    {
        String cad = "10, grupo1";
        String[] array;
        array = cad.split(",");
        int proof = Integer.parseInt(array[1]);
    }
    
    //Se insertan exactamente 5 entradas
    @Test
    public void limiteInferior()
    {
        String cad = "g1,10,g2,9,g3,8,g4,7,g5,6";
        String[] partes = cad.split(",");
        assertEquals(true,ExamenJFrame.validaInput(partes));
    }
    
    //Se exactas insertan 10 entradas
    @Test
    public void limiteSuperior()
    {
        String cad = "G1,10,G2,9,G3,8,G4,7,G5,6,G6,5,G7,4,G8,3,G9,2,G10,1";
        String[] partes = cad.split(",");
        assertEquals(true,ExamenJFrame.validaInput(partes));
    }
    
    //Orden decreciente correcto
    @Test
    public void Ordered()
    {
        List<Integer> rank = new ArrayList<Integer>();
        rank.add(10);
        rank.add(9);
        rank.add(8);
        assertEquals(true,ExamenJFrame.validarOrden(rank));
    }
    
    //Caracteres en lugar de numeros
    @Test(expected = RuntimeException.class)
    public void isCharater()
    {
        String a = "A";
        int aux = Integer.parseInt(a);
    }
    
    //Flotantes en lugar de numeros
    @Test(expected = RuntimeException.class)
    public void isFloating()
    {
        String a = "5.892";
        int aux = Integer.parseInt(a);
    }
    
     //Se ignoran espacios en blanco al final
    @Test
    public void endSpace()
    {
        String cad = "G1,10,G2,9,G3,8,G4,7,G5,6               ";
        cad = cad.replace(" ","");
        assertEquals(cad,"G1,10,G2,9,G3,8,G4,7,G5,6");
    }
    
     //Se ignoran espacios en blanco al centro
    @Test
    public void blankSpace()
    {
        String cad = "G1       ,        10  ,  G2    ,     9,G3,    8,G4,7,G5,     6      ";
        cad = cad.replace(" ","");
        assertEquals(cad,"G1,10,G2,9,G3,8,G4,7,G5,6");
    }
    
    //Se ignoran entradas nulas
    @Test
    public void nullInput()
    {
        String cad = "";
        String[] partes = cad.split(",");
        assertEquals(false,ExamenJFrame.validaInput(partes));
    }
}
