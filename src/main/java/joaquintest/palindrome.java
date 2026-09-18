import java.util.Scanner;

public class palindrome {

    public static boolean palindromeM(String sent) {
        String reverse = "";
        sent = sent.toUpperCase();
        sent = sent.replace(" ", "");
        for (int i = sent.length() - 1; i >= 0; i--) {
            reverse += sent.charAt(i);
        }
        return reverse.equals(sent);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the sentence");
        String sent = input.next();
        palindromeM(sent);
        if (palindromeM(sent) == true) {
            System.out.println("It's a palindrome");
        } else {
            System.out.println("It's not a palindrome");
        }
        input.close();
    }
}
