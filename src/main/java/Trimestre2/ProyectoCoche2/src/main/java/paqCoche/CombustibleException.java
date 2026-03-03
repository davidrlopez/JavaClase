/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trimestre2.ProyectoCoche2.src.main.java.paqCoche;

/**
 *
 * @author juanp
 */
public class CombustibleException extends Exception
{
    private String combustible;
    
    public CombustibleException(String combus)
    {
        this.combustible = combus;
    }
    
    @Override
    public String toString()
    {
        return "Error en Combustible " + this.combustible;
    } 
    
}
