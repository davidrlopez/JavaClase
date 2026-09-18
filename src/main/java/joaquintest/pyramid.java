import java.util.Scanner;

private static int ask;

public static void pyramid0() {
    for (int i = 0; i <= 7; i++) {
        for (int j = 0; j <= i; j++) {
            System.out.print('*');
        }
        System.out.println("");
    }
}

public static void pyramid1() {
    for (int i = 7; i >= 0; i--) {
        for (int j = 0; j <= i; j++) {
            System.out.print('*');
        }
        System.out.println("");
    }
}

public static void pyramid2() {
    pyramid0();
    pyramid1();
}

public static void pyramid3() {
    int rows = 8;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < rows - i - 1; j++) {
            System.out.print(" ");
        }
        for (int x = 0; x <= i; x++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    ask = input.nextInt();
    switch (ask) {
        case 0:
            pyramid0();
            break;
        case 1:
            pyramid1();
            break;
        case 2:
            pyramid2();
            break;
        case 3:
            pyramid3();
            break;
        default:
            break;
    }
    input.close();
}
