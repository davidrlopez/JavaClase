import java.util.Scanner;

public class paint {
    static double tPaint;
    static double wall;

    public static double paintWall(int width, int height) {
        wall = width * height;
        return tPaint = wall * 4;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter width");
        int width = input.nextInt();
        System.out.println("Enter height");
        int height = input.nextInt();
        paintWall(width, height);
        System.out.println(tPaint + "l of paint for " + wall + "m2");
        input.close();
    }
}
