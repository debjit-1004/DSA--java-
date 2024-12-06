public class _34_MaxConsecutiveOnes {

    // Function to find the maximum number of consecutive 1s in a binary array
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;     // To store the maximum count of consecutive 1s
        int currentCount = 0; // To store the current count of consecutive 1s

        for (int num : nums) {
            if (num == 1) {
                currentCount++;  // Increment count if the element is 1
            } else {
                maxCount = Math.max(maxCount, currentCount);  // Update maxCount
                currentCount = 0;  // Reset currentCount
            }
        }

        // Final check for the last sequence of 1s
        maxCount = Math.max(maxCount, currentCount);

        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println("Maximum consecutive 1s: " + findMaxConsecutiveOnes(nums));  // Output: 3

        nums = new int[]{1, 0, 1, 1, 0, 1};
        System.out.println("Maximum consecutive 1s: " + findMaxConsecutiveOnes(nums));  // Output: 2
    }
}
