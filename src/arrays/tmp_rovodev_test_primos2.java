package arrays;

import java.util.Arrays;

public class tmp_rovodev_test_primos2 {
    public static void main(String[] args) {
        System.out.println("=== TESTING PRIMOS2 METHOD ===");
        
        // Test primos2 method
        int[] primesArray = arraysYstrings.primos2();
        System.out.println("Prime numbers between 100 and 300:");
        System.out.println("Total primes found: " + primesArray.length);
        
        // Show first few primes
        System.out.println("First 10 primes: " + Arrays.toString(Arrays.copyOf(primesArray, Math.min(10, primesArray.length))));
        
        if (primesArray.length > 10) {
            System.out.println("Last 10 primes: " + Arrays.toString(Arrays.copyOfRange(primesArray, primesArray.length - 10, primesArray.length)));
        }
        
        // Verify they are actually prime
        System.out.println("\nVerifying first few results are actually prime:");
        for (int i = 0; i < Math.min(5, primesArray.length); i++) {
            int num = primesArray[i];
            boolean isPrime = arraysYstrings.esPrimo(num);
            System.out.println(num + " is prime: " + isPrime);
        }
        
        // Verify they are in the correct range
        boolean allInRange = true;
        for (int num : primesArray) {
            if (num < 100 || num > 300) {
                allInRange = false;
                break;
            }
        }
        System.out.println("All numbers are between 100-300: " + allInRange);
        
        System.out.println("\n=== TEST COMPLETED ===");
    }
}