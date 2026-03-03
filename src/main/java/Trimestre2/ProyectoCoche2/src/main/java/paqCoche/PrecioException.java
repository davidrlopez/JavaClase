/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trimestre2.ProyectoCoche2.src.main.java.paqCoche;

/**
 *
 * @author juanp
 */


public class PrecioException extends Exception
{
    private int precio;
    
    public PrecioException(int p)
    {
        this.precio = p;
    }
    
    @Override
    public String toString()
    {
        return "Error en precio " + this.precio;
    } 
    
}