public static void table1() {
    for (int i = 0; i <= 10; i++) {
        System.out.println("7x" + i + "=" + i * 7);
    }
}

public static void table2() {
    for (int i = 0; i <= 10; i++) {
        System.out.println("******************************");
        for (int j = 0; j <= 10; j++) {
            System.out.println(i + "x" + j + "=" + i * j);
        }
    }
}

public static void main(String[] args) {
    System.out.println("****************************** \n TABLA 7 \n******************************");
    table1();
    System.out.println("****************************** \n TODAS LAS TABLAS \n******************************");
    table2();
}
