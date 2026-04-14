package ActividadJUnitMaven;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import static org.testng.Assert.*;

public class PersonaTest {

    @Test
    public void testEquivalenciaMenor18() {
        Persona p = new Persona(10);
        assertFalse(p.isMayorDeEdad(), "Edad 10 debería devolver false");
    }

    @Test
    public void testEquivalenciaEntre18y120() {
        Persona p = new Persona(50);
        assertTrue(p.isMayorDeEdad(), "Edad 50 debería devolver true");
    }

    @Test
    public void testEquivalenciaMayor120() {
        Persona p = new Persona(130);
        assertFalse(p.isMayorDeEdad(), "Edad 130 debería devolver false");
    }

    @Test
    public void testLimiteInferiorMenosUno() {
        Persona p = new Persona(17);
        assertFalse(p.isMayorDeEdad(), "Edad 17 debería devolver false");
    }

    @Test
    public void testLimiteInferiorExacto() {
        Persona p = new Persona(18);
        assertTrue(p.isMayorDeEdad(), "Edad 18 debería devolver true");
    }

    @Test
    public void testLimiteInferiorMasUno() {
        Persona p = new Persona(19);
        assertTrue(p.isMayorDeEdad(), "Edad 19 debería devolver true");
    }

    @Test
    public void testLimiteSuperiorMenosUno() {
        Persona p = new Persona(119);
        assertTrue(p.isMayorDeEdad(), "Edad 119 debería devolver true");
    }

    @Test
    public void testLimiteSuperiorExacto() {
        Persona p = new Persona(120);
        assertTrue(p.isMayorDeEdad(), "Edad 120 debería devolver true");
    }

    @Test
    public void testLimiteSuperiorMasUno() {
        Persona p = new Persona(121);
        assertFalse(p.isMayorDeEdad(), "Edad 121 debería devolver false");
    }

    @DataProvider(name = "edadesProvider")
    public Object[][] obtenerEdades() {
        return new Object[][] {
            { 10, false }, { 50, true }, { 130, false },
            { 17, false }, { 18, true }, { 19, true },
            { 119, true }, { 120, true }, { 121, false }
        };
    }

    @Test(dataProvider = "edadesProvider")
    public void testIsMayorDeEdadParametrizado(int edadPrueba, boolean resultadoEsperado) {
        Persona p = new Persona(edadPrueba);
        assertEquals(p.isMayorDeEdad(), resultadoEsperado, "Fallo al evaluar la edad: " + edadPrueba);
    }
}