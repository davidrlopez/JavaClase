# Plan de Pruebas Manuales con JDB para la clase `Complejo`

Este documento contiene los casos de prueba significativos para cada método de la clase `Complejo`, diseñados para ser ejecutados manualmente utilizando el depurador de Java (`jdb`). 

**Objetivo del ejercicio:** *"Add tests for all methods, with meaningful test cases for each one, and in such a way that no errors are generated. Document/comment on the decisions made."*

## Instrucciones de Preparación

1. **Compilar con información de depuración:**
   Asegúrate de compilar las clases con el flag `-g` para que `jdb` tenga acceso a los nombres de variables y métodos.
   ```bash
   javac -g proyectocomplejo/*.java
   ```
2. **Iniciar JDB:**
   ```bash
   jdb proyectocomplejo.Ppal
   ```
3. **Pausar la ejecución:**
   Pon un punto de interrupción en el `main` y arranca el programa.
   ```jdb
   stop in proyectocomplejo.Ppal.main
   run
   ```

A partir de aquí, puedes copiar y pegar los siguientes comandos `print` en tu consola `jdb`.

---

## Casos de Prueba y Decisiones de Diseño

### 1. Constructores y Getters
**Decisiones tomadas:** Se verifica que los objetos se instancien correctamente en sus tres variantes (vacío, parametrizado y copia). Se comprueba que los valores por defecto del constructor vacío sean `r=1, i=0`. Se validan los métodos `getR()` y `getI()`.

```jdb
# Prueba del constructor vacío (Debería devolver {1+0i})
print new proyectocomplejo.Complejo()

# Prueba del constructor parametrizado
print new proyectocomplejo.Complejo(4, 2)

# Prueba del constructor de copia
print new proyectocomplejo.Complejo(new proyectocomplejo.Complejo(5, 9))

# Pruebas de los métodos Getters
print new proyectocomplejo.Complejo(4, 2).getR()
print new proyectocomplejo.Complejo(4, 2).getI()
```

### 2. Setters y `setComplejo`
**Decisiones tomadas:** Validamos la mutabilidad del estado interno del objeto. Llamamos a los métodos que modifican los atributos y verificamos que no devuelvan errores.

```jdb
# Pruebas de setters individuales (Devuelven void, se verifica que no haya error)
print new proyectocomplejo.Complejo().setR(10)
print new proyectocomplejo.Complejo().setI(5)

# Pruebas de setComplejo con tipos primitivos
print new proyectocomplejo.Complejo().setComplejo(7, 7)

# Pruebas de setComplejo con un objeto Complejo
print new proyectocomplejo.Complejo().setComplejo(new proyectocomplejo.Complejo(3, 3))
```

### 3. Métodos `toString` y `equals`
**Decisiones tomadas:** Se evalúa el formato de salida de `toString`. Para `equals`, se diseñan casos de prueba significativos evaluando una condición verdadera (valores idénticos) y una falsa (valores distintos), tanto para la firma con primitivos como con objetos.

```jdb
# Prueba de toString
print new proyectocomplejo.Complejo(3, 4).toString()

# Pruebas de equals(int, int)
print new proyectocomplejo.Complejo(3, 4).equals(3, 4)  # Esperado: true
print new proyectocomplejo.Complejo(3, 4).equals(5, 5)  # Esperado: false

# Pruebas de equals(Complejo)
print new proyectocomplejo.Complejo(3, 4).equals(new proyectocomplejo.Complejo(3, 4)) # Esperado: true
```

### 4. Operaciones Aritméticas Básicas (`sumaComplejo`, `complejoResta`, `complejoProducto`)
**Decisiones tomadas:** Se prueban las operaciones matemáticas utilizando valores positivos estándar. Se verifica que la lógica devuelva un nuevo objeto `Complejo` con los cálculos correctos. Se prueban ambas sobrecargas (con primitivos y con objetos).

```jdb
# Pruebas de Suma
print new proyectocomplejo.Complejo(3, 4).sumaComplejo(1, 2)
print new proyectocomplejo.Complejo(3, 4).sumaComplejo(new proyectocomplejo.Complejo(1, 2))

# Pruebas de Resta
print new proyectocomplejo.Complejo(5, 9).complejoResta(1, 4)
print new proyectocomplejo.Complejo(5, 9).complejoResta(new proyectocomplejo.Complejo(1, 4))

# Pruebas de Producto
print new proyectocomplejo.Complejo(2, 3).complejoProducto(4, 5)
print new proyectocomplejo.Complejo(2, 3).complejoProducto(new proyectocomplejo.Complejo(4, 5))
```

### 5. Operación de División (`complejoCociente`) - PREVENCIÓN DE ERRORES
**Decisiones tomadas (CRÍTICO):** El método `complejoCociente` realiza una división por `(r*r + i*i)`. Para cumplir estrictamente con el requisito de **no generar errores** (como `ArithmeticException: / by zero`), es imperativo que los parámetros del divisor NUNCA sean `r=0` e `i=0` simultáneamente. Los casos de prueba se han diseñado explícitamente usando divisores válidos (ej. `2` y `1`).

```jdb
# Pruebas de Cociente Seguras (Evitando división por cero)
print new proyectocomplejo.Complejo(10, 5).complejoCociente(2, 1)
print new proyectocomplejo.Complejo(10, 5).complejoCociente(new proyectocomplejo.Complejo(2, 1))
```