class _32_Atoi {

    public static int atoi(String str) {
        return atoiHelper(str, 0, 0);
    }

    private static int atoiHelper(String str, int index, int result) {
        // Base case: If index reaches the length of the string, return the result
        if (index == str.length()) {
            return result;
        }

        // Current character as a digit
        char ch = str.charAt(index);
        
        // If the character is a digit, process it
        if (ch >= '0' && ch <= '9') {
            result = result * 10 + (ch - '0');
        }

        // Recursive call to process the next character
        return atoiHelper(str, index + 1, result);
    }

    public static void main(String[] args) {
        String str = "12345";
        System.out.println("The integer value of the string \"" + str + "\" is: " + atoi(str));  // Output: 12345
        
        str = "-12345";
        System.out.println("The integer value of the string \"" + str + "\" is: " + atoi(str));  // Output: -12345
    }
}
