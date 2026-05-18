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
            private int idB;
            private int idBdest;
            private double tryMoney;

            public TransactionException(int idB, int idBdest, double tryMoney) {
                super("Transaction failed for account:" + idBdest + " from:" + idB);
                this.idBdest = idBdest;
                this.idB = idB;
                this.tryMoney = tryMoney;
            }

            public int getCodB() {
                return idB;
            }

            public int getCodBdest() {
                return idBdest;
            }

            public double tryMoney() {
                return tryMoney;
            }
        }
    }

    public static class DepositException extends RuntimeException {
        private int idB;
        private double tryMoney;
        private String dni;

        public DepositException(int idB, double tryMoney, String dni) {
            super("Ingress failed for:" + idB);

        }

        public int getCodB() {
            return idB;
        }

        public double getTryMoney() {
            return tryMoney;
        }

        public String getDni() {
            return dni;
        }
    }

    public static class ValidationException extends RuntimeException {
        private int idB;
        private String dni;

        public ValidationException(String dni) {
            super("Validation failed.Dni:" + dni + " is not a valid document");

        }

        public int getCodB() {
            return idB;
        }

        public String getDni() {
            return dni;
        }
    }

}
