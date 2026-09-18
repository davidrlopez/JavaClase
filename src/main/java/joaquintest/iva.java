import java.util.random.RandomGenerator;

private static double tipoIVA = 0.21;
private static double precioSinIVA;
private static double precioVenta;

public static double getTipoIVA() {
    return tipoIVA;
}

public static double getPrecioSinIVA() {
    return precioSinIVA;
}

public static double PrecioVenta(double precioSinIVA) {
    return precioVenta = getPrecioSinIVA() + (getPrecioSinIVA() * tipoIVA);
}

public static void main(String[] args) {
    RandomGenerator rng = RandomGenerator.getDefault();
    precioSinIVA = rng.nextDouble(10, 100);
    System.out.println("Precio sin IVA:" + getPrecioSinIVA());
    System.out.println("Precio con IVA:" + PrecioVenta(precioSinIVA));
}
