import java.util.*;

public class _38_SubArrayVsSubsequence {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        
        System.out.println("All Subarrays:");
        printSubarrays(arr);
        
        System.out.println("\nAll Subsequences:");
        ArrayList<Integer> list = new ArrayList<>();
        printSubsequences(arr, 0, list);
    }
    
    static void printSubarrays(int[] arr) {
        for(int start = 0; start < arr.length; start++) {
            for(int end = start; end < arr.length; end++) {
                for(int i = start; i <= end; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }
    }
    
    static void printSubsequences(int[] arr, int index, ArrayList<Integer> list) {
        if(index == arr.length) {
            System.out.println(list);
            return;
        }
        // Include
        list.add(arr[index]);
        printSubsequences(arr, index + 1, list);
        // Exclude
        list.remove(list.size() - 1);
        printSubsequences(arr, index + 1, list);
    }
}