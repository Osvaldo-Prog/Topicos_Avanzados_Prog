package verificadoredad;

import org.junit.jupiter.api.Test;

public class VerificadorEdadTest {
    @Test
    public void testEsMayorDeEdad() {
        assertTrue(VerificadorEdad.esMayorDeEdad(25), "Aguas");
    }

    @Test
    public void testPruebaMenorEdad(){
        assertFalse("8 no es mayor de edad", VerificadorEdad.esMayorDeEdad(8));
    }

    @Test
    public void testPruebaLimite(){
        assertTrue("18 es myor de edad apenas", VerificadorEdad.esMayorDeEdad(18));
    }
}
