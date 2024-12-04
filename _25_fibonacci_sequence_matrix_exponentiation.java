//_25_fibonacci_sequence_matrix_exponentiation 

public class _25_fibonacci_sequence_matrix_exponentiation 
{
    
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        int n = 50; // Example input, change as needed
        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
    }

    // Function to calculate the nth Fibonacci number using matrix exponentiation
    public static long fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long[][] F = {{1, 1}, {1, 0}};
        power(F, n - 1);

        return F[0][0];  // Result is stored in F[0][0]
    }

    // Function to raise matrix F to the power n using exponentiation by squaring
    private static void power(long[][] F, int n) {
        if (n == 0 || n == 1) return;

        long[][] M = {{1, 1}, {1, 0}};
        power(F, n / 2);
        multiply(F, F);

        if (n % 2 != 0) {
            multiply(F, M);
        }
    }

    // Function to multiply two matrices and store the result in the first matrix
    private static void multiply(long[][] F, long[][] M) {
        long x = (F[0][0] * M[0][0] % MOD + F[0][1] * M[1][0] % MOD) % MOD;
        long y = (F[0][0] * M[0][1] % MOD + F[0][1] * M[1][1] % MOD) % MOD;
        long z = (F[1][0] * M[0][0] % MOD + F[1][1] * M[1][0] % MOD) % MOD;
        long w = (F[1][0] * M[0][1] % MOD + F[1][1] * M[1][1] % MOD) % MOD;

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }
}
