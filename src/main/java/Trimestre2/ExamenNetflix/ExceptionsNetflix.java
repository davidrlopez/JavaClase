package Trimestre2.ExamenNetflix;

public class ExceptionsNetflix {

    public static class DuracionException extends Exception {
        public DuracionException(String mensaje) {
            super(mensaje);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + " :" + getMessage();
        }
    }

    public static class PrecioException extends Exception {
        public PrecioException(String mensaje) {
            super(mensaje);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + " :" + getMessage();
        }
    }

    public static class GeneroException extends Exception {
        public GeneroException(String mensaje) {
            super(mensaje);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + " :" + getMessage();
        }
    }

    public static class DateFaultException extends Exception {
        public DateFaultException(String mensaje) {
            super(mensaje);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + " :" + getMessage();
        }
    }
}
