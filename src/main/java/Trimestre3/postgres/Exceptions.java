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
    }

}
