public class _37_SubsequenceSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 7;
        System.out.println(hasSubsequenceWithSum(arr, k));
    }
    
    static boolean hasSubsequenceWithSum(int[] arr, int k) {
        return findSum(arr, 0, k, 0);
    }
    
    static boolean findSum(int[] arr, int index, int target, int currSum) {
        // Base case: if we found the target sum
        if (currSum == target) {
            return true;
        }
        
        // Base case: if we've processed all elements
        if (index == arr.length) {
            return false;
        }
        
        // Include current element
        if (findSum(arr, index + 1, target, currSum + arr[index])) {
            return true;
        }
        
        // Exclude current element
        return findSum(arr, index + 1, target, currSum);
    }
}