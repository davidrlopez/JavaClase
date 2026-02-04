/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paqCoche;

/**
 *
 * @author juanp
 */

public class PuertasException extends Exception
{
    private int num_puertas;
    
    public PuertasException(int np)
    {
        this.num_puertas = np;
    }
    
    @Override
    public String toString()
    {
        return "Error en Num_puertas " + this.num_puertas;
    } 
    
}