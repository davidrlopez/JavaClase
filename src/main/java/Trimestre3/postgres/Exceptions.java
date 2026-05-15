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

            public TransactionException(int codB, int codBdest, double tryMoney) {
                super("Transaction failed for account:" + codBdest + " from:" + codB);

            }

            public int getCodB() {
                return codB;
            }

            public int getCodBdest() {
                return codBdest;
            }
        }
    }
}
