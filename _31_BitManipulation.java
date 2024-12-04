public class _31_BitManipulation {

    public static void main(String[] args) {
        int num = 29; // Binary: 11101

        // Get the bit at position 3 (counting from 0)
        System.out.println("Bit at position 3: " + getBit(num, 3)); // Output: 1

        // Set the bit at position 1
        System.out.println("Number after setting bit at position 1: " + setBit(num, 1)); // Output: 31 (Binary: 11111)

        // Clear the bit at position 3
        System.out.println("Number after clearing bit at position 3: " + clearBit(num, 3)); // Output: 21 (Binary: 10101)

        System.out.println(toggleBit(num,2));
        System.out.println(isPowerOfTwo(num));
        System.out.println(isEven(num));
    }

    public static int getBit(int num, int pos) {
        return /* shifting 1 by pos means only 1 at that pos and all other 0..and multiplying  that to nything gives the bit of position with 1*/(num & (1 << pos)) != 0 ? 1 : 0;
    }

    public static int setBit(int num, int pos) {
        return num | (1 << pos);
    }

    public static int clearBit(int num, int pos) {
        return num & ~(1 << pos);
    }

    //XOR gate bitwise does the trick
    public static int toggleBit(int num, int pos) {
        return num ^ (1 << pos);
    }

    public static boolean isPowerOfTwo(int num) {
        return (num > 0) && ((num & (num - 1)) == 0);
    }

    // Function to check if a number is even using bitwise AND
    public static boolean isEven(int num) {
        return (num & 1) == 0;
    }

    public static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            num = num & (num - 1); // Removes the rightmost set bit
            count++;
        }
        return count;
    }

    public static void swap(int a, int b) {
        System.out.println("Before swap: a = " + a + ", b = " + b);
        a = a ^ b;  // Step 1: a becomes a XOR b
        b = a ^ b;  // Step 2: b becomes (a XOR b) XOR b = a
        a = a ^ b;  // Step 3: a becomes (a XOR b) XOR a = b
        System.out.println("After swap: a = " + a + ", b = " + b);
    }

    public static int getRightmostSetBit(int num) {
        return num & -num; // -num is the two's complement of num
    }

    public static int reverseBits(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = (reversed << 1) | (num & 1);  // Shift left and add the least significant bit
            num >>= 1;  // Shift right on the original number
        }
        return reversed;
    }

    public static void total_set_bits(int num) {
        //int num = 29;  // Binary: 11101
        System.out.println("Number of set bits: " + Integer.bitCount(num));  // Output: 4
    }
    /*
     * public class DivideWithoutOperators {

    public static int divide(int dividend, int divisor) {
        // Handle edge case where the dividend is 0
        if (dividend == 0) return 0;

        // Handle edge case where divisor is 1 or -1
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;  // To avoid overflow
            return -dividend;
        }

        // Handle negative numbers by determining the sign of the result
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        
        // Use absolute values for division
        long dividendAbs = Math.abs((long) dividend);
        long divisorAbs = Math.abs((long) divisor);
        
        long quotient = 0;

        // Perform division using bit shifts
        while (dividendAbs >= divisorAbs) {
            long tempDivisor = divisorAbs, multiple = 1;
            
            // Shift divisor to the left until it's larger than dividend
            while (dividendAbs >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // Subtract the shifted divisor and add the multiple to the quotient
            dividendAbs -= tempDivisor;
            quotient += multiple;
        }

        // Apply the sign
        return isNegative ? (int) -quotient : (int) quotient;
    }

    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;
        System.out.println("Result of " + dividend + " / " + divisor + " is: " + divide(dividend, divisor));
        
        dividend = -10;
        divisor = 3;
        System.out.println("Result of " + dividend + " / " + divisor + " is: " + divide(dividend, divisor));
        
        dividend = 7;
        divisor = -3;
        System.out.println("Result of " + dividend + " / " + divisor + " is: " + divide(dividend, divisor));
    }
}

     */
    
    
    
    
    
    
}
