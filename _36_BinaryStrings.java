/*
/                \
0                  1
/      \          /      \
00        01      10        11
/  \      /  \    /  \      /  \
000  001  010  011  100  101  110  111

*/


public class _36_BinaryStrings {
    public static void main(String[] args) {
        int n = 3; // length of binary strings
        generateBinary(n);
    }
    
    static void generateBinary(int n) {
        char[] str = new char[n];
        generateBinaryRec(n, str, 0);
    }
    
    static void generateBinaryRec(int n, char[] str, int index) {
        // Base case: if index reaches n, we've built a complete string
        if (index == n) {
            System.out.println(String.valueOf(str));
            return;
        }
        
        // Put 0 at current position and recur for remaining
        str[index] = '0';
        generateBinaryRec(n, str, index + 1);
        
        // Put 1 at current position and recur for remaining
        str[index] = '1';
        generateBinaryRec(n, str, index + 1);
    }
}