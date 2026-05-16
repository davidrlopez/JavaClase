package Trimestre3.postgres;

public class Exceptions {

    public static class WithdrawException extends RuntimeException {

        private double currMoney;
        private double tryMoney;

        public WithdrawException(double currMoney, double tryMoney) {
            super("Insufficient balance. Current balance:" + currMoney + " and tried to withdraw:" + tryMoney);
            this.currMoney = currMoney;
            this.tryMoney = tryMoney;
        }

        public double getCurrMoney() {
            return currMoney;
        }

        public double getTryMoney() {
            return tryMoney;
        }

        public double diffMoney() {
            return tryMoney - currMoney;
        }

        public static class TransactionException extends RuntimeException {
            private int codB;
            private int codBdest;
            private double tryMoney;

            public TransactionException(int codB, int codBdest, double tryMoney) {
                super("Transaction failed for account:" + codBdest + " from:" + codB);
                this.codBdest = codBdest;
                this.codB = codB;
                this.tryMoney = tryMoney;
            }

            public int getCodB() {
                return codB;
            }

            public int getCodBdest() {
                return codBdest;
            }

            public double tryMoney() {
                return tryMoney;
            }
        }

        public static class IngreException extends RuntimeException {
            private int codB;
            private double tryMoney;
            private String dni;

            public IngreException(int codB, double tryMoney, String dni) {
                super("Ingress failed for:" + codB);

            }

            public int getCodB() {
                return codB;
            }

            public double getTryMoney() {
                return tryMoney;
            }

            public String getDni() {
                return dni;
            }
        }

        public static class ValidationException extends RuntimeException {
            private int codB;
            private String dni;

            public ValidationException(int codB, String dni) {
                super("Validation failed.Dni:" + dni + " isn't associated with account:" + codB);

            }

            public int getCodB() {
                return codB;
            }

            public String getDni() {
                return dni;
            }
        }
    }
}
