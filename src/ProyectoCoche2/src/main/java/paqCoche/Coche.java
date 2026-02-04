/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paqCoche;

/**
 *
 * @author juanp
 */
public class Coche 
{
    
    private String marca;
    private String modelo;
    private String color;
    private String combustible;
    private String cambio;
    private int num_puertas;
    private int precio;
    
   
    public Coche()
    {
        //También se puede poner así
       // this("Ferrari","","BLANCO","GASOLINA","MANUAL",3,0);
        
        this.marca = "Ferrari";
        this.modelo = "";
        this.color ="Blanco";
        this.combustible = "GASOLINA";
        this.cambio = "MANUAL";
        this.num_puertas = 3;
        this.precio = 0;  
        
    }
    
    
    public Coche(String ma,String mo,String co,String com,String ca,int np, int pr)
    {        
        this.setDatos(ma, mo, co, com, ca, np, pr);
    }
    
    public Coche(Coche co)
    {
        //Aquí no hace falta usar excepciones porque se supone que el objeto del que lee los datos
        //ya ha realizado las comprobaciones oportunas
        
        
        //Se podría simplificar con sólo esta instrucción
        //this(co.marca,co.marca,co.color,co.combustible,co.cambio,co.num_puertas,co.precio);
        
         //Se podría simplificar con sólo esta instrucción
        //this.setDatos(co.marca,co.marca,co.color,co.combustible,co.cambio,co.num_puertas,co.precio);
      
       
        this.marca  = co.marca;
        this.modelo = co.modelo;
        this.color  = co.color;
        this.combustible = co.combustible;
        this.cambio = co.cambio;
        this.num_puertas = co.num_puertas;
        this.precio = co.precio; 
                
    }
    
     static private String quitarEspaciosMayusculas(String palabra)
    { 
        palabra = palabra.replaceAll(" ","");

        palabra = palabra.toUpperCase();
        
        return palabra;
    }
    
    @Override
    public String toString()
    {
        return ("Marca: " + this.marca + "Modelo: " + this.modelo + "Color: " + this.color + "Combustible: " + this.combustible + "Cambio: " + this.cambio + "Num puertas: " + this.num_puertas + "Precio: " + this.precio);        
    }
    
   protected String getMarca()
    {
        return this.marca;        
    }
    
    protected String getModelo()
    {
        return this.modelo;        
    }
    
    protected String getColor()
    {
        return this.color;        
    }
    
    protected String getCombustible()
    {
        return this.combustible;        
    }
        
    protected String getCambio()
    {
        return this.cambio;        
    }

    protected int getNumpuertas()
    {
        return this.num_puertas;        
    }
        
    protected int getPrecio()
    {
        return this.num_puertas;        
    }
 
  protected void setMarca(String ma)
    {
        this.marca = quitarEspaciosMayusculas(ma);
    }
    
    protected void setModelo(String mo)
    {
        this.modelo = quitarEspaciosMayusculas(mo);
    }
    protected void setColor(String co)
    {
        this.color = quitarEspaciosMayusculas(co);
    }
    
    protected void setCombustible(String com)
    {
        try
        {
            
            com = this.quitarEspaciosMayusculas(com);
            
            if ( !com.equals("GASOLINA") &&   !com.equals("DIESEL")) 
                    throw new CombustibleException(com);
            
            this.combustible = com;
        }    
        catch (CombustibleException e) {e.toString(); this.combustible = "GASOLINA"; }
        catch (Exception e) {System.out.println("Error general");} 
    }
    
    protected void setNumPuertas(int np)
    {
       try
      {
          if ((np<3) || (np>5))
              throw new PuertasException(np);
          
        this.num_puertas = np;    
      }
      catch (PuertasException e) { e.toString();this.num_puertas = 3;}
      catch (Exception e) {System.out.println("Error general");} 
       
    }
    protected void setCambio(String cam)
    {
        
        try
        {
            
            cam = this.quitarEspaciosMayusculas(cam);
            
            if ( !cam.equals("MANUAL") && !cam.equals("AUTOMATICO"))
                    throw new CambioException(cam);
            
            this.cambio = cam;
        }    
        catch (CambioException e) {e.toString();this.cambio = "MANUAL" ;}
        catch (Exception e) {System.out.println("Error general");} 
        
    }
    
   
      
    protected void setPrecio(int pr)
    {
      try
      {
          if (pr<0)
              throw new PrecioException(pr);
          
        this.precio = pr;    
      }
      catch (PrecioException e) { e.toString();this.precio = 0;}
      catch (Exception e) {System.out.println("Error general");}
    }
   
         
    
    protected void setDatos(String ma,String mo,String co,String com,String ca,int np, int pr)
    {
        
        this.setMarca(quitarEspaciosMayusculas(ma));
        this.setModelo(quitarEspaciosMayusculas(mo));
        this.setColor(quitarEspaciosMayusculas(co));
        this.setCombustible(quitarEspaciosMayusculas(com));
        this.setCambio(quitarEspaciosMayusculas(ca));
        this.setNumPuertas(np);
        this.setPrecio(pr);                       
    }
         
  
    
    
   protected boolean equals(Coche objcoche)
    {
        if ((this.marca == objcoche.marca) & (this.modelo == objcoche.modelo)
           &  (this.color == objcoche.color) &  (this.combustible == objcoche.combustible)
                & (this.cambio == objcoche.cambio) & (this.num_puertas == objcoche.num_puertas)
                    & (this.precio == objcoche.precio) )
                                    return true;
                                else
                                    return false;
    }
    
    
    protected boolean equals(String ma,String mo,String co,String com,String ca,int np, int pr)
    {
        if ((this.marca.equalsIgnoreCase(ma))  & (this.modelo.equalsIgnoreCase(mo)) & (this.color.equalsIgnoreCase(co))
             & (this.combustible.equalsIgnoreCase(com)) & (this.cambio.equalsIgnoreCase(ca)) 
             & (this.num_puertas == np) & (this.precio == pr)) 
                          return true;
        else
                          return false;
             
             
    }
    
    /*  
   //Con este método comprobaríamos si los objetos son iguales considerando que apuntan a la misma
   //dirección de memoria  
    protected boolean equals(Coche objcoche)
    {
        return this.equals(objcoche);    
    }  
    */
    
    public void ver_datos()
    {
        System.out.println("_________________________________");
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo:   " + this.modelo);
        System.out.println("Color: " + this.color);
        System.out.println("Combustible: " + this.combustible);
        System.out.println("Cambio: " + this.cambio);
        System.out.println("Número de puertas: " + this.num_puertas);
        System.out.println("Precio: " + this.precio);  
    }
        
    
}
