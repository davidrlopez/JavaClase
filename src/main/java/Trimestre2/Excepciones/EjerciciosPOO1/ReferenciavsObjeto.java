package Trimestre2.Excepciones.EjerciciosPOO1;

// A simple mutable class to demonstrate object behavior
class Contenedor {
  int valor;

  public Contenedor(int valor) {
    this.valor = valor;
  }
}

public class ReferenciavsObjeto {

  // 1. PRIMITIVES: Passed by Value
  // The method gets a copy of the actual value.
  // Modifying 'n' here only changes the local copy on the stack.
  public static void modificarPrimitivo(int n) {
    System.out.println("   [Inside method] Received n = " + n);
    n = 99; // modifying the local copy
    System.out.println("   [Inside method] Changed local n to " + n);
  }

  // 2. OBJECTS: Reference Passed by Value (Modifying State)
  // The method gets a copy of the REFERENCE (the memory address).
  // Both the caller's variable and this parameter point to the SAME object on the
  // Heap.
  // Therefore, changes to the object's fields are visible everywhere.
  public static void modificarEstadoObjeto(Contenedor c) {
    System.out.println("   [Inside method] Received object with valor = " + c.valor);
    c.valor = 99; // modifying the actual object on the heap
    System.out.println("   [Inside method] Modified object field to " + c.valor);
  }

  // 3. OBJECT REASSIGNMENT
  // We can change the object's fields (like above), but we cannot change
  // where the ORIGINAL reference points to.
  // When we say 'c = new ...', we are just pointing the LOCAL reference 'c'
  // to a new object. The caller's reference still points to the old object.
  public static void reasignarReferencia(Contenedor c) {
    System.out.println("   [Inside method] Received object " + c);
    c = new Contenedor(555); // c now points to a NEW object in memory
    System.out.println("   [Inside method] Reassigned local c to NEW object " + c + " with valor " + c.valor);
  }

  // 4. ARRAYS: Are Objects
  // In Java, arrays are objects. Passing an array passes the reference to the
  // array.
  // Modifying the contents of the array affects the original array.
  public static void modificarArray(int[] arr) {
    System.out.println("   [Inside method] Received array[0] = " + arr[0]);
    arr[0] = 99;
    System.out.println("   [Inside method] Changed array[0] to " + arr[0]);
  }

  public static void main(String[] args) {
    System.out.println("=========================================");
    System.out.println("COMPARISON: REFERENCES VS PRIMITIVES");
    System.out.println("=========================================\n");

    // --- Case 1: Primitives ---
    System.out.println("--- 1. Primitives (Pass by Value) ---");
    int numero = 10;
    System.out.println("Before: numero = " + numero);
    modificarPrimitivo(numero);
    System.out.println("After:  numero = " + numero + " (Unchanged)");
    System.out.println("Explanation: primitives pass a COPY of the data.\n");

    // --- Case 2: Objects (Modifying State) ---
    System.out.println("--- 2. Objects (Modifying Internal State) ---");
    Contenedor obj1 = new Contenedor(10);
    System.out.println("Before: obj1.valor = " + obj1.valor);
    modificarEstadoObjeto(obj1);
    System.out.println("After:  obj1.valor = " + obj1.valor + " (CHANGED)");
    System.out.println("Explanation: References point to the same location in memory.\n");

    // --- Case 3: Objects (Reassigning Reference) ---
    System.out.println("--- 3. Objects (Reassigning Reference) ---");
    Contenedor obj2 = new Contenedor(10);
    System.out.println("Before: obj2.valor = " + obj2.valor);
    reasignarReferencia(obj2);
    System.out.println("After:  obj2.valor = " + obj2.valor + " (Unchanged)");
    System.out.println(
        "Explanation: Reassigning the parameter only affects the local variable, not the original reference.\n");

    // --- Case 4: Arrays ---
    System.out.println("--- 4. Arrays (Are Objects) ---");
    int[] miArray = { 10 };
    System.out.println("Before: miArray[0] = " + miArray[0]);
    modificarArray(miArray);
    System.out.println("After:  miArray[0] = " + miArray[0] + " (CHANGED)");
    System.out.println("Explanation: Arrays behave exactly like objects.\n");
  }
}
