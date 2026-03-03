/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trimestre2.ProyectoCoche2.src.main.java.paqCoche;

/**
 *
 * @author juanp
 */


public class CambioException extends Exception
{
    private String cambio;
    
    public CambioException(String camb)
    {
        this.cambio = camb;
    }
    
    @Override
    public String toString()
    {
        return "Error en Cambio " + this.cambio;
    } 
    
}