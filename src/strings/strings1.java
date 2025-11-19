package strings;

import java.util.Scanner;

public class strings1 {

  public static void main(String[] args) {
    // Test the deletrear method
    System.out.println("Original string: adios");
    System.out.println("Characters in the string:");
    deletrear("adios");

    // Additional string operations examples
    System.out.println("\n--- String Operations Examples ---");

    String text = "Hello World";
    System.out.println("Original: " + text);
    System.out.println("Length: " + text.length());
    System.out.println("Uppercase: " + text.toUpperCase());
    System.out.println("Lowercase: " + text.toLowerCase());
    System.out.println("Substring (0,5): " + text.substring(0, 5));
    System.out.println("Contains 'World': " + text.contains("World"));
    System.out.println("Index of 'o': " + text.indexOf('o'));

    // String concatenation
    String firstName = "Juan";
    String lastName = "Pedro";
    String fullName = firstName + " " + lastName;
    System.out.println("Full name: " + fullName);

    // String comparison
    String str1 = "Hello";
    String str2 = "Hello";
    String str3 = new String("Hello");
    System.out.println("str1 == str2: " + (str1 == str2));
    System.out.println("str1.equals(str3): " + str1.equals(str3));

  }

  // Method to print each character of a string (letter by letter)
  public static void deletrear(String entrada) {
    for (int i = 0; i < entrada.length(); i++) {
      System.out.println("Character " + i + ": " + entrada.charAt(i));
    }
  }
}
